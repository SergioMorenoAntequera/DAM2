import sys
import os

diccionario = {}
opcion = 0
c = 1

def mostrarMenu():
	print("""**************************************************
		Opciones
**************************************************
	1 - Introducir un valor en el diccionario
	2 - Eliminaar un nombre del diccionario
	3 - Mostrar todos lo valores del diccionario
	4 - Borrar el diccionario
	9 - Salir""")

mostrarMenu()

while(opcion != 9):
	opcion = int(input("Inserta un numero del menu: "))
	
	#Aniadimos un valor al diccionario (Valorn = cadena)
	if(opcion == 1):
		clave = ("Valor" + str(c))
		c = c+1
		valor = input("Introduce un nombre en el diccionario: ")
		diccionario[clave] = valor
		input("Pulsa ENTER para continuar...")
	#------------------------------------------------------------------------------------------------
	
	#Borrar un nombre del diccionario
	if(opcion == 2):
		print("Vas a elimianr una clave del directorio\n")

		clave = input("Inserta la clave que quieras eliminar(Valor1, Valor2...): ")
		del(diccionario[clave])
		
		print("Clave eliminada exitosamente. El diccionario queda asi:")
		print(diccionario)
		input('*** Pulsa ENTER para continuar...')
	#------------------------------------------------------------------------------------------------
	
	#Mostrar el diccionario
	if(opcion == 3):
		if(diccionario == {}):
			print("El diccionario esta vacio")
		else:
			print("Los valores del diccionario son: ")
			for aux in diccionario:
  				print(aux + " : " + diccionario[aux])
		input('Pulsa ENTER para continuar...')
	#------------------------------------------------------------------------------------------------

	#Borrar el diccionario
	if(opcion == 4):
		if (diccionario == {}):
			print("El diccionario está vacio")
		else:
			eleccion = input("Seguro que quieres borrar el directorio S-Si // N-No: ")
			if(eleccion == "S" or eleccion == "s"):
				diccionario = {}
				print("Diccionario borado con exito")
			elif (eleccion == "N" or eleccion == "n"):
				print("Diccionario no borado")
			else:
				print("Opción no válida")
		input("Pulsa ENTER para continuar...")
	#------------------------------------------------------------------------------------------------

	#Final
	if(opcion == 9):
		print("¡Hasta luego!")
		print("Programa realizado por: Sergio Moreno")
		sys.exit()
	#------------------------------------------------------------------------------------------------

	#Control de errores
	if(opcion != 1 and opcion != 2 and opcion != 3 and opcion != 4 and opcion != 9):
		print("No has pulsado ninguna opción correcta...")
		print(opcion)
		input('Pulsa ENTER para continuar...')
	#-------------------------------------------------------------------------------------------------

	os.system('cls')
	mostrarMenu()
