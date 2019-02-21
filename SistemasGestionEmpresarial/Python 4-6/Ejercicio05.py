import os

os.system('cls')
lista1 = ["cadena", "arbol", "dedo", "pamplona"]
lista2 = ["hola", "bombilla", "python", "ordenar"]

listaCompleta = lista1 + lista2

print("Primera lista")
print(lista1)
print("Segunda lista")
print(lista2)

print("")

print("Lista completa: ")
print(listaCompleta)

archivo = open("Ejercicio05Salida.txt", "w")
cad = ""
for a in listaCompleta:
    archivo.write(a)



