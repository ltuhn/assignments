#   Oblig 4 | Oppg. 3
#   Brukeren maa oppgi fem steder, fem klesplagg og fem avreisedatoer. Saa kan man velge om man vil se en individuell liste over stedene, klesplaggene
#   eller avreisedatoene. Deretter kan brukeren velge et spesifikt element i den valgte lista, eks. kjole.
steder=[] #lager tom liste som heter steder
for i in range(5): #for-loekke som avslutter etter fem iterasjoner(?)/runder, som vist med range(5)
    rInp=input('fyll inn et reisemaal: ') #bruker maa fylle inn et reisemaal fem ganger pga. for-loekka som lagres i rInp
    steder.append(rInp) #rInp legges til i lista "steder" hver gang

klesplagg=[] #lager tom liste som heter klesplagg
for i in range(5): #for-loekke som avslutter etter fem runder av det som kommer nedenfor
    kInp=input('skriv inn et klesplagg: ') #bruker-input lagres i kInp
    klesplagg.append(kInp) #kInp legges til i lista klesplagg

avreisedatoer=[] #lager tom liste som heter avreisedatoer
for i in range(5): #samme som de andre for-loekkene, fem runder
    aInp=input('skriv inn avreisedato: ') #bruker-input lagres i aInp
    avreisedatoer.append(aInp) #aInp lagres inn i avreisedatoer

reiseplan=steder, klesplagg, avreisedatoer #lager liste "reiseplan" som bestaar av de tre listene "steder", "klesplagg" og "avreisedatoer"
for i in reiseplan: #gaar gjennom elementene i reiseplan
    print(i) #printer ut reiseplan

i1=int(input('oppgi en gyldig plass i reiseplanen: ')) #bruker maa oppgi en gyldig plass i reiseplanen
i1=i1-1 #regner -1 av det brukeren skrev saa f.eks. input 1 gjoer at programmet senere kan gaa til indeks 0
if i1 >= 0 and i1 <= len(reiseplan): #etter beregningen: hvis bruker-input (i1) er det samme som/er stoerre enn 0 og er det samme som/er mindre enn antall elementer i reiseplan
    print(reiseplan[i1]) #da printes ut lista som brukeren skrev som ble lagret i i1
    i2=int(input('oppgi en gyldig plass i denne lista: ')) #bruker-input lagres i i2
    i2=i2-1 #samme som i1-1
    if i2 >= 0 and i2 <= len(reiseplan[i1]): #samme som if-en over, men i stedet for antall elementer i reiseplan er det antall elementer i liste [i1] i reiseplan
        print(reiseplan[i1][i2]) #printer ut det valgte elementet i2 i liste i1 i lista reiseplan
    else: #(for i2 input) hvis brukeren skrev et tall som er hoeyere enn antall elementer i reiseplan[i1] eller tall som er det samme som eller er lavere enn 0
        print('Ugyldig input') #da faar man denne feilmeldingen
else: #(for i1 input) hvis brukeren skrev et tall som er hoeyere enn antall elementer i reiseplan eller tall som er det samme som eller er lavere enn 0
    print('Ugyldig input!') #da faar man denne feilmeldingen
