#   OPPGAVE 1: LISTER
list1 = [2, 3, 5]
list1.append(4)
'''
print(list1[0], list1[2])

list2 = []
list2.append(input("Oppgi et navn: "))
list2.append(input("Oppgi et navn til: "))
list2.append(input("Oppgi et tredje navn: "))
list2.append(input("Oppgi et navn (siste gang): "))

if "Hoang" in list2:
    print("Du husket meg!")
else:
    print("Glemte du meg?")
'''

additionList = list1[0]+list1[1]+list1[2]+list1[3]
multiplicationList = list1[0]*list1[1]*list1[2]*list1[3]

list3 = []
list3.append(additionList)
list3.append(multiplicationList)

list4 = []
list4 = list1 + list3
print(list4)

list4.pop()
list4.pop()
print(list4)
