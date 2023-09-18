'''
Programmet spør om brukeren har lyst på brus, der hvor bruker kan svare enten
ja eller nei. Avhengig av hva brukeren svarer vil programmet enten si "Her har du
en brus!", "Den er grei" eller "Det forstod jeg ikke helt".
'''
# Programmet stiller et spørsmål som forventes å bli svart av bruker-input
brus = input("Har du lyst på brus?: ")

# Dersom brukeren skrev nøyaktig inn "ja", vil det stå "Her har du en brus!""
if brus == "ja":
    print("Her har du en brus!")
# Åpner for at "ja" kan skrives både med liten og stor bokstav
elif brus == "Ja":
    print("Her har du en brus!")
'''
Elif står for else if, så det skjer bare hvis den første betingelsen ikke kan
oppfylles, så fortsetter det nedover om denne elif ikke kan oppfylles osv.
'''
elif brus == "Nei":
    print ("Den er grei.")
elif brus == "nei":
    print("Den er grei.")
# Alt annet man skriver vil føre til at dette skrives ut på terminalen
else:
    print("Det forstod jeg ikke helt")
