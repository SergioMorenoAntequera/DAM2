package dom.datosaxml.ejercicioRAF;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//*****************Para crear un RAF********************
public class CreacionRAF {

    public static void main(String[] args) {
        
        File directorio = new File("C:/Users/windiurno/Desktop/e1.dat");
        try{
            
            //Creamos el RAF
            RandomAccessFile RAF = new RandomAccessFile(directorio, "rw");
            
            //Valores en RAF
            //id -> 2 + apellido -> 60 + departamento -> 60 + salario -> 2 = 122
            long puntero = 0;
            
            RAF.seek(puntero); //Posicion 0
            RAF.writeInt(65986);            //ID
            RAF.writeUTF("Moreno");         //Apellido
            RAF.writeUTF("Informatica");    //Departamento
            RAF.writeInt(1200);             //Salario  
            System.out.println(puntero);
            
            puntero = 122;
            RAF.seek(puntero); //Posicion 122
            RAF.writeInt(11245);            //ID
            RAF.writeUTF("Antequera");      //Apellido
            RAF.writeUTF("Charcuteria");    //Departamento
            RAF.writeInt(1350);             //Salario
            System.out.println(puntero);
            
            puntero = 244;
            RAF.seek(puntero); //Posicion 244
            RAF.writeInt(66985);            //ID
            RAF.writeUTF("Lopez");          //Apellido
            RAF.writeUTF("Instalaciones");  //Departamento
            RAF.writeInt(1260);             //Salario
            System.out.println(puntero);
            
            puntero = 366;
            RAF.seek(puntero); //Posicion 366
            RAF.writeInt(42150);            //ID
            RAF.writeUTF("Caparros");       //Apellido
            RAF.writeUTF("AtencionCliente");//Departamento
            RAF.writeInt(1400);             //Salario

            System.out.println(puntero);
            
        }catch(IOException io){
            System.out.println("Dentro del IOException");
            System.out.println("HA SURGIDO UN ERROR");

        }
    }
}