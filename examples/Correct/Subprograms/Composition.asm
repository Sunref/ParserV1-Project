   BR L2
L0:
   PROC 0
   LDLADDR -8
   LDCINT 3
   LDLADDR -4
   LOADW
   MUL
   LDCINT 1
   SUB
   STOREW
   RET 4
L1:
   PROC 0
   LDLADDR -8
   LDLADDR -4
   LOADW
   LDCINT 4
   ADD
   STOREW
   RET 4
L2:
   ALLOC 4
   ALLOC 4
   LDCINT 3
   CALL L1
   CALL L0
   PUTINT
   PUTEOL
   ALLOC 4
   ALLOC 4
   LDCINT 3
   CALL L0
   CALL L1
   PUTINT
   PUTEOL
   HALT
