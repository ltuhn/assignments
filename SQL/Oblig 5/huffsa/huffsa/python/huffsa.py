import psycopg2

# MERK: Må kjøres med Python 3

user = 'hoangtm' # Sett inn ditt UiO-brukernavn ("_priv" blir lagt til under)
pwd = 'vee9Vai8fa' # Sett inn passordet for _priv-brukeren du fikk i en mail

connection = \
    "dbname='" + user + "' " +  \
    "user='" + user + "_priv' " + \
    "port='5432' " +  \
    "host='dbpg-ifi-kurs03.uio.no' " + \
    "password='" + pwd + "'"

def huffsa():
    conn = psycopg2.connect(connection)
    
    ch = 0
    while (ch != 3):
        print("--[ HUFFSA ]--")
        print("Vennligst velg et alternativ:\n 1. Søk etter planet\n 2. Legg inn forsøksresultat\n 3. Avslutt")
        ch = int(input("Valg: "))

        if (ch == 1):
            planet_sok(conn)
        elif (ch == 2):
            legg_inn_resultat(conn)
    
# Fikk dessverre ikke til å teste programmet. Usikker paa hvordan man gjor det via fjerninnlogging?

def planet_sok(conn):
    print('Sok etter planeter basert pa hvilke molekyler som er oppdaget pa planeten')
    molekylEn = input('Oppgi et molekyl: ')
    molekylTo = input('Oppgi et annet molekyl: ')

    if (molekylTo == ''):
        q = "SELECT p.navn, s.masse, s.avstand, p.liv " + \
            "FROM materie m, planet p, stjerne s " + \
            "WHERE m.molekyl = %(molekylEn)s AND m.planet = p.navn AND p.stjerne = s.navn ORDER BY s.avstand"
    else:
        q = "SELECT p.navn, s.masse, s.avstand, p.liv " + \
            "FROM materie m, planet p, stjerne s " + \
            "WHERE m.molekyl = %(molekylEn)s AND %(molekylTo)s AND m.planet = p.navn AND p.stjerne = s.navn ORDER BY s.avstand"
    q+= ";"

    cur = conn.cursor()
    if (molekylTo == ''):
        cur.execute(q, {'molekylEn' : "%" + molekylEn + "%"})
    else:
        cur.execute(q, {'molekylEn' : "%" + molekylEn + "%", 'molekylTo' : molekylTo})
    rows = cur.fetchall()

    if (rows == []):
        print('Ingen resultater')
        return

    print ('--- PLANETER ---\n')
    for row in rows:
        print ('Navn: ' + str(row[0]) + '\n' + \
                'Stjerne-masse: ' + (row[1]) + '\n' + \
                'Stjernedistanse: ' + (row[2]) + '\n' + \
                'Bekreftet liv: ' + bool(row[3]))

def legg_inn_resultat(conn):
    navnInp = input('Navn på planet: ')
    skummelInp = input('Skummelt? Tast j for ja, n for nei: ')
    intelligentInp = input('Intelligent planet? Tast j for ja, n for nei: ')
    beskrivelseInp = input('Tekstlig beskrivelse av planeten: ')

    cur = conn.cursor()
    cur.execute("INSERT INTO hoangtm_priv.planet(navn, skummel, intelligent, beskrivelse) VALUES (%s, %s, %s, %s);", (navnInp, skummelInp, intelligentInp, beskrivelseInp))
    conn.commit()
    print('Resultat')
    return

if __name__ == "__main__":
    huffsa()