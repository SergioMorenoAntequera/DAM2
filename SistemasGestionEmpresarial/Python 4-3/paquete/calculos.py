import os
import math
import datetime
import sys

def sumar():
    os.system('cls')
    num1 = int(input("Introduce un numero entero: ")) 
    num2 = int(input("Introduce un numero entero: "))
    result = num1 + num2
    print("La suma de: " + str(num1) + " + " + str(num2) + " = " +  str(result))

def restar():
    os.system('cls') 
    num1 = int(input("Introduce un numero entero: ")) 
    num2 = int(input("Introduce un numero entero: "))
    result = num1 - num2
    print("La resta de: " + str(num1) + " - " + str(num2) + " = " +  str(result))

def multiplicar():
    os.system('cls') 
    num1 = int(input("Introduce un numero entero: ")) 
    num2 = int(input("Introduce un numero entero: "))
    result = num1 * num2
    print("La multiplicacion de: " + str(num1) + " x " + str(num2) + " = " +  str(result))

def dividir():
    os.system('cls') 
    num1 = int(input("Introduce un numero entero: ")) 
    num2 = int(input("Introduce un numero entero: "))
    result = num1 / num2
    print("La division de: " + str(num1) + " / " + str(num2) + " = " +  str(result))

def exponente():
    os.system('cls')
    num1 = int(input("Introduce un numero entero: ")) 
    num2 = int(input("Introduce un numero entero: "))
    result = num1 ** num2
    print(str(num1) + " elevado a " + str(num2) + " = " +  str(result))

def logaritmo10():
    num1 = int(input("Introduce un numero: "))
    result = math.log10(num1)
    print("El logaritmo en base 10 de " + str(num1) + " es " + str(result))

def fecha():
    print("La fecha de hoy es: " + str(datetime.datetime.now()))

def conseguirPath():
    print("La ruta de PYTHONPATH es: " + str(sys.path))