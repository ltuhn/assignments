# Oblig 8
# Her har vi klassen Spillebrett som kan brukes for aa lage et spillebrett, finne antall levende celler, generasjonsnummer for spillebrettet,
# finne naboer til spesifikke celler, og oppdatere cellene i spillebrettet som blir generert tilfeldig med 1/3 sjanse for aa vaere levende i forste generasjon.
from random import randint
from celle import Celle

class Spillebrett:
    # Konstruktor
    def __init__(self, rader, kolonner):
        self._rows = rader
        self._columns = kolonner
        self._genNr = 1 # generasjonsnummer
        self._spillebrett = self._generer() # genererer et spillebrett

    def tegnBrett(self):
        for i in self._spillebrett:
            for j in i:
                print(j, end = ' ') # end legger til et mellomrom bak celleobjektene
            print('\n')
        print('Generasjonsnummer:', self._genNr, '- Antall levende celler:', self.finnAntallLevende())

    def oppdatering(self):
        self._genNr += 1 # oker generasjonsnummeret
        ltilD = [] # oppretter tom liste
        dtilL = []

        for i in range(self._rows):
            for j in range(self._columns):
                midtCelle = self._spillebrett[i][j]
                naboer = self.finnNabo(i, j) # finner naboene til midtCelle

                levendeNaboer = []
                levendeTeller = 0
                for nabo in naboer:
                    if nabo.erLevende(): # hvis naboen er levende...
                        levendeNaboer.append(nabo) # ... legg naboen til i lista levendeNaboer
                        levendeTeller += 1
                
                if midtCelle.erLevende():
                    if levendeTeller < 2 or levendeTeller > 3: # hvis det er faerre enn to levende naboer eller flere enn to levende naboer...
                        ltilD.append(midtCelle) # legg 'midtCelle' til i lista ltilD slik at den gaar fra statusen levende til dod
                elif midtCelle.erLevende() == False:
                    if levendeTeller == 3:
                        dtilL.append(midtCelle)
        
        for celle in ltilD:
            celle.settDoed() # setter alle celleobjekter (som da er levende) i ltilD til statusen dod

        for celle in dtilL:
            celle.settLevende() # setter alle celleobjekter (som da er dode) i dtilL til statusen levende


    def finnAntallLevende(self):
        antallLevende = 0 # definerer variabelen antallLevende og gir den verdi 0
        for i in self._spillebrett:
            for celle in i:
                if celle.erLevende():
                    antallLevende += 1 # ok antallLevende med 1 dersom en celle i spillebrettet har status levende
        return antallLevende

    def _generer(self):
        spillebrettListe = []
        for i in range(self._rows): # for antall rader i self._rows...
            spillebrettListe.append([]) # ... legg til tom liste i listen spillebrettListe
            for j in range(self._columns):
                cell = Celle() # oppretter objekt med klassen Celle
                tall = randint(0,2) 
                if tall == 2: # dersom tallet noyaktig (og tilfeldig) er 2...
                    cell.settLevende() # ... sett objektet 'cell' sin status til Levende
                spillebrettListe[i].append(cell) # legger til objektet 'cell' i spillebrett i den nostede for-løkken
        return spillebrettListe

    def finnNabo(self, rad, kolonne):
        naboer = []

        for r in range(-1, 2): # de horisontale naboene
            for k in range(-1, 2): # de vertikale naboene
                oppeEllerNede = rad + r
                vedSiden = kolonne + k

                tillatt = True

                if r == 0 and k == 0: # for ikke aa legge til seg selv som nabo
                    tillatt = False
                
                if oppeEllerNede < 0 or oppeEllerNede >= self._rows: # sorge for at det ikke kommer "umulige" tall utenfor indeksen eks. -1
                    tillatt = False
                
                if vedSiden < 0 or vedSiden >= self._columns:
                    tillatt = False
                
                if tillatt: # hvis det ikke er noen umulige tall...
                    naboer.append(self._spillebrett[oppeEllerNede][vedSiden]) # legg objektet til i lista naboer

        return naboer