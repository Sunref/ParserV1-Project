   PROGRAM 2
   BR L15
L0:
   PROC 0
   LDLADDR -1
   LOADB
   BZ L1
   LDCSTR "true"
   PUTSTR
   PUTEOL
   BR L2
L1:
   LDCSTR "false"
   PUTSTR
   PUTEOL
L2:
   RET 1
L15:
   LDGADDR 0
   LDCB 1
   STOREB
   LDGADDR 1
   LDCB 1
   STOREB
   LDGADDR 0
   LOADB
   CALL L0
   LDGADDR 0
   LOADB
   NOT
   CALL L0
   LDGADDR 0
   LOADB
   BNZ L3
   LDCB 0
   BR L4
L3:
   LDGADDR 1
   LOADB
L4:
   CALL L0
   LDGADDR 0
   LOADB
   BNZ L5
   LDCB 0
   BR L6
L5:
   LDGADDR 1
   LOADB
   NOT
L6:
   CALL L0
   LDGADDR 0
   LOADB
   NOT
   BNZ L7
   LDCB 0
   BR L8
L7:
   LDGADDR 1
   LOADB
   NOT
L8:
   CALL L0
   LDGADDR 0
   LOADB
   BZ L9
   LDCB 1
   BR L10
L9:
   LDGADDR 1
   LOADB
L10:
   CALL L0
   LDGADDR 0
   LOADB
   BZ L11
   LDCB 1
   BR L12
L11:
   LDGADDR 1
   LOADB
   NOT
L12:
   CALL L0
   LDGADDR 0
   LOADB
   NOT
   BZ L13
   LDCB 1
   BR L14
L13:
   LDGADDR 1
   LOADB
   NOT
L14:
   CALL L0
   HALT
