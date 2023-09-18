# Oblig 5 | Oppg. 5
# Programmet viser en liste over ulike maal for skreddersying, og viser de ulike maalene gitt fra tommer til cm.
def converter(number): # definerer funksjon converter som tar inn argumentet number
    assert number > 0, 'Maa vaere stoerre enn 0' # sjekker om "number" er stoerre enn 0, hvis ikke kommer denne feilmeldingen opp
    cm = number*2.54 # number ganges med 2,54 og resultatet lagres i variabelen cm
    return cm # returnerer cm

def measureDict(file): # definerer funksjon measureDict som tar inn argumentet "file"
    measures = {} # lager tom ordbok "measures"
    for line in file: # for-loekke kjoerer gjennom hver linje i file
        fileList = line.split() # splitter elementene i line paa mellomrom og legger dem til i lista fileList
        measures[fileList[0]] = float(fileList[1]) # legger til det som ligger til venstre i linjen i fila som noekkelverdi i ordboka measures og det som ligger til hoeyre i linjen i fila (selve maalene)
                                                   # som innholdsverdi
    return measures # returnerer measures

def cmToInches(numberList): # definerer funksjonen cmToInches som tar inn argumentet numberList
    for number in numberList: # for-loekke kjoerer gjennom hvert nummer i numberList
        print('maalt i cm: ', converter(number)) # kaller paa funksjonen converter som tar inn argumentet number, og returnerer nummeret gitt i cm som printes ut i terminalen

def main(): # definerer prosedyren main
    fileOpen = open('skreddermaal.txt') # aapner fila "skreddermaal.txt" som lagres i variabelen fileOpen
    measures = measureDict(fileOpen) # kaller paa funksjonen measureDict som mottar argumentet fileOpen, lagres i variabelen measures
    print(measures) # printer ut variabelen measures
    numbers = list(measures.values()) # en liste av verdiene i measures lagres i variabelen numbers
    print(numbers) # printer ut variabelen numbers i terminalen
    cmToInches(numbers) # kaller paa funksjonen cmToInches som mottar argumentet numbers
    fileOpen.close() # lukker filen som ble aapnet tidligere

main() # kaller paa prosedyren main

