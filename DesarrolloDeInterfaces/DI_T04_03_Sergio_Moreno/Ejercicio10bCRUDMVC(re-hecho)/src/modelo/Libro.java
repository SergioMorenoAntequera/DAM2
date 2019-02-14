
package modelo;

/**
 *
 * @author seran
 */
public class Libro {

    private int codigo;
    private String nombre;
    private String autor;
    private String editorial;
    private int numPag;

    //--------------------------------------------------------------------------
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //----------------------------------
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //----------------------------------

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    //----------------------------------
    
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    //----------------------------------
    
    public int getNumPag() {
        return numPag;
    }
    public void setNumPag(int numPag) {
        this.numPag = numPag;
    } 
}

