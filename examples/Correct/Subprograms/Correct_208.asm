   PROGRAM 4
   BR L2
L0:
   PROC 0
   LDLADDR -4
   LDLADDR -4
   LOADW
   LDCINT 1
   ADD
   STOREW
   LDCSTR "x = "
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   LDCSTR "n = "
   PUTSTR
   LDLADDR -4
   LOADW
   PUTINT
   PUTEOL
   RET 4
L1:
   PROC 0
   LDLADDR -4
   LOADW
   LDLADDR -4
   LOADW
   LOADW
   LDCINT 1
   ADD
   STOREW
   LDCSTR "x = "
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   LDCSTR "n = "
   PUTSTR
   LDLADDR -4
   LOADW
   LOADW
   PUTINT
   PUTEOL
   LDLADDR -4
   LOADW
   LOADW
   CALL L0
   RET 4
L2:
   LDGADDR 0
   LDCINT 5
   STOREW
   LDGADDR 0
   CALL L1
   LDCSTR "x = "
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   HALT
