class Person(): # definerer klassen Person
    def __init__ (self, navn, alder): # oppretter konstruktoer som har parameterne "navn" og "alder"
        self._navn = navn # oppretter instansvariabel navn
        self._alder = alder # oppretter instansvariabel alder
        self._hobbyer = [] # oppretter instansvariabel hobbyer som er en tom liste
    
    def leggTilHobby(self, hobby): # definerer instansmetoden leggTilHobby som har hobby som parameter
        self._hobbyer.append(hobby) # legger til den innsendte "hobby" i lista "hobbyer"
        if hobby == '0': # hvis den innsendte "hobby" er tekststrengen 0...
            self._hobbyer.pop() # ... fjernes det siste elementet i lista "hobbyer"
    
    def skrivHobbyer(self): # definerer instansmetoden skrivHobbyer
        print(self._hobbyer) # skriver ut instansvariabelen hobbyer ut i terminalen

    def skrivUt(self): # definerer instansmetoden skrivUt som ikke tar inn argumenter
        print('personens navn er', self._navn) # skriver ut instansvariabelen "navn" som inneholder personens navn
        print('personens alder er', self._alder, 'aar') # skriver ut instansvariabelen "alder" som inneholder personens alder
        print('personen har foelgende hobbyer:') # skriver ut tekststreng
        self.skrivHobbyer() # kaller paa instansmetoden skrivHobbyer