   PROGRAM 8
   BR L1
L0:
   PROC 4
   LDLADDR 8
   LDCINT 2
   STOREW
   LDLADDR -8
   LOADW
   LDLADDR -4
   LOADW
   LDLADDR 8
   LOADW
   ADD
   STOREW
   LDCSTR "m = "
   PUTSTR
   LDLADDR -8
   LOADW
   LOADW
   PUTINT
   LDCSTR ", n = "
   PUTSTR
   LDLADDR -4
   LOADW
   PUTINT
   LDCSTR ", k = "
   PUTSTR
   LDLADDR 8
   LOADW
   PUTINT
   PUTEOL
   RET 8
L1:
   LDGADDR 0
   LDCINT 5
   STOREW
   LDGADDR 4
   LDCINT 6
   STOREW
   LDGADDR 0
   LDGADDR 4
   LOADW
   CALL L0
   LDCSTR "x = "
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   LDCSTR ", y = "
   PUTSTR
   LDGADDR 4
   LOADW
   PUTINT
   PUTEOL
   HALT
