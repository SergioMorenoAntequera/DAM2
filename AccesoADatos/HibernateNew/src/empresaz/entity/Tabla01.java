package empresaz.entity;
// Generated 13-nov-2018 8:40:41 by Hibernate Tools 4.3.1



/**
 * Tabla01 generated by hbm2java
 */
public class Tabla01  implements java.io.Serializable {


     private Tabla01Id id;
     private Integer columna3;
     private Integer columna4;
     private Integer columna5;

    public Tabla01() {
    }

	
    public Tabla01(Tabla01Id id) {
        this.id = id;
    }
    public Tabla01(Tabla01Id id, Integer columna3, Integer columna4, Integer columna5) {
       this.id = id;
       this.columna3 = columna3;
       this.columna4 = columna4;
       this.columna5 = columna5;
    }
   
    public Tabla01Id getId() {
        return this.id;
    }
    
    public void setId(Tabla01Id id) {
        this.id = id;
    }
    public Integer getColumna3() {
        return this.columna3;
    }
    
    public void setColumna3(Integer columna3) {
        this.columna3 = columna3;
    }
    public Integer getColumna4() {
        return this.columna4;
    }
    
    public void setColumna4(Integer columna4) {
        this.columna4 = columna4;
    }
    public Integer getColumna5() {
        return this.columna5;
    }
    
    public void setColumna5(Integer columna5) {
        this.columna5 = columna5;
    }




}

