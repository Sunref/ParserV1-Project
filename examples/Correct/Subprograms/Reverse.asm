   BR L5
L0:
   PROC 2
   LDLADDR 8
   GETCH
   STORE2B
   LDCB 0
   LDCB 0
   LDLADDR 8
   LOAD2B
   LDCB 0
   LDCB 0
   LDCCH 'E'
   CMP
   BZ L3
   CALL L0
L3:
L4:
   LDLADDR 8
   LOAD2B
   PUTCH
   RET 0
L5:
   CALL L0
   HALT
