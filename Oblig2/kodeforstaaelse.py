#Oppgave 4.1 + 4.2
#Nei, dette er ikke en lovlig kode (se det som står nedenfor)
#Når man kopierer inn kode kan det hende at det dukker opp "usynlige" tegn som
#gjør at det blir tegnfeil når man forsøker å kjøre koden. Dersom man skriver
#koden for hånd, forsvinner denne tegnfeilen. En annen feil er at programmet
#prøver å konkatinere variabelen b som inneholder en integer fra det brukeren
#skrev, og stringen Hei. En integer og string kan ikke kombineres på denne måten,
#så man må skrive eks. (str(b) for å gjøre om integeren til en string i stedet.
a = input("Tast inn et heltall ")
b = int(a)
if b < 10:
    print(b + "Hei!")
