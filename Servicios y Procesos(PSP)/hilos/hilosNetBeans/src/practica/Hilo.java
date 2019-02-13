package practica;
public class Hilo extends Thread{

    private Panel p;
    int numero; 
    
    public Hilo(Panel p, int numero){
        this.p = p;
    }

    @Override
    public void run() {
        numero = Integer.parseInt(p.texto.getText());
        while (numero > 0) {
            System.out.println("Matame");
            p.texto.setText(String.valueOf(--this.numero));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Fallo en el sleep");
            }
        }
    }

}
