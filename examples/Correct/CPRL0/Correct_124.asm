   PROGRAM 6
   LDGADDR 4
   LDCCH 'Z'
   STORE2B
   LDCSTR "Enter 2 characters: "
   PUTSTR
   LDGADDR 0
   GETCH
   STORE2B
   LDGADDR 2
   GETCH
   STORE2B
   PUTEOL
   LDCSTR "c1 = "
   PUTSTR
   LDGADDR 0
   LOAD2B
   PUTCH
   PUTEOL
   LDCSTR "c2 = "
   PUTSTR
   LDGADDR 2
   LOAD2B
   PUTCH
   PUTEOL
   LDCSTR "c3 = "
   PUTSTR
   LDGADDR 4
   LOAD2B
   PUTCH
   PUTEOL
   HALT
