   BR L1
L0:
   PROC 0
   LDLADDR -4
   LDCINT 42
   STOREW
   RET 0
L1:
   ALLOC 4
   CALL L0
   PUTINT
   PUTEOL
   HALT
