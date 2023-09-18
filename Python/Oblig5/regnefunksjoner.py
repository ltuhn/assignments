# Oblig 5 | Oppg. 1
# Programmet tar inn flere ulike tall fra brukeren og gjoer tallene om fra tommer til centimeter, deler, adderer og subtraherer dem.
def addisjon(nummer1, nummer2): # definerer funksjonen "addisjon" som tar inn argumentene "nummer1" og "nummer2"
    sum = nummer1 + nummer2 # variabelen "sum" er summen av nummer1 og nummer2
    assert sum < 950 # sjekker at variabelen "sum" er mindre enn 950, hvis ikke kommer dette opp som feilmelding
    assert sum > -950 # sjekker at variabelen "sum" er stoerre enn -950, hvis ikke kommer dette opp som feilmelding
    assert sum != 0 # samme som over bare at den sjekker om sum ikke er 0
    return sum # returnerer til slutt sum

def subtraksjon(nummer1, nummer2): # definerer funksjonen "subtraksjon" som tar inn argumentene "nummer1" og "nummer2"
    resultatS = nummer1 - nummer2 # resultatS lagrer resultatet av nummer1 - nummer2
    assert resultatS < 950 # samme som assert i funksjonen "addisjon"
    assert resultatS > -950
    assert resultatS != 0
    return resultatS # returnerer resultatS

def divisjon(nummer1, nummer2): # definerer funksjonen "divisjon" som tar inn argumentene "nummer1" og "nummer2"
    resultatD = nummer1 / nummer2 # resultatD er resultatet av "nummer1" delt paa "nummer2"
    assert resultatD < 950 # samme som assert i funksjonen "addisjon"
    assert resultatD > -950
    assert resultatD != 0
    return resultatD # returnerer resultatD

def tommerTilCm(antallTommer): # definerer funksjonen "tommerTilCm" som tar inn argumentet "antallTommer"
    assert antallTommer > 0, 'maa vaere stoerre enn 0' # sjekker om antallTommer er stoerre enn 0, hvis ikke kommer denne linjen som feilmelding
    tilCm = antallTommer*2.54 # lager variabelen "tilCm" som ganger antallTommer med 2.54 for aa gjoere tommer om til cm
    return tilCm # returnerer tilCm

def skrivBeregninger(): # definerer prosedyren "skrivBeregninger"
    a = float(input('skriv inn tall nr 1: ')) # bruker maa skrive inn et flyttall som lagres i "a"
    b = float(input('skriv inn tall nr 2: ')) # samme som over men lagres i "b"

    print('addisjon: ', addisjon(a,b), 'subtraksjon: ', subtraksjon(a,b), 'divisjon: ', divisjon(a,b)) # kaller funksjonene addisjon, subtraksjon og divisjon for aa gjoere beregninger,
                                                                                                       # fordi resultatene av beregningene har blitt returnert i alle funksjonene vil bare resultatet og ikke hele innholdet i funksjonene printes ut

    a = int(input('skriv inn nytt tall: ')) # bruker maa skrive inn et heltall som lagres i "a"

    print(a, 'tommer gitt i cm: ', tommerTilCm(a)) # kaller paa funksjonen tommerTilCm for aa beregne a om til cm ved aa sende inn argumentet a som brukeren skrev. Resultatet printes ut i terminalen

def heltall(): # definerer prosedyren "heltall"
    a = 1 # lagrer verdien 1 i a
    b = 2 # lagrer verdien 2 i b
    print('addisjon: ', addisjon(a,b)) # kaller paa funksjonen "addisjon" og sender inn argumentene a (1) og b (2) fra "heltall", printer saa ut addisjon sin return som er a + b

    a = -3 # erstatter verdien i a med -3
    b = -8 # erstatter verdien i b med -8
    print('subtraksjon: ', subtraksjon(a,b)) # samme som forrige print men kaller paa funksjonen "subtraksjon" i stedet, med de nye verdiene i variablene a og b

    a = 10 # erstatter verdien i a igjen med 10
    b = -2 # erstatter verdien i b igjen med -2
    print('divisjon: ', divisjon(a,b)) # samme som forrige print men kaller paa funksjonen "divisjon"

def tommer(): # definerer prosedyren tommer
    tomInp = int(input('skriv inn tommer: ')) # bruker maa skrive inn et heltall som lagres i variabelen "tomInp"
    print(tomInp, 'tommer gitt i cm. er', tommerTilCm(tomInp)) # kaller paa funksjonen tommerTilCm og sender inn variabelen tomInp som argument. Printer ut resultatet (return) av tommerTilCm

heltall() # kaller paa prosedyren heltall slik at den "settes i gang"
tommer() # kaller paa prosedyren tommer
skrivBeregninger() # kaller paa prosedyren skrivBeregninger
