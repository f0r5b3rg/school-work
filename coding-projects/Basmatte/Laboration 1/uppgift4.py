import numpy as np

print("Jag kan bestämma alla reella rötter av en andragradsekvation ax^2 + bx + c = 0.")

my_list = input("Ange koefficienter a, b och c som en lista separerade med space: \n")

inp_a = my_list.split()[0]

inp_b = my_list.split()[1]

inp_c = my_list.split()[2]

print(f"Din ekvation är {inp_a} x^2 + {inp_b} x + {inp_c} = 0") #skriver ut ekvationen

a = float(inp_a)

b = float(inp_b)

c = float(inp_c)

# diskriminant

d = pow(b, 2) - (4 * a * c)

if a == 0:

    print("Detta är ingen andragradsekvationen. Se till att a är skild från noll!")

    exit()

if d < 0:

    print("Ekvationen har inga reella rötter.")

elif d==0:

    rot= -b / 2

    print(f"Ekvationen har en dubbelrot x = {rot}")

else:

    rot_1= (np.sqrt(d) - ((a* b) / 2)) / (2 * a)

    rot_2= (-np.sqrt(d) - ((a * b) / 2)) / (2 * a)

    print(f"Ekvationen har två rötter: x_1 = {rot_1} och x_2 = {rot_2} ") 