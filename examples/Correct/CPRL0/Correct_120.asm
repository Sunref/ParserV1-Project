   PROGRAM 5
   LDGADDR 0
   LDCINT 5
   STOREW
   LDGADDR 4
   LDGADDR 0
   LOADW
   LDCINT 10
   CMP
   BG L0
   LDCB 1
   BR L1
L0:
   LDCB 0
L1:
   NOT
   STOREB
   LDGADDR 4
   LOADB
   BZ L2
   LDCSTR "not (x <= 10)"
   PUTSTR
   PUTEOL
   BR L3
L2:
   LDCSTR "x <= 10"
   PUTSTR
   PUTEOL
L3:
   HALT
