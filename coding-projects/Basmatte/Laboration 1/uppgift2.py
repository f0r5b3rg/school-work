print("Hej! Nu ska jag visa att jag kan räkna. Hitta på två heltal.")

string_a = input("Ange första talet: \n") # \n säger att man ska byta rad

string_b = input("Ange andra talet: \n")

a=float(string_a)

b=float(string_b)

print("Summa:", a, "+", b, "=", a + b) 

print(f"Summa: {a} + {b} = ", a + b) #Detta är ett snabbare sätt att uttrycka samma som ovan

### Gör om outputen för produkt och potens för att det skulle skrivas vilka tal som används.
print(f"Produkt: {a} * {b} =", a * b)

print(f"Potens: {a}^{b} =", a ** b)

# För att definiera a/b behöver vi verifiera att b är skild från 0. 

if b != 0: # != betyder "not equal"

    print("Kvot: a / b=", a / b )

else:

    print("Kvoten är inte definierad ty nämnaren är 0. ")

# numpy är ett bibliotek som innehåller många funktioner. 

print("Och jag har många andra funktioner i numpy!")

import numpy as np # importerar biblioteket numpy och kallar den för np 

print(f"Till exempel, sinus: sin({a}) = ", np.sin(a)) # funktionerna som finns i numpy har namn som börjar med np. 

if a >= 0:

    print(f"Eller exempel, square root: sqrt({a}) = ", np.sqrt(a))

elif b >= 0:

    print(f"Till exempel, square root: sqrt({b}) = ", np.sqrt(b)) 

else:

    print("Ange minst ett icke-negativt tal i din lista, så ska jag dra roten ur den!")

### Illustrera ytterligare två inbyggda funktioner i numpy, 
### helst med en icke-trivial definitionsmängd!

print(f"Logaritm:\nlog {a} =", np.log(a))
print(f"log {b} =", np.log(b))

print(f"Tangens: \ntan({a}) = ", np.tan(a))
print(f"tan({b}) = ", np.tan(b))