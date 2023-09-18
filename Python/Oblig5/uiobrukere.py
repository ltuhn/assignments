# Oblig 5 | Oppg. 4
# Tast inn et fornavn, etternavn og en e-post suffix, saa lager programmet et UiO-brukernavn og e-post for deg. Alternativt kan man se en oversikt over UiO-brukernavn som har blitt lagt
# til, og deres e-post suffixer.
uioBrukernavn = { # oppretter ordbok uioBrukernavn der hvor noekkelverdi er brukernavn og innholdsverdi er epost suffix
    'olan' : 'ifi.uio.no',
    'karin' : 'student.matnat.uio.no'
}

def splittEtternavn(etternavn): # definerer funksjon splittEtternavn som tar imot argumentet etternavn
    etternavnListe = [] # lager tom liste "etternavnListe"
    for delNavn in etternavn: # for-loekke kjoerer gjennom hvert element i stringen etternavn som er en slags "liste"
        etternavnListe.append(delNavn[0]) # legger til ett og ett element (bokstav) i lista etternavnListe
    forste_b_Etternavn = etternavnListe[0] # lagrer det som ligger i indeks 0 i etternavnListe (foerste bokstav i etternavnet) i variabelen forste_b_Etternavn
    return forste_b_Etternavn # returnerer forste_b_Etternavn

def lagBrukernavn(fulltNavn): # definerer funksjonen "lagBrukernavn" som tar imot argumentet "fulltNavn"
    bEtternavn = splittEtternavn(fulltNavn[1]) # resultatet av splittEtternavn etter aa ha mottatt argumentet fulltNavn[1] lagres i bEtternavn
    brukernavn = fulltNavn[0]+bEtternavn # fornavn konkatineres med forste bokstaven i etternavnet. Dette lagres i variabelen "brukernavn"
    print('Ditt UiO-brukernavn er:', brukernavn) # printer ut brukernavn i terminalen
    return brukernavn # returnerer brukernavn
    
def lagEpost(brukernavn, epostsuffix): # definerer funksjon "lagEpost" som tar imot argumentene brukernavn og epostsuffix
    brukernavnSplit = brukernavn.split() # splitter elementene i brukernavn paa mellomrom, lagres i lista brukernavnSplit
    brukernavnListe = [] # lager tom liste
    for delNavn in brukernavnSplit: # for-loekke kjoerer gjennom alle bokstavene i brukernavnSplit
        brukernavnListe.append(delNavn[0]) # legger til en og en bokstav i lista brukernavnListe
    brukernavnSplit.pop() # fjerner siste element i brukernavnSplit
    
    epost = brukernavn + '@' + epostsuffix # brukernavn konkatineres med "@" og epostsuffix som ble sendt inn som argument. Lagres i variabelen epost
    print(epost) # printer epost ut i terminalen
    return epost # returnerer epost

def printEposter(uioBrukernavn): # definerer funksjonen printEposter som tar inn argumentet uioBrukernavn
    for noekkel, innhold in uioBrukernavn.items(): # for-loekke kjoerer gjennom alle elementer i uioBrukernavn
        (lagEpost(noekkel, innhold)) # kaller paa funksjonen lagEpost som tar inn argumentene noekkel (noekkelverdi) og innhold (innholdsverdi) for aa lage en UiO-epost

def printEpost(uioBrukernavn): # definerer funksjonen printEpost som tar inn argumentet uioBrukernavn
    print(uioBrukernavn) # printer argumentet funksjonen har mottatt ut i terminalen

def registrasjon(): # definerer prosedyren "registrasjon"
    navnInp = str(input('Skriv inn et fornavn og etternavn, delt paa et mellomrom. Eks: Michael Jackson\n')) # forventer at brukeren skriver inn et fornavn og etternavn som lagres i navnInp

    navnInp = navnInp.lower() # lower gjoer at alle bokstaver i navnInp blir gjort om til liten bokstav
    navns = navnInp.split() # splitter fornavn og etternavn i navnInp paa mellomrom, lagrer det i variabelen navns
    nnavns = [] # lager ny tom liste
    amount = 0 # definerer variabelen amount som har verdien 0
    for element in navns: # for-loekke kjoerer gjennom hvert element i lista navns
        amount += 1 # for hver iterasjon oekes variabelen amount med 1
    if amount != 2: # hvis amount ikke har verdien 2 etter at for-loekka har avsluttet...
        print('Feil med navneformat (maa bestaa av ett fornavn og ett etternavn)') # ... da kommer denne feilmeldingen opp
        main() # kaller paa main for aa komme til "startmenyen" igjen
    else: # ellers hvis if-en ikke ble oppfylt...
        nnavns = navns # ... da blir innholdet i lista nnavns om til en annen liste med navnet navns
        brukernavn = lagBrukernavn(nnavns) # kaller paa funksjonen lagBrukernavn som mottar argumentet nnavns som lagres i variabelen brukernavn
        epostSuffix = input('Skriv inn din e-post suffix. Eks. "student.matnat.uio.no": ') # bruker maa skrive inn en e-post suffix som lagres i variabelen epostSuffix
        epost = lagEpost(brukernavn, epostSuffix) # kaller paa funksjonen lagEpost som tar inn argumentene brukernavn og epostSuffix som lagres i variabelen epost
        uioBrukernavn[brukernavn] = epostSuffix # legger til brukernavn som noekkelverdi og epostSuffix som innholdsverdi i ordboka uioBrukernavn

def main(): # definerer prosedyre "main"
        menyValg = input('Tast "i" for aa registrere en bruker på UiO. Tast "p" for aa se en oversikt over brukere og e-poster paa UiO. Tast "s" for aa avslutte:\n') # forventer at bruker taster inn i, p eller s. Input lagres i "menyValg"
        while menyValg != 's': # loekke kjoerer saa lenge bruker-input ikke er "s"
            if menyValg == 'i': # hvis input er i...
                registrasjon() # ... blir prosedyren registrasjon kalt paa
                main() # etter at linjene i registrasjon har blitt kjoert, kalles main paa igjen
            elif menyValg == 'p': # ellers hvis input er p...
                printEpost(uioBrukernavn) # ... kalles funksjonen printEpost som tar imot argumentet uioBrukernavn
                main() # deretter blir main kalt paa igjen
            else: # hvis man verken skriver inn i eller p...
                print('Skriv inn et gyldig input.') # ... da faar man en "feilmelding"
                main() # ... og kommer tilbake til begynnelsen av prosedyren main
        else: # hvis while-loekka ikke kjoerer...
            print('Avslutter, vi ses') # ... avsluttes programmet med denne setningen som printes ut i terminalen

main() # kaller paa prosedyren main