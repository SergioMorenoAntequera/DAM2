package coches;

public class Operario {
    
    String nombre;
    TiposLavados tipoLavado;
    int tiempoExtra = 0;
    
    Operario(TiposLavados tipoLavado, String nombre){
        this.tipoLavado = tipoLavado;
        this.nombre = nombre;
        if(this.tipoLavado == TiposLavados.EXTRA){
            tiempoExtra += 2;
        }
        if(this.tipoLavado == TiposLavados.SUPER){
            tiempoExtra += 2;
            tiempoExtra += 2;
        }
    }

    public void setTipoLavado(TiposLavados tipoLavado) {
        this.tipoLavado = tipoLavado;
    }
    public TiposLavados getTipoLavado() {
        return tipoLavado;
    }
    public void setTiempoExtra(int tiempoExtra) {
        this.tiempoExtra = tiempoExtra;
    }
    public int getTiempoExtra() {
        return tiempoExtra;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
