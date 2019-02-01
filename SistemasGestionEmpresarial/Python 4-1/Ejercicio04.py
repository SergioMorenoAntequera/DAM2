
num1 = input("Escribe un numero: ")
num2 = input("Escribe otro numero: ")
nombre = input("Escribe tu nombre: ")

if(num1 > num2):
	maximo = num1;
elif (num1 < num2):
	maximo = num2;
else:
	maximo = "ninguno"
	
print("\nEl maximo de ", num1, " y ", num2, " es ", maximo)
print("Mi nombre es: ", nombre)
