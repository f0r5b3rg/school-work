import matplotlib.pyplot as plt

# --- Input ---

re1,im1 = input("Ange realdelen x och imaginärdelen y separerade med mellanslag \n").split()

x1 = float(re1)

y1 = float(im1)

re2,im2 = input("Ange ett till komplext tal på samma sätt (realdelen och imaginärdelen separerade med mellanslag) \n").split()

x2 = float(re2)

y2 = float(im2)

print(f"Dina komplexa tal är z1 = {x1} + {y1} i och z2 = {x2} + {y2} i ") 

# --- Rita upp ---

plt.figure(figsize=(6,6))

plt.axhline(0, color='black', linewidth=0.8) # x-axel

plt.axvline(0, color='black', linewidth=0.8) # y-axel

# Ritar pilar från origo till (x1,y1) och från origo till (x2,y2)

plt.quiver(0, 0, x1, y1, angles='xy', scale_units='xy', scale=1, color='blue',label=f'z1 = {x1} + {y1}i') 

plt.quiver(0, 0, x2, y2, angles='xy', scale_units='xy', scale=1, color='green',label=f'z2 = {x2} + {y2}i')

# Nästa rad illustrerar (z1+z2), dvs ritar en pil från origo till (x1+x2,y1+y2) 

plt.quiver(0, 0, x1+x2, y1+y2, angles='xy', scale_units='xy', scale=1, color='red',label=f'z1 + z2 = {x1 + x2} + {y1 + y2}i')

# Uppgift: ritar även en pil som illustrerar (z1-z2) och en som illustrerar konjugat av z1

# Skillnaden mellan vektorerna
plt.quiver(0, 0, x1-x2, y1-y2, angles='xy', scale_units='xy', scale=1, color='yellow',label=f'z1 - z2 = {x1 - x2} + {y1 - y2}i')

# Konjugatet av z1
plt.quiver(0, 0, x1, y1 * -1, angles='xy', scale_units='xy', scale=1, color='cyan',label=f'z1:s konjugat = {x1} + {-y1}i')

plt.xlim(min(-1, x1-1, x2-1, x2-1,x1+x2-1), max(1, x1+1, x2+1, x1+x2+1)) # Skalar axlarna. Prova kommentera bort dessa rader och se vad som händer.

plt.ylim(min(-1, y1-1, y2-1, y2-1,y1+y2-1), max(1, y1+1, y2+1, y1+y2+1))

#Glöm inte göra ändringar i skalningen ovan för att alla dina vektorer skall få plats med vackra marginaler.

plt.xlabel('Re')

plt.ylabel('Im')

plt.title(f'Operationer med komplexa tal') 

#Lägg till en Legend (som vi har gjort i Labb2)
plt.legend()
plt.grid(True)

#plt.grid(True) #ritar ...? Försök kommentera bort!

plt.show()

