   PROGRAM 4
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
   LDLADDR -8
   LOADW
   LDLADDR -8
   LOADW
   LOADW
   LDCINT 1
   ADD
   STOREW
   BR L4
L3:
   RET 8
L4:
   RET 8
L5:
   LDGADDR 0
   LDCINT 13
   STOREW
   LDGADDR 0
   LDCINT 10
   CALL L0
   LDCSTR "n = "
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   HALT
