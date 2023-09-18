'''
Program som ber bruker oppgi sitt navn. Deretter printes ut variablene
variabel1 og variabel2, som da er 5 og 2. Rett etterpå regner den ut
differansen mellom variabel1 og variabel2, som er 3, og dette skrives ut på
terminalen. Brukeren blir bedt om å skrive et nytt navn, som blir kombinert i
variabelen sammen. Variabelen blir endret på litt senere så navnene separeres
med mellomrom og "og" mellom dem. Den siste biten er den eneste som vil dukke
opp, ikke den gamle versjonen av variabelen sammen.
'''
# Bruker må skrive inn en string
navn = input("Hei student, vennligst oppgi et navn: ")
# Navn er en variabel og det brukeren skrev inn vil dukke opp her
print("Hei", navn)

# Verdiene 5 og 2 lagres i variabel1 og variabel2 respektivt
variabel1 = 5
variabel2 = 2
# Informasjonen i variabel1 vil vises opp på terminalen
print(variabel1)
# Informasjonen i variabel2 vil vises opp på terminalen
print(variabel2)
# Regner ut tallet i variabel1 minus variabel2
variabel3 = variabel1 - variabel2
# Det som ble regnet ut i variabel3 vises på terminalen
print("Differanse:", variabel3)

# Bruker må skrive inn en string på nytt
nyttNavn = input("Vennligst oppgi et nytt navn: ")
# Variabelen kombinerer verdien i variabel navn og nyttNavn som oppgitt av bruker
sammen = navn + nyttNavn
# sammen-variabelen vises opp på terminalen
print(sammen)
# Det tomme er for å legge til mellomrom mellom navnene brukeren har skrevet inn
sammen = navn + " " + "og" +  " " + nyttnavn
print(sammen)
