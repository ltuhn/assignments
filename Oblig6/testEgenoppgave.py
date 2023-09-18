from egenoppgave import Person # importerer klassen Person fra modulen egenoppgave

def main(): # definerer prosedyre main
    navn = input('skriv inn navnet til en person: ') # forventer at brukeren oppgir et navn som lagres i variabelen navn
    alder = int(input('skriv inn alderen til en person: ')) # brukeren maa oppgi alder som lagres i variabelen alder
    person_a = Person(navn, alder) # klassen Person mottar argumentene navn og alder fra tidligere brukerinput og oppretter objektet person_a

    hobbyLokke = '' # definerer variabelen hobbyLokke
    
    while hobbyLokke != '0': #saa lenge hobbyLokke ikke er tekststrengen 0...
        hobbyLokke = input('skriv inn en hobby til personen her. Legg til en hobby per input. Naar du er helt ferdig, tast inn 0\n') # ... dukker denne inputen opp som lagres for hver gang i variabelen hobbyLokke
        person_a.leggTilHobby(hobbyLokke) # ... og objektet kaller paa metoden leggTilHobby og sender inn argumentet hobbyLokke

    person_a.skrivUt() # til slutt etter at while-loekken er avsluttet ved at bruker skriver inn "0", kaller objektet person_a paa metoden skrivUt

main() # kaller paa prosedyren "main"