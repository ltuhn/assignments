# Oblig 5 | Oppg. 3
# def minFunksjon():
#     for x in range(2):
#         c=2
#         print(c)
#         c+=1 
#         b=10
#         b+=a
#         print(b)
#     return(b)

# def hovedprogram():
#     a = 42
#     b = 0
#     print(b)
#     b = a
#     a = minFunksjon()
#     print(b)
#     print(a)

# hovedprogram()

# -----------

# minFunksjon defineres og skal returnere verdien b. Prosedyren hovedprogram defineres. I prosedyren opprettes variablene a og b.
# De faar verdiene 42 og 0, saa printes variabelen b som er 0. Deretter faar b en ny verdi som er a, og a er det samme som 42. b blir med andre ord 42.

# Jeg tror det vil dukke opp en feil naar den kommer til "a = minFunksjon()". I prosedyren minFunksjon staar det
# "b+=a", men a er ikke definert i minFunksjon. a er definert i "hovedprogram" men ingen argumenter blir sendt over til minFunksjon.
# a ligger verken i den lokale skopen til minFunksjon eller den globale skopen, kun i prosedyren "hovedprogram", saa minFunksjon vet ikke hva den skal gjoere med den ikke-eksisterende variabelen a.