   PROGRAM 8
   BR L5
L0:
   PROC 0
   LDLADDR -8
   LOADW
   LOADW
   LDLADDR -4
   LOADW
   CMP
   BGE L3
   RET 8
   BR L4
L3:
   LDLADDR -8
   LOADW
   LDLADDR -4
   LOADW
   LDCINT 3
   ADD
   STOREW
L4:
   RET 8
L5:
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
   LDGADDR 0
   LDCINT 6
   STOREW
   LDGADDR 4
   LDCINT 5
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
