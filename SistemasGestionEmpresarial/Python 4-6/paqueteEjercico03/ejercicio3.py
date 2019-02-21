#Clase auxiliar para modulo

def reiniciarArchivo():
    open("datosGuardados.txt", "w")

def pedirCadena():
    cadena = input("Linea a escribir: ")
    return cadena

def guardarCadena(cadena):
    fichero = open("datosGuardados.txt", "a")
    fichero.write(cadena+"\n")
