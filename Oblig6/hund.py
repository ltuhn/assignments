class Hund(): # definerer klassen Hund
    def __init__ (self, alder, vekt): # oppretter konstruktoer som har parametere alder og vekt
        self._alder = alder # setter instansvariabel for alder
        self._vekt = vekt # setter instansvariabel for vekt
        self._metthet = 10 # setter instansvariabel for metthet paa 10
    
    def age(self): # definerer instansmetode age som ikke tar inn argumenter
        return self._alder # returnerer instansvariabelen alder
    
    def weight(self): # definerer instansmetode weight som ikke tar inn argumenter
        return self._vekt # returnerer instansvariabelen vekt
    
    def spring(self): # definerer instansmetoden spring som ikke tar inn argumenter
        self._metthet -= 1 # reduserer instansvariabelen metthet med 1
        if self._metthet <= 5: # hvis metthet er mindre enn eller er lik 5...
            self._vekt -= 1 # ... reduseres instansvariabelen vekt med 1
    
    def spis(self, tall): # definerer instansmetoden spis som har parameteren tall
        self._metthet += tall # oeker metthet med "tall" som ble sendt inn
        if self._metthet > 7: # hvis instansvariabelen metthet er stoerre enn 7...
            self._vekt += 1 # ... oeker instansvariabelen vekt med 1
