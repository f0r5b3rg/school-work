import numpy as np
import matplotlib.pyplot as plt

print("Enter three numbers separated by spaces.: ")
# Hämta siffror från användaren
a, b, c = list(map(int, input().split(" ")))

# Definiera x-värden
# Samma x-värden används för både f och y eftersom 
# matplotlib helt enkelt inte visar de värden funktionen är
# odefinierad för.
x = np.linspace(-20, 20, 200)

# Definiera funktionen f och dess invers
f = (2 ** ((a * x) + b)) - c
f_inv = (np.log10(x + c) - (b * np.log10(2))) / (a * np.log10(2))

# Skriv ut inversen av f:s definitionsmängd
print("f_inv definitionsmängd: x >", c *-1 )

# Plotta och visa grafer med etiketter
# funktionen f plottas
plt.plot(x, f, "r", label = "f(x)")
# inversen av funktionen f plotts
plt.plot(x, f_inv, "b", label = "f^-1(x)")
# y = x plottas
plt.plot(x, x, label = "y = x")
plt.xlabel("x")
plt.ylabel("y")
plt.legend()
# Ändrar området som visas av matplot
plt.axis("equal")
plt.xlim(-10, 10)
plt.ylim(-10, 10)
plt.grid(True)
plt.show()
