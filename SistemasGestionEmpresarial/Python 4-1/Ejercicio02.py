
def mensajes():
	print("***********************")
	print("* Bienvenido a python *")
	print("***********************")
	
	print("Esto es un ejemplo\n de salto de linea")
	
	print("Esto es un ejemplo\t de tabulacion")
	
	nombre = "sergio"
	apellido = "moreno"
	apellido2 = "antequera"
	
	print(nombre, "\t", apellido, "\t", apellido2)
	
	cadena ="""Escribe tu nombre en varias
	
lineas usando una variable cadena sin usar

el parametro para saltar de linea

%s

%s

%s""" % (nombre, apellido, apellido2)

	print(cadena)
	
	
mensajes();