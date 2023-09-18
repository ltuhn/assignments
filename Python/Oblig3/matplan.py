#   OPPGAVE 4
#   Programmet viser en oversikt over beboere og vil at brukeren skal skrive inn navnet paa en av dem. Man faar saa en oversikt
#   over matplanen til den beboeren. Om beboeren ikke eksisterer vil det komme en feilmelding.
#lager ordbok som heter "meal" der hvor noekkelverdien er beboerens navn, og innholdsverdien er en liste som
#bestaar av tre maaltider
meal = {
    "Ronald McDonald": ["cola", "donut","hamburger"],
    "Karen Karensdatter": ["havregroet", "salat", "faarikal"],
    "Hans Hansen": ["vafler", "poelse", "lapskaus"]
    }

#lager en for-loop som stopper naar den har naadd slutten av meal-ordboka
for key, value in meal.items():
    #printer bare ut noekkelverdiene i ordboka meal siden meal er oppgitt ovenfor
    print(key)

#lager prosedyre som heter askMeal
def askMeal():
    #bruker maa taste inn navnet paa en av beboerne. Verdien lagres i qMeal
    qMeal = input("Skriv inn navnet paa en av beboerne: ")
    #Dersom det brukeren skrev inn eksisterer i ordboka meal
    if qMeal in meal:
        #da printes ut innholdsverdien (lista med de tre maaltidene) til den gitte beboeren
        print(meal[qMeal])
    #ellers, om det brukeren skrev inn ikke eksisterer i ordboka meal
    else:
        #vil denne feilmeldingen printes ut
        print("Beboeren du skrev inn er ikke registrert.")

#kaller paa prosedyren askMeal
askMeal()

#   OPPGAVE 4.3
#   a. Ordbok, fordi da kan man knytte noekkelverdien (brukernavn) med innholdsverdien (hele navn) for bedre oversikt. Eks. {hoangtm: Hoang Mu}
#   b. Ordbok igjen fordi da har hver bruker et gitt antall poeng paa innleveringen, og det blir lett aa slaa opp hva bruker X fikk i poeng.
#   c. Liste. Man kan for eksempel sette i rekkefoelge av den foerste til siste personen som vant Lotto det aaret.
#   d. Mengde. Om man skriver inn samme mat to ganger telles ikke "kopien", pluss rekkefoelge spiller ingen rolle her.
