from numpy import *

import math

import matplotlib.pyplot as plt

import numpy as np

t = linspace(-10, 10, 200) #Definierar t-värden från 0 till 1 med 200 steg

f = np.abs(t) #Definierar funktionen absolutbelopp av t
g = np.abs(t-4) 
h = np.abs(t + 3) + np.abs(t-4)

s = np.sin(t) +1 #Definierar funktionen sin(t)+1 

plt.plot(t, f , 'b', label='f(t)=|t|') #Skapar grafen (utan att visa den)
plt.plot(t, g, 'g', label ='g(t) = |t - 4|')
plt.plot(t, h, 'y', label ='h(t) = |t + 3| + |t - 4|')
plt.plot(0, 7, 'ro')

plt.text(0, 8, '(0,7)')

# plt.plot(t, s , 'r', label='y=sin(t)+1') #Skapar grafen (utan att visa den)
plt.title('Grafer av funktioner med absolutbelopp')

plt.legend() #plot the legend

plt.show()
