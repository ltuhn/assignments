class Dato(): # oppretter klassen Dato
    def __init__ (self, nyDag, nyMaaned, nyttAar): # oppretter konstruktoer med parametere nyDag, nyMaaned og nyttAar
        self._dag = int(nyDag) # setter instansvariabel for dag
        self._maaned = int(nyMaaned) # setter instansvariabel for maaned
        self._aar = int(nyttAar) # setter instansvariabel for aar
    
    def readYear(self): # definerer instansmetode readYear
        return self._aar # returnerer instansvariabelen aar
    
    def stringDate(self): # definerer instansmetoden stringDate
        sentenceDate = "Dag: " + str(self._dag), "Maaned: " + str(self._maaned), "Aar: " + str(self._aar) # oppretter en string for hele datoen bestaaende av ulike tekststrenger som er konkatinert sammen.
                                                                                                          # Bruker instansvariabeler dag, maaned og aar. Beholdes i variabelen sentenceDate
        return sentenceDate # returnerer variabelen sentenceDate
    
    def checkDate(self): # definerer instansmetoden checkDate som ikke tar inn argumenter
        if self._dag == 15: # hvis instansvariabelen dag er tallet 15...
            print('Loenningsdag!') # ... skrives denne tekststrengen ut i terminalen
        elif self._dag == 1: # ellers hvis dag er tallet 1...
            print('Ny maaned, nye muligheter:)') # ... skrives denne tekststrengen ut i terminalen i stedet
        else: # ellers hvis instansvariabelen dag er noe helt annet...
            print('Dette er bare en vanlig dato') # ... skrives dette ut i terminalen
