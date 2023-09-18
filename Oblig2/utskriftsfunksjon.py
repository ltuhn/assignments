#Oppgave: Bruker må oppgi et navn og bosted tre ganger, og for hver gang vil programmet svare tilbake med det brukeren skrev inn
#Definerer en metode som gjør at jeg kan kalle på linjer 3-5 senere
def questions():
    name = input("Skriv inn et navn: ")
    area = input("Hvor kommer du fra?: ")
    print("Hei", name + ",", "du er fra", area)

#Kaller på innholdet i def questions(): tre ganger
questions()
questions()
questions()
