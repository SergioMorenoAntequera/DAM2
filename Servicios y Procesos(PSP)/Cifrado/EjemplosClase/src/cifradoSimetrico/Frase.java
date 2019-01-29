/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradoSimetrico;

/**
 *
 * @author windiurno
 */
public class Frase {
    
    private String frase;
    private String password;

    //--------------------------------------------------------------------------
    
    public Frase(String frase, String password) {
        this.frase = frase;
        this.password = password;
    }

    //--------------------------------------------------------------------------
    
    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
