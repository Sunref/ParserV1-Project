   PROGRAM 12
   LDGADDR 0
   LDCINT 16
   STOREW
   LDGADDR 4
   LDCINT 4
   STOREW
   LDGADDR 8
   LDCINT 2
   STOREW
   LDCSTR " left-associative: "
   PUTSTR
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   SUB
   LDGADDR 8
   LOADW
   SUB
   PUTINT
   PUTEOL
   LDCSTR "right-associative: "
   PUTSTR
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   LDGADDR 8
   LOADW
   SUB
   SUB
   PUTINT
   PUTEOL
   LDCSTR "             cprl: "
   PUTSTR
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   SUB
   LDGADDR 8
   LOADW
   SUB
   PUTINT
   PUTEOL
   PUTEOL
   LDCSTR " left-associative: "
   PUTSTR
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   DIV
   LDGADDR 8
   LOADW
   DIV
   PUTINT
   PUTEOL
   LDCSTR "right-associative: "
   PUTSTR
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   LDGADDR 8
   LOADW
   DIV
   DIV
   PUTINT
   PUTEOL
   LDCSTR "             cprl: "
   PUTSTR
   LDGADDR 0
   LOADW
   LDGADDR 4
   LOADW
   DIV
   LDGADDR 8
   LOADW
   DIV
   PUTINT
   PUTEOL
   HALT
