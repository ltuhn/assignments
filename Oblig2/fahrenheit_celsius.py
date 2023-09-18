#Oppgave: Bruker skriver inn en Fahrenheit-temperatur. Programmet skriver ut temperaturen brukeren skrev, deretter samme temperatur målt i Celsius.
#Bruker må oppgi en temperatur målt i Celsius. Stringen blir gjort om til integer
fahrenheit = int(input("Oppgi en temperatur: "))
#Programmet svarer tilbake hva brukeren skrev inn
print("Dette er temperaturen målt i Fahrenheit:", fahrenheit)
#Variabel som har formelen for konvertering fra Fahrenheit til Celsius som verdi, der hvor fahrenheit er det tallet brukeren skrev inn
celsius = ((fahrenheit)-32) * 5/9
#Programmet bruker variabelen celsius som kalkulerer temperaturen brukeren skrev til Celsius. Dette nye tallet printes ut på terminalen
print("Dette er temperaturen målt i Celsius:", celsius)
