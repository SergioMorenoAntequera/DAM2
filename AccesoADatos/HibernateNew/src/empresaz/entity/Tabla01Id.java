package empresaz.entity;
// Generated 13-nov-2018 8:40:41 by Hibernate Tools 4.3.1



/**
 * Tabla01Id generated by hbm2java
 */
public class Tabla01Id  implements java.io.Serializable {


     private int columna1;
     private int columna2;

    public Tabla01Id() {
    }

    public Tabla01Id(int columna1, int columna2) {
       this.columna1 = columna1;
       this.columna2 = columna2;
    }
   
    public int getColumna1() {
        return this.columna1;
    }
    
    public void setColumna1(int columna1) {
        this.columna1 = columna1;
    }
    public int getColumna2() {
        return this.columna2;
    }
    
    public void setColumna2(int columna2) {
        this.columna2 = columna2;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Tabla01Id) ) return false;
		 Tabla01Id castOther = ( Tabla01Id ) other; 
         
		 return (this.getColumna1()==castOther.getColumna1())
 && (this.getColumna2()==castOther.getColumna2());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getColumna1();
         result = 37 * result + this.getColumna2();
         return result;
   }   


}

