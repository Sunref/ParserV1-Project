   PROGRAM 4
   BR L1
L0:
   PROC 0
   LDLADDR -4
   LOADW
   LOADW
   PUTINT
   LDCSTR "   "
   PUTSTR
   LDLADDR -4
   LOADW
   LDCINT 6
   STOREW
   LDGADDR 0
   LOADW
   PUTINT
   LDCSTR "   "
   PUTSTR
   LDLADDR -4
   LOADW
   LDCINT 7
   STOREW
   RET 4
L1:
   LDGADDR 0
   LDCINT 5
   STOREW
   LDGADDR 0
   CALL L0
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   HALT
