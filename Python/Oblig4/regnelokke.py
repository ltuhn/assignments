#   Oblig 4 | Oppg. 2
#   Brukeren skriver inn tall helt til man har skrevet inn 0 eller et tall med lavere verdi enn 0.
#   Programmet skriver ut en liste over alle tall brukeren skrev inn. Saa plusses de sammen og programmet skriver ut summen.
#   Det forteller ogsaa det laveste og hoyeste tallet i lista.
numberList = [] #lager tom liste
while 1==1: #lager while-loekke som sier at saa lenge 1 er det samme som 1 (true)
    number = int(input("Skriv inn et tall: ")) #saa maa bruker skrive inn et tall som lagres inn i number
    if number > 0: #hvis tallet er stoerre enn 0
        numberList.append(number) #saa blir number som brukeren skrev inn lagt inn i lista numberList
        print(number) #skriver ut number som brukeren skrev inn
    elif number <=0: #ellers, hvis number er det samme som eller er mindre enn 0
        break #saa brytes while-loekken og gaar videre til neste linje

for i in numberList: #for-loekke som gaar gjennom alle elementene i numberList
    print(i) #printer ut alle elementene i numberList (alle numrene brukeren skrev)

minSum = 0 #lager variabel minSum med verdi 0
for i in numberList: #for-loekke gaar gjennom alle elementene i numberList
    minSum+= i #for hver gang den gaar gjennom et element saa plusses minSum med verdien av det elementet eks. 7, helt til den er naadd bunnen av lista

print(minSum) #printer ut minSum som er summen av alle elementene i numberList

lNumber=numberList[0] #lNumber er det som er i indeks 0 i numberList
bNumber=numberList[0] #bNumber er det som er i indeks 0 i numberList
for i in numberList: #for-loekke gaar gjennom alle elementer i numberList
    if i > lNumber: #hvis det elementet den kjoerer gjennom er mindre enn lNumber
        i = lNumber #da endres lNumber til aa bli i (denne prosessen fortsetter til den har naadd bunnen av lista)
print("laveste tall er", i) #printer ut det laveste tallet (i)

for x in numberList: #for-loekke gaar gjennom alle elementene i numberList
    if x < bNumber: #hvis elementet x er stoerre enn bNumber
        x = bNumber #da endres bNumber til aa bli x (gjentakende prosess til den har naad bunnen av lista)
print("stoerste tall er", x) #printer ut det stoerste tallet (x)
