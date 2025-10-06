from numpy import *

import math

import matplotlib.pyplot as plt

#Kontorer på fisken ska följa olika formel i olika intervall. För att tydliggöra det definijerar vi variabeln t i intervallet [0,1] och s i intervallet [1,2].

t = linspace(0, 1, 200) #Definierar t-värden från 0 till 1 med 200 steg

s = linspace(1, 2, 200) #Definierar s-värden från 1 till 2 med 200 steg

r = linspace(-1, 8, 200) # plottar punkter (t, c) för alla t i intervallet [0,1], 200)

eye = linspace(-0.1, 0.1, 200)

a = t*(t-1) # funktionen av t vars graf ger ryggen på fisken

c = -a # funktionen av t vars graf ger magen på fisken

b = s-1 # funktionen av s vars graf ger övre delen av svansen på fisken

d = -b # funktionen av s vars graf ger nedre delen av svansen på fisken

eye1 = sqrt(1 - ((10 * eye) ** 2)) / 10
eye2 = -sqrt(1 - ((10 * eye) ** 2)) / 10

gras = 0.02*sin(100*r)-2

# Fisk 1
plt.plot(t, a, 'r') # plottar punkter (t, a) för alla t i intervallet [0,1] i rött 

plt.plot(t, c, 'r') # plottar punkter (t, c) för alla t i intervallet [0,1]

plt.plot(s, b, 'r') # plottar punkter (s, b) för alla s i intervallet [1,2] 

plt.plot(s, d, 'r') # plottar punkter (s, d) för alla s i intervallet [1,2] 

plt.plot(eye + 0.3, eye1, 'b')

plt.plot(eye + 0.3, eye2, 'b')

#Fisk 2
plt.plot(t + 5, a, 'r') # plottar punkter (t, a) för alla t i intervallet [0,1] i rött 

plt.plot(t + 5, c, 'r') # plottar punkter (t, c) för alla t i intervallet [0,1]

plt.plot(s + 5, b, 'r') # plottar punkter (s, b) för alla s i intervallet [1,2] 

plt.plot(s + 5, d, 'r') # plottar punkter (s, d) för alla s i intervallet [1,2] 

plt.plot(eye + 5.3, eye1, 'b')

plt.plot(eye + 5.3, eye2, 'b')

#Fisk 3
plt.plot(t + 5, a + 3, 'r') # plottar punkter (t, a) för alla t i intervallet [0,1] i rött 

plt.plot(t + 5, c + 3, 'r') # plottar punkter (t, c) för alla t i intervallet [0,1]

plt.plot(s + 5, b + 3, 'r') # plottar punkter (s, b) för alla s i intervallet [1,2] 

plt.plot(s + 5, d + 3, 'r') # plottar punkter (s, d) för alla s i intervallet [1,2] 

plt.plot(eye + 5.3, eye1 + 3, 'b')

plt.plot(eye + 5.3, eye2 + 3, 'b')


plt.plot(r, gras, 'g') # plottar punkter (r, gras) för alla s i intervallet [0,2] 

plt.title("Fishies")
plt.show()
