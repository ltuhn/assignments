# Oblig 5 | Oppg. 2
# Programmet forteller oss hvilke(n) dato(er) i 2018 det har blitt slaatt en varmerekord fra samme dato i tidligere aar, og lager en ny fil med oppdaterte varmerekorder fra hver maaned.
tempMonth_file = open('max_temperatures_per_month.csv', 'r') # variabel som aapner filen max_temperatures_per_month.csv. 'r' betyr at den bare har tilgang til aa lese den
dailyTemp_file = open('max_daily_temperature_2018.csv', 'r') # samme som over men aapner en annen fil
tMon_file = open('test.csv', 'w+') # samme som over, men 'w+' betyr at vi har tilgang til aa skrive og lese den

def monthTemperatures(file): # definerer funksjonen "monthTemperatures" som tar inn argumentet file
    maxTempMon_dict = {} # lager tom ordbok
    for line in file: # lager for-loekke i filen, saa for hver linje i filen...
        maxTempMon_list = line.split(',') # ... splittes innholdet i linjen paa komma og putter de splittede elementene i lista maxTempMon_list
        maxTempMon_dict[maxTempMon_list[0]] = float(maxTempMon_list[1]) # legger til det som ligger lengst til venstre i linjen i fila (maxTempMon_list[0] som 
                                                                        # noekkelverdi i maxTempMon_dict, mens innholdsverdi er det som ligger lengst til hoeyre i fila
    return maxTempMon_dict # returnerer den oppdaterte ordboka

def tempRecord(highestTemps, dailyTemps): # definerer funksjonen tempRecord som tar inn argumentene highestTemps og dailyTemps
    for line in dailyTemps: # for hver linje i filen dailyTemps...
        lineList = line.split(',') # ... splittes innholdet i linjen paa komma og putter de splittede elementene i lista lineList
        if float(lineList[2]) > highestTemps.get(lineList[0]): # hvis verdien paa plass indeks 2 i lineList (temperaturen i den linja som kjoeres i for-loekken i filen dailyTemps) er hoeyere enn
                                                               # highestTemps.get(lineList[0]) (henter innholdsverdien/temperatur til noekkelverdi i highestTemps 
                                                               # som er det samme som lineList[0] altsaa maaneden i linja for-loekken kjoerer gjennom)...
            highestTemps[lineList[0]] = float(lineList[2]) # ... saa oppdaterer ordboka highestTemps slik at key (maaned) faar en innholdsverdi som er det samme som temperaturen i linja i filen for-loekken kjoerer gjennom
            print('Ny varmerekord: ', lineList[1], lineList[0], lineList[2], 'grader!!!') # printer deretter ut ny varmerekord: dato, maaned, temperatur i linjen for-loekka kjoerer gjennom
    return highestTemps # returnerer den oppdaterte ordboka highestTemps

def overwriteFile(temp_dict, file): # definerer funksjonen overwriteFile som tar inn argumentene temp_dict og file
    for key, value in temp_dict.items(): # for-loekka kjoerer gjennom alle elementer i temp_dict
        a = str(key)+','+str(value)+'\n' # gjoer key og value fra temp_dict om til string slik at de kan konkatineres sammen med komma, \n gjoer at det blir ny linje. Dette lagres i variabelen "a"
        file.write(a) # innholdet i variabelen "a" legges inn (og overskrider informasjonen som allerede eksisterer hvis det er noen) i file helt til foer-loekka er avsluttet

def m(): # definerer prosedyren "m"
    highestTemps = monthTemperatures(tempMonth_file) # resultatet av funksjonen monthTemperatures etter aa ha mottatt argumentet tempMonth_file lagres i variabelen highestTemps
    print(highestTemps) # printer ut highestTemps i terminalen

    newHighestTemps = tempRecord(highestTemps, dailyTemp_file) # resultatet av funksjonen tempRecord etter aa ha mottatt argumentene highestTemps og dailyTemp_file lagres i variabelen newHighestTemps
    print(newHighestTemps) # printer ut newHighestTemps i terminalen

    overwriteFile(newHighestTemps, tMon_file) # kaller paa funksjonen overwriteFile og sender inn argumentene newHighestTemps og tMon_file
    tempMonth_file.close()
    

m() # kaller paa prosedyren "m"