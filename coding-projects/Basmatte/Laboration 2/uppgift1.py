import numpy as np #Detta bibliotek innehåller matematiska funktioner

import matplotlib.pyplot as plt #Detta bibliotek behövs för att kunna plotta

# Nedan skapar vi två listor av samma längd (!)

x = np.array([0,0,2,0,0,2,0,0,2]) # skapa en lista med x-värden

y = np.array([0,5,5,5,3,3,3,0,0]) # skapa en lista av motsvarande y-värden

plt.plot(x,y) #Denna rad skapar en bild. Men inte visar upp den. Vi använder plt.show() på slutet för att visa våra bilder.

# OBS: Default är att binda ihop punkterna med raka linjesegment.

# Prova byta denna rad med följande:

#plt.plot(x,y,'x') 

# Prova byta även denna rad med följande:

#plt.plot(x,y,'g',label='En vacker bild') #Här bestämmer vi färgen till att vara grön; dessutom lägger vi ett label, som kommer sedan komma upp i Legendan.

# Låt oss skissa en till lista som kommer upp på samma bild:

a = np.array([3, 3, 5, 3, 3, 5])

b = np.array([0, 5, 5, 5, 3, 3])

plt.plot(a,b,'r',label='En bättre bild')

plt.title('Titel på bilden')

plt.xlabel('Text på x-axeln') #text på x-axeln

plt.ylabel('text på y-axeln') #text på y-axeln

plt.legend() #plot the legend

plt.show()

#Uppgift 1: Läs koden och kommentarerna nedan. Ändra punkterna i listorna ovan så att bilden liknar första bokstäverna i ditt namn och efternamn.

#(Det räcker att använda raka linjer och, eventuellt, punkter. Lagom vakert är tillräckligt! ).

