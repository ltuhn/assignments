varer = {"melk": 14.90, "broed": 24.90, "yoghurt": 12.90, "pizza": 39.90}
print(varer)

nyVare1 = input("Legg til en vare: ")
prisVare1 = float(input("Legg til en pris til varen: "))
print("Du skrev inn", nyVare1, "for prisen av", prisVare1)
varer.update({nyVare1:prisVare1})

nyVare2 = input("Navn på ny vare: ")
prisVare2 = float(input("Legg til en pris til denne varen: "))
print("Du skrev inn", nyVare2, "for prisen av", prisVare2)
varer.update({nyVare2:prisVare2})

print(varer)
