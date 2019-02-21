import ejercicio3
import os


#ejercicio3.reiniciarArchivo()
os.system('cls')
print("**** Esta aplicación lo que hace es ir escribiendo el contenido de un fichero ****")
while(True):   

    cadena = ejercicio3.pedirCadena()
    ejercicio3.guardarCadena(cadena)