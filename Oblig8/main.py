# Oblig 8
# Programmet spor brukeren om aa skrive inn antall rader og kolonner. Disse blir brukt for aa lage et spillebrett. Spillebrettet bestaar av et tilfeldig antall levende celler (1/3) sjanse.
# Brukeren skriver inn enter for aa se en oppdatering av spillebrettet, altsaa for aa se en ny generasjon av celler. Dersom de levende cellene har 2 eller 3 levende naboer, fortsetter de aa leve.
# Dersom en dod celle har noyaktig tre levende naboer, vil den leve neste runde.
from spillebrett import Spillebrett
def main():
    rader = int(input('Hvor mange rader skal spillebrettet ha?')) # spor brukeren om input som lagres i variabelen 'rader'
    kolonner = int(input('Hvor mange kolonner skal spillebrettet ha?'))
    spill1 = Spillebrett(rader, kolonner) # oppretter objektet spill1 med klassen Spillebrett. Sender inn argumentene rader og kolonner for aa opprette objektet.
    spill1.tegnBrett()

    valg = input('\nTrykk enter, eller hvilken som helst knapp for aa fortsette. Trykk q ogsaa enter for aa avslutte programmet\n')
    while valg != 'q': # saa lenge inputen 'valg' ikke er q...
        spill1.oppdatering() # kaller spill1 paa metoden oppdatering som oppdaterer spillebrettet
        spill1.tegnBrett()
        valg = input('\nTrykk enter, eller hvilken som helst knapp for aa fortsette. Trykk q ogsaa enter for aa avslutte programmet\n')
    print('vi ses :)')

main()