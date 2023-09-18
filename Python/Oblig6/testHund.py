from hund import Hund # importerer klassen Hund fra modulen hund

def hovedprogram(): # definerer prosedyren "hovedprogram" uten parametere
    hund1 = Hund(1, 4) # oppretter objektet "hund1" vha. klassen Hund og sender inn argumenter 1 og 4

    hund1.spring() # objektet hund1 kaller paa metoden spring
    print('etter aa ha loept er hundens vekt', hund1.weight(), 'kg') # skriver ut hundens vekt i terminalen ved at objektet kaller paa metoden weight i klassen Hund
    hund1.spring()
    print('etter aa ha loept igjen er hundens vekt', hund1.weight(), 'kg')

    hund1.spis(2) # objektet hund1 kaller paa metoden spis og sender inn 2 som argument
    print('hundens vekt etter aa ha spist er', hund1.weight(), 'kg')
    hund1.spis(5) # objektet hund1 kaller paa metoden spis og sender inn 5 som argument
    print('hundens vekt etter aa ha spist litt mer er', hund1.weight(), 'kg')

hovedprogram() # kaller paa prosedyren hovedprogram