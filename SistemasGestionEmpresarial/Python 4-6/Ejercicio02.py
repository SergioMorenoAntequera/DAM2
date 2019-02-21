#-*- coding: utf-8 -*-
#!/usr/bin/env python
# Este archivo usa el encoding: utf-8
#-*- coding: Windows-1252 -*-
#-*- coding: cp850 -*-
#-*- coding: cp1252 -*-
#-*- coding: IBM850 -*-
import os

# Variables globales ##########################################################################
Cuentas=[]
Monto=[]
rep=0

# Metodos #####################################################################################
def registrar():
    print("HA ELIGIDO EL REGISTRO DE CLIENTE \n")
    nom = input("Ingrese su nombre:\n")
    Cuentas.append(nom)
    mon=float(input("Ingrese la cantidad que desea depositar a su cuenta:\n"))
    Monto.append(mon)

def consultarSaldo():
    print("HA ELIDO CONSULTAR SU SALDO\n")
    nom = input("Ingrese su nombre:\n")
    if(nom in Cuentas):
        ind=Cuentas.index(nom)
        saldo=Monto[ind]
        print("Su saldo es: ",saldo,"€ ")
        print("")
    else:
        print("")
        print("Ese nombre no existe")
        print("")

def calcularIntereses():
    print("HA ELEGIDO CALCULAR EL INTERES QUE GERARA SU CUENTA\n")
    nom = input("Ingrese su nombre: \n")
    if(nom in Cuentas):
        ind=Cuentas.index(nom)
        p=Monto[ind]
        n =  int(input("Ingrese el numero de años que va a invertir su dinero\n"))
        r=0.05
        c=p*(1+r)*n
        round(c)
        print("")
        print('El interes generado en ', n ,' a'u'ños es de $',c)
        print("")
    else:
        print("")
        print("Ese nombre no existe")
        print("")

def error():
    print("")
    print('Esa no es una opción intente de nuevo\n')
    print("")

# Ejecucion #################################################################################

os.system('cls')
while(rep == 0):
    print("Bienvenido al Banco X")
    print("Elija alguna de las siguientes opciones para continuar \n")
    print("1.- Registrarse en nuestro Banco")
    print("2.- Consultar su saldo")
    print("3.- Calcular interes que generara su saldo a cierto tiempo")
    print("4.- Si quiere salir")
    o = int(input(" Elige (1-4):"))


    if (o==1):
        registrar()
        

    elif(o==2):
        consultarSaldo()

    elif(o==3):
        calcularIntereses()

    elif(o==4):
        exit()

    elif(o<1 or o>4):
        error()
    
    input("Pulse 'ENTER' para continuar...")
    os.system('cls')


    