import numpy as np

import matplotlib.pyplot as plt

import sys

# Definiera funktionen

def f(x):

    f = 2**x - x -3 
    #f = x**2 - x - 6
    #f = np.cos(x)-x

    return f

def plot_intervall(a,b,c,x, iteration,final = False):

    # --- Rita graf och intervall ---

    plt.clf()

    plt.plot(x, f(x), 'b-', label="f(x)")

    plt.axhline(0, color='black', linewidth=0.8)

    plt.axvline(a, color='red', linestyle='--', label="a")

    plt.axvline(b, color='green', linestyle='--', label="b")

    plt.axvline(c, color='purple', linestyle=':', label="c (mittpunkt)")

    plt.title(f"Iteration {iteration}")

    plt.legend()

    if final:

        plt.text(c, 0.5, f"Rot ≈ {c:.6f}", color="purple")

        plt.ioff() # Slå av interaktivt läge för plotten

        plt.show()

    else:

        plt.show(block=False)

        plt.pause(1.5) # vänta 1.5 sekund mellan iterationerna

x = np.linspace(-10,10,1000)

plt.ion() # Slå på interaktivt läge för plotten (programmet forsätter med plotten öppen)

plt.plot(x, f(x), 'b-', label="f(x)")

plt.axhline(0, color='black', linewidth=0.8)

plt.show()

a = float(input('Ge vänstra intevallpunkten: '))

b = float(input('Ge högra intervallpunkten: ')) 

# initialiserar c så att kompilatorn är nöjd.
c = 0

if f(a)*f(b) >= 0:

    print('Koden stoppas! f(a) och f(b) måste ha olika tecken')

    sys.exit()

tol = 1e-10 # Här bestämmer vi oss för ett litet tal (namnet kommer från "toleransen") 
#tol = 2
#sådan att om intervallet [a,b] som innehåller roten blir mindre än tol, 

#så ska vi sluta räkna, och ange mitten av intervalet som ett tillräckligt bra approximation till roten.

iteration = 0

plotmax = 10

while (b-a)/2 > tol: 

    iteration += 1

    c = (a+b)/2

    if iteration <= plotmax:

        plot_intervall(a,b,c,x,iteration) # Ritar upp intervallen de första 10 interationerna

    if f(c) == 0: # Roten funnen

        print('x = ', c)

        break

    elif f(a)*f(c) < 0: # a och c är det nya intervallet

        b = c

    else: # c oxh b ör det nya intervallet

        a = c

print('x = ', (a+b)/2 ) # mittpunkten på intervallet är en approximation till roten

print('Efter antal interationer: ',iteration)

plot_intervall(a,b,c,x,iteration,final = True) 
