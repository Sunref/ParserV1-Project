   PROGRAM 4
   BR L9
L0:
   PROC 0
   LDLADDR -4
   LOADW
   LDCINT 0
   CMP
   BL L3
   LDLADDR -8
   LDLADDR -4
   LOADW
   STOREW
   RET 4
   BR L4
L3:
   LDLADDR -8
   LDLADDR -4
   LOADW
   NEG
   STOREW
   RET 4
L4:
L9:
L5:
   LDCSTR "Enter an integer: "
   PUTSTR
   LDGADDR 0
   GETINT
   STOREW
   LDCSTR "abs("
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   LDCSTR ") = "
   PUTSTR
   ALLOC 4
   LDGADDR 0
   LOADW
   CALL L0
   PUTINT
   PUTEOL
   LDGADDR 0
   LOADW
   LDCINT 0
   CMP
   BZ L6
   BR L5
L6:
   HALT
