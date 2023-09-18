from sang import Sang

class Spilleliste:
    def __init__(self, listenavn):
        self._sanger = []
        self._navn = listenavn
    
    def lesFraFil(self, filnavn):
        fil = open(filnavn, 'r')

        for linje in fil:
            alleData = linje.strip().split(';')
            self._sanger.append(Sang(alleData[1], alleData[0]))

        fil.close
        return self._sanger 

    def leggTilSang(self, nySang):
        self._sanger.append(nySang)
    
    def fjernSang(self, sang):
        for laat in self._sanger:
            if sang._artist.lower() == laat._artist.lower() and sang._tittel.lower() == laat._tittel.lower():
                self._sanger.remove(laat)

        return self._sanger
    
    def spillSang(self, sang):
        sang.spill()

    def spillAlle(self):
        for laat in self._sanger:
            print(laat)

    def finnSang(self, tittel):
        for laat in self._sanger:
            if tittel.lower() == laat._tittel.lower():
                return laat
        return None

    def hentArtistUtvalg(self, artistnavn):
        sangListe = []
        for laat in self._sanger:
            if laat.sjekkArtist(artistnavn) is True:
                sangListe.append(laat)
        return sangListe