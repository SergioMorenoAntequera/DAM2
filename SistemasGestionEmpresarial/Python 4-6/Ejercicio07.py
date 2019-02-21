import os

os.system('cls')
leer = open("Ejercicio07Entrada.txt", "r")

cad = []

for linea in leer:
    letra = linea[0:1]
    cad.append(letra)

print("Lista leida del fichero")
print(cad)

print("Lista ordenada: ")
cad.sort()
print(cad)

escribir = open("Ejercicio07Salida.txt", "w")
for a in cad:
    escribir.write(a+"\n")
print("Archivo con la lista creado y rellenados correctamente")