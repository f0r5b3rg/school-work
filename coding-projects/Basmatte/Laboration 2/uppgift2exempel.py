#Följande är ett sätt att illustrera talföljder.

#Programmet nedan plottar 1) punkter (x,y)=(i, 1/i) för i=1,...N+1, samt 2) (x, y)= (n, Sum_{i=1}^n 1/i).

# (här är i bara index, ingenting med komplexa tal att göra).

import matplotlib.pyplot as plt

N = 100

a = [i for i in range(1,N + 1)] #Här definierar vi en lista med (N+1) element och fyller i den med tal 1...(N+1). 

#Observera att element i listan i Python numreras från nummer 0.

#Alltså a[0]=1, ..., a[N]=N+1. 

b = [1/i for i in range(1,N + 1)] #Här definierar vi en lista av element b[0]=1, b[2]=1/2, ..., b[N]=1/(N+1).

S = [i for i in range(1,N + 1)] #Här definierar vi en lista likadan som första. Men vi ska byta dess element mot delsummor.

#Här beräknar vi delsummorna. 

S[0]=1 #Vi sätter första delsumman att vara 1 

for n in range(1,N):

       S[n]= S[n-1]+1/n  #S[n] betecknar n-te element i listan S. Här definierar vi dem.

plt.scatter(a,b, label='n-te element')

plt.scatter(a,S, label='n-te delsumma')

plt.xlabel('Antal termer')

plt.ylabel('Värde på n-te element och n-te delsumma')

plt.title('Harmoniska talföljden och delsummor')

plt.legend() #plot the legend

plt.show()

