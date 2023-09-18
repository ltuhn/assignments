from dato import Dato # importerer klassen Dato fra modulen dato

def main(): # definerer prosedyre "main"
    eksempelDato = Dato(15, 10, 2020) # sender inn argumentene 15, 10 og 2020 til klassen Dato for aa opprette objektet eksempelDato

    print(eksempelDato.readYear()) # skriver ut resultatet av eksempelDatos kall paa metoden readYear uten aa sende inn argumenter, ut i terminalen

    eksempelDato.checkDate() # objektet kaller paa metoden checkDate

    sentenceDate = eksempelDato.stringDate() # resultatet av eksempelDatos kall paa metoden stringDate lagres i variabelen sentenceDate
    print(sentenceDate) # skriver variabelen sentenceDate ut i terminalen

main() # kaller paa prosedyren "main"