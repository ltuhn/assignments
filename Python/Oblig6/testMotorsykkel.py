from motorsykkel import Motorsykkel # importerer klassen Motorsykkel

def hovedprogram(): # definerer prosedyren "hovedprogram"
    motorsykkel1 = Motorsykkel('Vroom', 'AA12345', 1) # oppretter objekt motorsykkel1 vha. klassen Motorsykkel og sender inn argumentene Vroom, AA12345 og 1
    motorsykkel2 = Motorsykkel('Vriim', 'BB67890', 0) # samme som over
    motorsykkel3 = Motorsykkel('Vruum', 'CC12312', 10) # samme som over

    motorsykkel1.skrivUt() # kaller paa metoden skrivUt med objektet motorsykkel1
    motorsykkel2.skrivUt() # samme som over men med motorsykkel2
    motorsykkel3.skrivUt() # samme som over men med motorsykkel 3

    motorsykkel3.kjor(10) # kaller paa metoden kjor med objektet motorsykkel3 og sender inn 10 som argument
    print('Kilometerstanden til Motorsykkel 3 er naa', motorsykkel3.hentKilometerstand()) # skriver ut kilometerstanden til motorsykkel3 ved at motorsykkel3 kaller paa metoden hentKilometerstand

hovedprogram() # kaller paa prosedyren hovedprogram