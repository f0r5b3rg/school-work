print("Låt oss jämföra S_harm=Sum_{n=1}^N (1/n) och S_geom=Sum_{n=1}^N (0.99^n) för stora N.")

S_harm=0

n=1

antal_termer = 10000000

for n in range(1,antal_termer+1):

    S_harm=S_harm+1/n

print(f"Summa av N=", antal_termer, " första termer i summan Sum_(n=1)^N (1/n) är ", S_harm)

S_geom=0

n=1

while n<= antal_termer: ### Vi använder while här för att öva på det

    S_geom = S_geom + pow(0.99, n)

    n=n+1

print(f"Summa av N={antal_termer} första termer i summan Sum_(n=1)^N (0.99^n) är ", S_geom)

print("Men faktum är att.... båda summorna växer, men mindre för varje term. " \
    "Den geometriska summan närmar sig 99 men kommer aldrig att nå den. " \
    "Den harmoniska summan, däremot, kommer att fortsätta växa oändligt. " \
    "För att den harmoniska summan ens ska nå 20 krävs en väldigt stor mängd termer.")

S_harm = 0
S_geom = 0
n = 1

while S_harm <= 20:
    S_harm = S_harm + 1/n
    n = n + 1

print(n, "termer för att harmoniska summan ska nå 20.")

S_harm = 0
S_geom = 0
n = 1

while S_harm <= S_geom:

    S_harm = S_harm + 1/n
    S_geom = S_geom + pow(0.99, n)
    n = n + 1

print(f"Det tar {n} steg för att harmoniska summan ska bli större än geometriska summan.")