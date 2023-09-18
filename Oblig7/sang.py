class Sang:
    def __init__(self, artist, tittel):
        self._tittel = tittel
        self._artist = artist

    def __str__(self):
        return self._artist + ',' + ' ' + self._tittel

    def spill(self):
        print('Spiller' + ' ' + self._artist + ' ' + '-' + ' ' + self._tittel)
    
    def sjekkArtist(self, navn):
        navn = navn.lower()
        nSplit = navn.split(' ')
        artist = self._artist.lower()
        aSplit = artist.split(' ')
        for navnedel in nSplit:
            for delArtist in aSplit:
                if navnedel == delArtist:
                    return True
        return False

    def sjekkTittel(self, tittel):
        if tittel.lower() == self._tittel.lower():
            return True
        else:
            return False
    
    def sjekkArtistOgTittel(self, artist, tittel):
        tittel = tittel.lower()
        artist = artist.lower()
        aSplit = artist.split(' ')
        art = self._artist.lower()
        artSplit = art.split(' ')

        if tittel.lower() == self._tittel.lower():
            for navnedel in aSplit:
                for delArtist in artSplit:
                    if navnedel == delArtist:
                        return True
        return False