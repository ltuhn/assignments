#   Oblig 4 | Oppg. 4
#   Bruker skriver inn et ord. Programmet printer ut lengden av ordet.
#   Saa maa bruker skrive inn en setning. Programmet skriver ut hvert ord i setningen, lengden av ordet, og antall
#   ganger ordet har dukket opp i setningen.
def wordLength(word): #funksjon som tar imot "word"
    return len(word) #returnerer lengden av "word"

word=input("Skriv inn et ord: ") #bruker-input lagres inn i variabelen word
print(wordLength(word)) #printer ut resultatet av funksjonen wordLength

def uniqueWordCount(text): #funksjon uniqueWordCount tar imot "text"
    dict = {} #lager tom ordbok
    wordList = text.split() #splitter teksten paa hvert mellomrom brukeren skrev inn (som ble lagret i text) og legger de splitta ordene inn i denne lista
    for word in wordList: #gaar gjennom alle elementer i wordList
        if word in dict: #hvis elementet loekka gaar gjennom eksisterer i ordboka dict fra foer...
            dict[word] = dict.get(word) + 1 #... saa oppdaterer den noekkelverdien/key (ordet) slik at dens innholdsverdi/value plusses med 1
        else: #hvis if-en ikke kan oppfylles..
            dict[word] = 1 #... lager den en ny noekkelverdi (ordet) og setter innholdsverdien til noekkelverdien til 1
    return dict #returnerer til slutt ordboka dict


def sentenceInfo(text): #funksjon sentenceInfo som tar imot "text"
    wordList = text.split() #samme beregning som forrige wordList
    print('Du har ', len(wordList)), ' antall ord i setningen din :)') #skriver ut antall ord det er i setningen ved aa finne ut antall elementer det er i lista wordList
    dict = uniqueWordCount(text) #lager dict som er svaret vi fikk i funksjonen uniqueWordCount (som er en dict)
    for key in dict.keys(): #for-loekke gaar gjennom noekkel-verdiene i dict
        print('ord: ', key, ', ordlengde: ', wordLength(key), ', antall: ', dict.get(key)) #skriver ut det ordet (noekkelverdien) for-loekken kjoerer gjennom...
                                                                                           #... saa lengden av ordet som regnes ut med funksjonen wordLength av noekkelverdien/ordet,
                                                                                           #... saa antall ganger det ordet kom i setningen brukeren skrev inn (som ble lagret i text).
                                                                                           #programmet finner det ut ved aa "hente" noekkelverdien slik at det skrives ut innholdsverdien

text=input("skriv inn en setning: ") #bruker maa skrive inn en setning som lagres i variabelen text
sentenceInfo(text) #kaller paa funksjonen sentenceInfo og sender inn argumentet text til sentenceInfo
