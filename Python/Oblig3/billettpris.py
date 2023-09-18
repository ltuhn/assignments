def askAge():
    age = int(input("Skriv inn alderen til billettkjoeperen: "))
    billettpris = 0

    if age <= 17:
        billettpris = 30
    elif age >= 63:
        billettpris = 35
    elif age > 17:
        billettpris =  50

    print("Prisen paa en billett er", billettpris, "kr")

askAge()
