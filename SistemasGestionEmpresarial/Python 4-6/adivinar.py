
from random import *

def generarNumeroAleatorio(minimo, maximo):
    
    try:
        if(minimo > maximo):
            aux = minimo
            minimo = maximo
            maximo = minimo
        
        return randint(minimo, maximo)
    
    except TypeError:
        print("Debes escribir numero")
        return -1
#------------------------------------------------ç

minimo = int(input("Introduce un numero minimo: "))
maximo = int(input("Introduce un numero maximo: "))

aleatorio = generarNumeroAleatorio(minimo, maximo)

c = 0
while True:
    c += 1
    numero = int(input("Introduce el nuemro buscado: "))

    if(numero < aleatorio):
        print("El nunmero que buscas es mayor")
    
    if(numero > aleatorio):
        print("El nunmero que buscas es menor")
    
    if(numero == aleatorio):
        print("Has acertado, el numero era: " + str(aleatorio) + " te ha llevado " + str(c) + " intentos")
        break