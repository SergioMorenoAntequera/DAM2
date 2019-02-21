import os

os.system('cls')

lista1 = [23, 321, 412, 12]
lista2 = [6, 2, 45, 24]

listaCad1 = ["b", "a", "h", "c"]
listaCad2 = ["y", "u", "y", "o"]

listaCompleta = lista1 + lista2
listaCadCompleta = listaCad1 + listaCad2

listaCompletaOrdenada = sorted(listaCompleta)

print("***** NUMEROS *****")
print("Lista completa sin ordenar: ")
print(listaCompleta)

print("Lista completa ordenada: ")
print(listaCompletaOrdenada)
print("Lista completa inversa: ")
listaCompletaOrdenada.reverse()
print(listaCompletaOrdenada)


print("")

# Cadenas ################################################
print("***** CADENAS ******")
print("Lista completa sin ordenar: ")
print(listaCadCompleta)

print("Lista completa ordenada: ")
listaCadCompleta.sort()
print(listaCadCompleta)

print("Lista completa inversa: ")
listaCadCompleta.reverse()
print(listaCadCompleta)