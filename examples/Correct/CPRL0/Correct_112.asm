   PROGRAM 8
   LDCB 1
   NOT
   PUTBYTE
   PUTEOL
   LDCB 0
   NOT
   PUTBYTE
   PUTEOL
   LDGADDR 0
   LDCINT 5
   STOREW
   LDGADDR 4
   LDCINT 2
   LDGADDR 0
   LOADW
   MUL
   LDCINT 1
   SUB
   STOREW
L0:
   LDGADDR 0
   LOADW
   LDCINT 2
   LDCINT 5
   MUL
   CMP
   BG L1
   LDGADDR 0
   LDGADDR 0
   LOADW
   LDCINT 1
   ADD
   STOREW
   LDGADDR 0
   LOADW
   LDCINT 2
   MOD
   LDCINT 0
   CMP
   BNZ L9
   LDCSTR "even"
   PUTSTR
   PUTEOL
   BR L10
L9:
   LDGADDR 0
   LOADW
   LDCINT 2
   MOD
   LDCINT 1
   CMP
   BNZ L8
   LDCSTR "odd"
   PUTSTR
   PUTEOL
   BR L10
L8:
   LDCSTR "weird"
   PUTSTR
   PUTEOL
L10:
   LDGADDR 0
   LOADW
   LDCINT 9
   CMP
   BZ L1
   BR L0
L1:
   HALT
