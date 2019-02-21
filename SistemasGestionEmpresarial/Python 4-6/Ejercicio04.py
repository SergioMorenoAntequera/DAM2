import os

def esvocal(car):
    vocales = "aeiouAEIOU"
    b = vocales.find(car)
    if b>= 0:
        return True
    else:
        return False

os.system('cls')

c = 0
cadena = input("Introduce una cadena para contar vocales: ")
for a in cadena:
    if (esvocal(a)):
        print("Vocal encontrada: " + a)
        c += 1

print("Total de vocales encontradas: " + str(c))