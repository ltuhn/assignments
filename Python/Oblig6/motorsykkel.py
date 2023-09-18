class Motorsykkel(): # definerer klassen Motorsykkel
    def __init__ (self, merke, regNr, kmStand): # oppretter konstruktoer med parametere merke, regNr og kmStand
        self._merke = merke # definerer instansvariabel
        self._regNr = regNr # samme som over
        self._kmStand = kmStand # samme som over

    def kjor(self, km): # definerer instansmetode kjor med parameteren km
        self._kmStand += km # oeker instansvariabelen kmStand med km
        return self._kmStand # returnerer svaret etter beregningen

    def hentKilometerstand(self): # definerer instansmetode hentKilometerstand som ikke tar inn argumenter
        return self._kmStand # returnerer instansvariabelen kmStand
    
    def skrivUt(self): # definerer instansmetoden skrivUt som ikke tar inn argumenter
        print(self._merke) # printer ut en instansvariabel, merke
        print(self._regNr) # printer ut en instansvariabel, regNr 
        print(self._kmStand) # printer ut en instansvariabel