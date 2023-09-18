# Oblig 8
# Klassen Celle kan brukes for aa opprette et celle-objekt som kan legges til i spillebrettet. Man kan endre statusen (levende/dod), sjekke om en celle er levende og hente statustegnet til cellen i form av O eller .
class Celle:
    # Konstruktor
    def __init__(self):
        self._status = False

    def __repr__(self):
        return self.hentStatusTegn() # resultatet fra metoden hentStatusTegn vises dersom man printer et objekt opprettet med klassen Celle

    # Endre status
    def settDoed(self):
        self._status = False

    def settLevende(self):
        self._status = True

    # Hente status
    def erLevende(self):
        if self._status == True: # hvis cellen lever...
            return True # returner True
        return False # hvis ikke, returner False

    # returnere statustegn 'O' eller '.'
    def hentStatusTegn(self):
        if self.erLevende() == True:
            return 'O'
        return '.'