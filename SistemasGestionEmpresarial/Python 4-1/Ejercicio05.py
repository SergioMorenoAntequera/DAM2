
cantidad = input("Introduce el numero de palabras que tiene la lista: ")
intCantidad = int(cantidad)

if(intCantidad <= 0):
	print("ERROR, la lista debe tener como mínimo un valor!")
else:
	c = 0;
	lista = [None] * intCantidad
	while(c < intCantidad):
		lista[c] = input("Introduce la palabra: ")
		c = c + 1
	print("La lista creada es: ", lista)
	
	listaInversa = [None] * intCantidad
	c = 0;
	for i in reversed(lista):
		listaInversa[c] = i
		c = c + 1
	
	print("La lista inversa es: ", listaInversa)