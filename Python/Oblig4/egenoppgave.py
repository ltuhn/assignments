#   Oblig 4 | Oppg. 5
#   Velg mellom aa se en forhandslagd liste over navn og bursdagene deres eller legge til
#   navn og bursdag i samme liste.
bursdagsDict = { #lager ordbok der hvor noekkelverdi er navn, innholdsverdi er bursdagsdato
    "Barack": "05.10.97",
    "Ronald": "06.10.01",
    "Donald": "03.09.98",
    "George": "13.12.2001"
}

def displayList(): #definerer prosedyre displayList
    for person in bursdagsDict: #for-loekke gaar gjennom alle personene/bursdagene i ordboka bursdagsDict helt til den er naadd bunnen
        print('Navn: ', person, 'Bursdag: ', bursdagsDict.get(person)) #i lopet av lokka printes det ut "person" som er noekkelverdien
                                                                       #og henter noekkelverdiens tilsvarerende innholdsverdi som er bursdagen. (viser liste over navn og bursdager)

def addPerson(): #definerer prosedyre addPerson
    navn = input('Skriv inn navn: ') #person maa oppgi et navn som lagres i variabelen navn
    bursdag = input('Skriv inn bursdag: ') #bruker-input lagres i "bursdag"

    bursdagsDict[navn] = bursdag #legger til navnet fra bruker-input som er lagret i "navn" som noekkelverdi i ordboka bursdagsDict og bursdagen i "bursdag" som innholdsverdi
    displayList() #kaller paa prosedyren displayList
    menyValg() #kaller deretter paa prosedyren menyValg

def menyValg(): #definerer prosedyre menyValg
    valg = input('Vil du se liste over bursdager, velg 1.\nVil du legge til ny person, velg 2.\nVil du avslutte, velg 3\n') #forventer at bruker skriver inn 1, 2 eller 3

    if valg == "1": #hvis bruker skrev inn 1...
        displayList() #... kaller vi paa prosedyren displayList
    elif valg == "2": #ellers, hvis bruker skrev inn 2...
        addPerson() #... kaller vi paa prosedyren addPerson
    elif valg == "3": #hvis bruker skrev inn 3...
        exit() #... avsluttes programmet
    else: #hvis bruker verken skrev inn 1, 2 eller 3...
        print('Det er ikke et valg smarting') #skrives dette ut...
    menyValg() #... og da kaller vi paa prosedyren menyValg (menyValg kaller paa seg selv, vi kommer tilbake til begynnelsen av prosedyren)

menyValg() #kaller paa prosedyren menyValg
