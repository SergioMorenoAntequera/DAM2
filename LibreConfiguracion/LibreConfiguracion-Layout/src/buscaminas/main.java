package buscaminas;

public class main {
    //Datos princiales
    int filas, columnas, minas;
    
    public static void main(String[] args){
        
        //filas, columnas, minas//
        rellenarMatriz(5, 5, 25);
        
    }
    
    static void rellenarMatriz(int filas, int columnas, int minas){
        //Creamos el campo
        int[][] campo = new int[filas][columnas];
        
        //Rellenamos la matriz de -1
        for(int i = 0; i < campo.length; i++){
            for(int j = 0; j < campo[i].length; j++){
                campo[i][j] = -1;
            }
        }
        
        PonerMinas(minas, filas, columnas, campo);

        MostrarCampo(campo);
    }

    private static void PonerMinas(int minas1, int filas1, int columnas1, int[][] campo) {
        //Generar minas aleatorias y colocarlas
        for (int i = 0; i < minas1; i++) {
            int mina1 = (int) (Math.random() * filas1);
            int mina2 = (int) (Math.random() * columnas1);
            
            if(campo[mina1][mina2] == -9){
                i--;
            } else {
                campo[mina1][mina2] = 9; 
            }
        }
    }
    
    //Metodo que enseña la matriz
    private static void MostrarCampo(int[][] campo) {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[i].length; j++) {
                System.out.print(campo[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    
}


