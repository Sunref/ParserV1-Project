   PROGRAM 2
   BR L1
L0:
   PROC 0
   LDLADDR -4
   LOADW
   LOAD2B
   PUTCH
   LDCSTR "   "
   PUTSTR
   LDLADDR -4
   LOADW
   LDCCH 'B'
   STORE2B
   LDLADDR -4
   LOADW
   LOAD2B
   PUTCH
   LDCSTR "   "
   PUTSTR
   LDLADDR -4
   LOADW
   LDCCH 'C'
   STORE2B
   RET 4
L1:
   LDGADDR 0
   LDCCH 'A'
   STORE2B
   LDGADDR 0
   CALL L0
   LDGADDR 0
   LOAD2B
   PUTCH
   PUTEOL
   HALT
