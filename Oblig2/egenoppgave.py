#Dette er et slags interaktivt spill. Beslutningene dine avgjør om du får kjøpt det du skal inne på butikken i tide.
#Variabel stageA lagrer det brukeren skriver inn her som int og ikke string. \n lager en line break.
stageA=int(input("Du er paa vei til butikken som skal stenge om et par minutter og ser en katt. Hva gjor du?\n1. Klapper den 2. Ignorerer den\n"))
#Hvis brukeren skrev inn 1, skriver programmet ut det som kommer etter print.
if stageA==1:
    print("Du klapper katten, noe som tar hvertfall fire minutter. Saa sjekker du klokka og innser at klokka er blitt 23:02. Du loper til butikken, men det er for sent. Butikken er stengt.")
    #Programmet avsluttes
    import sys
    sys.exit()
#Hvis if-en over ikke er 1, men er 2, skjer det som kommer nedenfor i stedet.
elif stageA==2:
    #Samme hendelse som i variabel stageA
    stageB=int(input("Du bestemmer deg for å ignorere katten, selv om du gjerne skulle ha likt aa klappe den. Du gaar videre, men denne gangen ser du en tigger. Du:\n1. Gir penger til tiggeren 2. Ignorerer tiggeren\n"))
    #Samme hendelse som i "if stageA==1"
    if stageB==1:
        print("Du foler sympati for den gamle mannen og gir han femti kroner. Det var godt aa kunne hjelpe noen i dag.")
    #Samme hendelse som i "elif stageA==2"
    elif stageB==2:
        print("Man vet aldri hvem som faktisk trenger penger. Paa tide aa gaa videre.")
    #Uavhengig av hva man svarer på stageB går programmet videre og printer ut denne variabelen der hvor brukeren må taste inn et svar
    stageC=int(input("Skyene blir bare mer og mer graa, og plutselig kommer det intense regnvaeret. Det er ingen tvil om hva du maa gjore:\n1. Dekke hodet med ryggsekken 2. Lope videre\n"))
    #Om man svarer 1 her, skrives denne setningen ut
    if stageC==1:
        print("Du faar en ide om aa beskytte hodet ditt mot regnet med ryggsekken din. Takk og pris for at du tok med ryggsekken!")
    #Hvis ikke, og man svarer 2, skrives denne setningen ut
    elif stageC==2:
        print("Det er dumt at det regner saa mye, men det er ikke saa mye man kan gjore med det naa. Bare lop, lop. Du blir sokkvaat, og du kjenner at klaerne tynger deg ned idet du loper.")
    stageD=int(input("Du er snart ankommet butikken, men en ung kvinne kommer bort til deg og lurer paa om du kan hjelpe henne med aa frakte baereposene hennes til bilen. Du bestemmer deg for aa:\n1. Hjelpe til med baereposene 2. Fortelle hoflig at du maa rekke aa komme deg til butikken og lope videre\n"))
    #Kommentert tidligere
    if stageD==1:
        print("Stakkars, det maa vaere ganske ille aa maatte baere saa tunge poser, i tillegg til at det er saa mye regn. Du tar tre av baereposene hennes og putter dem straks inn i Volvoen. Hun takker deg minst tre ganger idet hun gir deg ti kroner for den lille hjelpen du ga. Koselig!")
    if stageD==2:
        print("Du skulle gjerne ha hjulpet kvinnen, men klokka tikker. Butikken er tross alt stengt i hele dag i morgen. Kvinnen har stor forstaelse for at du maa rekke aa kjope ting for butikken stenger. Hun sliter betydelig med aa gaa med sine seks baereposer til bilen, men det ordner seg nok til slutt.")
    #Programmet forventer at brukeren skriver inn noe (string)
    stageE=input("Naa er du endelig kommet til butikken! Dette er det ene matproduktet du absolutt maa kjope:\n")
    print("Da er det paa tide aa betale. Kassemannen spor om du vil ha pose. Det trenger du ikke; du tok med ryggsekken av en grunn")
    #Konsekvensene av beslutningen brukeren tok da variabel stageC kom dukker opp her
    if stageC==1:
        #Dette printes ut etter at man har lest print-stringen ovenfor
        print("Hm, kanskje trenger du en allikevel... Ryggsekken din er klissvaat bade paa innsiden og utsiden etter at du maatte beskytte deg selv mot regnet.")
        #En if innenfor en if. Konsekvensene av stageB kommer her
        if stageB==1:
            #Konsekvensene av stageD kommer her
            if stageD==1:
                print("Du bruker ti-kroningen du fikk fra kvinnen som trengte hjelp med baereposene for aa betale for en pose. Klokka er 23:01, og butikken stenger idet du forlater butikken. Regnvaeret har stoppet, og du har med alle matvarene du trengte. Det blir heldigvis en deilig sondagsmiddag i morgen, spesielt siden du har", stageE+"!")
            else:
                print("Saa kommer du paa at du ga tiggeren femti kroner. Det betyr at du ikke har raad til en pose! Og disse varene er for tunge til at du kan trygt baere dem hjem alene, dessverre. Da blir det knekkebrod til sondagsmiddag i morgen...")
                import sys
                sys.exit()
        if stageB==2:
            if stageD==1:
                print("Du bruker ti-kroningen du fikk fra kvinnen som trengte hjelp med baereposene for aa betale for en pose. Klokka er 23:01, og butikken stenger idet du forlater butikken. Regnvaeret har stoppet, og du har med alle matvarene du trengte. Det blir heldigvis en deilig sondagsmiddag i morgen, spesielt siden du har", stageE+"!")
            else:
                print("Du betaler for posen og sjekker klokka. Det er noyaktig 23:00! Du er sistemann ut av butikken, men regnvaeret har i allefall stoppet. Det blir heldgivis en deilig sondagsmiddag i morgen, spesielt siden du har", stageE,"!")
    #Dette er det som vil printes ut dersom brukeren ikke skrev inn 1, men 2 da variabel stageC kom
    else:
        print("Du putter varene i ryggsekken din. Nå er klokka 23:01, og butikken stenger idet du forlater butikken. Regnvaeret har stoppet, og du har med alle matvarene du trengte. Det blir heldigvis en deilig sondagsmiddag i morgen, spesielt siden du har", stageE+"!")
