import matplotlib.pyplot as plt
import math

N = 100

a = [i for i in range(1,N + 1)]
b = [1/(5**i) for i in range(0,N)]
e = [(1+(1/i))**i for i in range(1,N + 1)]

#S = a
S = [i for i in range(1,N + 1)]

S[0] = 1
for n in range(1, N):
    S[n] = S[n-1]+(1/(5**n))

E = [math.e for i in range(0, N)]

plt.scatter(a,b, label='n-te element av 1/(5**n)')
plt.scatter(a,S, label='n-te delsumma av summan av n_{n=1}^N 1/5**n ')
plt.scatter(a,e, label='n-te element av (1+1/n)**n')

plt.scatter(a, E, label='Konstanten e')

plt.xlabel('Antal termer')

plt.ylabel('Värde på n-te element och n-te delsumma')

plt.title('Geometrisk talföljd och geometrisk summa')

plt.legend() #plot the legend

plt.show()
