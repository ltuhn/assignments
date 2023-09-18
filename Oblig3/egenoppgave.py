#   OPPGAVE 5
#   Brukeren maa lage to fantasipersoner og oppgi deres navn, alder og adresse.
#   Saa kan brukeren velge om de vil slette en av dem, eller faa en oversikt over informasjonen de skrev om
#   en av personene.
#Lager tom ordbok som heter personD
personD = {}
#Skriver ut stringen Fantasiperson 1
print("Fantasiperson 1")
#Bruker maa oppgi et fornavn som lagres i variabelen fnameA
fnameA = input("Hva heter personen til fornavn?: ")
#Samme som over bare med et etternavn i variabel snameA
snameA = input("Hva heter personen til etternavn?: ")
#Lager variabel som konkatinerer navnene som er lagret i fnameA og snameA sammen med et mellomrom mellom dem
nameA = fnameA + " " + snameA

#Bruker maa oppgi en alder som lagres i form av int i variabel ageA
ageA = int(input("Hvor gammel er personen?: "))
#int-inputen gjoeres om til string slik at den kan konkatineres med stringen "Alder: " og lagres i ageeA
ageeA = "Alder" + ": " + str(ageA)

#forventer at bruker skriver inn en andresse
adrA = input("Til slutt, hva er adressen til personen?: ")
#adressen konkatineres med stringen "Adresse: " i adrrA
adrrA = "Adresse" + ": " + adrA

#oppdaterer ordboka personD ved aa legge til navnet brukeren skrev inn tidligere som noekkelverdi og alder + adresse som innholdsverdi
personD.update({nameA: [ageeA, adrrA]})

#Skriver ut stringen Fantasiperson 2
print("Fantasiperson 2")
#Samme som fnameA
fnameB = input("Hva heter personen til fornavn?: ")
#Samme som snameA
snameB = input("Hva heter personen til etternavn?: ")
#Samme som nameA
nameB = fnameB + " " + snameB

#Samme som ageA
ageB = input("Hvor gammel er personen?: ")
#Samme som ageeA
ageeB = "Alder" + ": " + str(ageB)

#Samme som adrA
adrB = input("Til slutt, hva er adressen til personen?: ")
#Samme som adrrA
adrrB = "Adresse" + ": " + adrB

#oppdaterer ordboka personD ved aa legge til navnet brukeren skrev inn (igjen) som noekkelverdi og alder + adresse som innholdsverdi
personD.update({nameB: [ageeB, adrrB]})

#definerer prosedyre som heter menu
def menu():
    #lager for-loop som avsluttes naar den har naad bunnen av noekkel- og innholdsverdiene i ordboka personD
    for key, value in personD.items():
        #printer ut noekkelverdiene (navnene paa personene) i personD
        print(key)
    #forventer at bruker taster inn 1 eller 2 etter hva brukeren vil gjoere
    inpA = int(input("Hva oensker du aa gjoere?: 1. Slette en fantasiperson 2. Vite mer om en fantasiperson\n"))
    #hvis bruker taster inn 1
    if inpA == 1:
        #da maa bruker skrive inn det eksakte navnet paa personen de oensker aa slette, eller skrive "avbryt"
        inpB = input("Skriv inn navnet paa den du oensker aa slette, eller skriv avbryt for aa avbryte: ")
        #dersom navnet brukeren skrev inn eksisterer i ordboka personD
        if inpB in personD:
            #da slettes den gitte noekkelverdien (sammen med innholdsverdien) i personD
            personD.pop(inpB)
            #kaller paa prosedyren menu paa nytt saa man kommer tilbake til begynnelsen
            menu()
        #ellers hvis man skriver noeyaktig inn "avbryt"
        elif inpB == "avbryt":
            #da kalles prosedyren menu paa nytt saa man kommer tilbake til begynnelsen
            menu()
        #om brukeren ellers skriver inn som helst annet
        else:
            #da kommer denne feilmeldingen opp
            print("Skriv inn noe som er gyldig")
    #hvis brukeren skriver inn 2 (vite mer om en fantasiperson)
    elif inpA == 2:
        #da maa bruker oppgi navnet paa personen de oensker aa vite mer om eller skrive "avbryt"
        inpC = input("Skriv inn navnet paa den du oensker aa vite mer om, eller skriv avbryt for aa avbryte: ")
        #hvis navnet brukeren skrev inn eksisterer i ordboka personD
        if inpC in personD:
            #da printes ut innholdsverdiene (alder og adresse) som er knyttet til noekkelverdien (navnet brukeren skrev)
            print(personD[inpC])
        #ellers, hvis bruker skriver inn "avbryt"
        elif inpC == "avbryt":
            #da blir prosedyren menu kalt paa, som betyr at menu kjoeres paa nytt fra begynnelsen
            menu()
        #ellers hvis brukeren skriver inn noe som helst annet
        else:
            #da kommer denne feilmeldingen opp
            print("Skriv inn noe som er gyldig")

#kaller paa prosedyren menu
menu()
