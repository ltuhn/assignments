'''
Brukeren skal oppgi to datoer og to måneder, og programmet avgjør om den første
datoen kommer tidligst eller om det er den andre datoen kommer tidligst.
Avhengig av dette resultatet vil programmet si om det er riktig eller feil
rekkefølge, eller at det er samme dato.
'''
# Int foran input gjør om brukerens string til en integer, heltall (int)
dato1 = int(input("Vennligst oppgi en dag i form av heltall: "))
'''
For å hindre at bruker ikke skriver inn en dato eller måned som ikke
eksisterer
'''
if dato1 == 0:
    print("Dette hørtes ikke ut som en gyldig dato")
# For å hindre at programmet går videre med spørsmålene, avsluttes den her
    import sys
    sys.exit()
'''
Hvis dato er større enn 31, vil det skrives ut det som kommer etter print,
og programmet avsluttes
'''
if dato1 > 31:
    print("Dette hørtes ikke ut som en gyldig dato")
    import sys
    sys.exit()

maaned1 = int(input("Deretter oppgi en maaned i form av heltall: "))
if maaned1 == 0:
    print("Dette hørtes ikke ut som en gyldig måned")
    import sys
    sys.exit()
if maaned1 > 12:
    print("Dette hørtes ikke ut som en gyldig måned")
    import sys
    sys.exit()

'''
Her forventes det at brukeren skriver inn et tall
'''
dato2 = int(input("Takk, vennligst oppgi en ny dag i form av heltall: "))
if dato2 == 0:
    print("Dette hørtes ikke ut som en gyldig dato")
    import sys
    sys.exit()
if dato2 > 31:
    print("Dette hørtes ikke ut som en gyldig dato")
    import sys
    sys.exit()

maaned2 = int(input("Skriv inn en maaned til i form av heltall: "))
if maaned2 == 0:
    print("Dette hørtes ikke ut som en gyldig måned")
    import sys
    sys.exit()
if maaned2 > 12:
    print("Dette hørtes ikke ut som en gyldig måned")
    import sys
    sys.exit()

# Disse variablene kombinerer datoene og månedene som brukeren skrev inn
resultat1 = dato1 + maaned1
resultat2 = dato2 + maaned2

# Hvis resultat1 sin verdi er lavere enn resultat2 sin, kommer dette opp:
if resultat1 < resultat2:
    print("Riktig rekkefølge!")
'''
Hvis resultat1 sin verdi er høyere enn resultat2 sin, vil det stå
"Feil rekkefølge". Dette vil ikke dukke opp om den første if-betingelsen er
oppfylt pga. elif
'''
elif resultat1 > resultat2:
    print("Feil rekkefølge!")
# Hvis resultat1 er nøyaktig det samme som resultat2, kommer dette opp:
elif resultat1 == resultat2:
    print("Samme dato!")
