   PROGRAM 8
   BR L10
L0:
   PROC 0
   LDLADDR -9
   LDLADDR -8
   LOADW
   LDLADDR -4
   LOADW
   CMP
   BGE L1
   LDCB 1
   BR L2
L1:
   LDCB 0
L2:
   STOREB
   RET 8
L3:
   PROC 0
   LDLADDR -1
   LOADB
   BZ L4
   LDCSTR "true"
   PUTSTR
   BR L5
L4:
   LDCSTR "false"
   PUTSTR
L5:
   RET 1
L10:
L6:
   LDCSTR "Enter value for a (0 to exit):  "
   PUTSTR
   LDGADDR 0
   GETINT
   STOREW
   LDCSTR "a = "
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   PUTEOL
   LDGADDR 0
   LOADW
   LDCINT 0
   CMP
   BZ L7
   LDCSTR "Enter value for b:  "
   PUTSTR
   LDGADDR 4
   GETINT
   STOREW
   LDCSTR "b = "
   PUTSTR
   LDGADDR 4
   LOADW
   PUTINT
   PUTEOL
   PUTEOL
   LDCSTR "lessThan("
   PUTSTR
   LDGADDR 0
   LOADW
   PUTINT
   LDCSTR ", "
   PUTSTR
   LDGADDR 4
   LOADW
   PUTINT
   LDCSTR ") = "
   PUTSTR
   ALLOC 1
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   CALL L0
   CALL L3
   PUTEOL
   PUTEOL
   BR L6
L7:
   LDCSTR "Done."
   PUTSTR
   PUTEOL
   HALT
