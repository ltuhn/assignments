#   Oblig 4 | Oppg. 1
#   To tall plusses med hverandre og svaret blir skrevet ut. Saa blir to nye tall plusset
#   med hverandre og svaret blir skrevet ut igjen. Brukeren skriver inn en tekststreng og bokstav,
#   saa forteller programmet hvor mange ganger bokstaven dukker opp i tekststrengen.
def adder (tall1, tall2): #Lager funksjonen adder som tar imot tall1 og tall2
    sum=tall1+tall2 #variabel som plusser variablene tall1 og tall2
    return sum #Etter beregningen sendes resultatet av tilbake til oss saa man kan bruke det

tall1=2 #lagrer verdien 2 i tall1
tall2=8 #lagrer verdien 8 i tall2

print("Summen", "av", tall1, "og", tall2, "er", adder(tall1,tall2)) #viser resultatet av funksjonen adder ved aa sende inn argumentene tall1 og tall2 til adder

tall1=9 #lagrer ny verdi 9 i tall1
tall2=5 #lagrer ny verdi 5 i tall2

print("Summen", "av", tall1, "og", tall2, "er", adder(tall1,tall2)) #samme som forrige print bare med nye verdier

textString=input("skriv inn en tekststreng: ") #ber bruker skrive inn tekststreng som lagres i variabelen textString
letter = input("skriv inn en bokstav: ") #ber bruker skrive inn bokstav som lagres i variabelen letter
print("Bokstaven", letter, "kom opp", textString.count(letter), "gang(er)") #bruker tjenesten "count" for aa telle forekomsten av letter i textString som skrives ut her

def tellForekomst(minTekst, minBokstav): #lager funksjon som tar imot minTekst og minBokstav
    antall = minTekst.count(minBokstav) #variabelen "antall" regner ut hvor mange ganger bokstaven minBokstav kommer opp i minTekst med tjenesten count
    return antall #returnerer svaret saa vi kan bruke dette naar vi kaller paa tellForekomst

minTekst = input("skriv inn en tekst: ") #bruker maa skrive inn en tekst som lagres i minTekst
minBokstav = input("skriv inn en bokstav: ") #bruker maa skrive inn en bokstav som lagres i minBokstav

print("bokstaven kom opp", tellForekomst(minTekst,minBokstav), "ganger") #skriver ut setning som forteller hvor mange ganger bokstaven minBokstav kom i tekststrengen
# minTekst ved hjelp av funksjonen tellForekomst
