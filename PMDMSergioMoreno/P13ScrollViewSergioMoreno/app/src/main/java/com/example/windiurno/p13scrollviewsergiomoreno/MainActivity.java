package com.example.windiurno.p13scrollviewsergiomoreno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Procedimiento que consulta ek ud del objeto qyue ha generado el evento y
    //Según sea muestra un mensaje
    public void seleccionFrutaClick(View v){
        //Dentro del objeto view tenemos la propiedad id que identifica de forma unica cada objeto
        switch (v.getId()){
            case R.id.ibCereza : {
                Toast.makeText(this, "CEREZA", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibFresa : {
                Toast.makeText(this, "FRESA", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibKiwi : {
                Toast.makeText(this, "KIWI", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibPera : {
                Toast.makeText(this, "PERA", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibPina : {
                Toast.makeText(this, "PIÑA", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibPlatano : {
                Toast.makeText(this, "PLATANO", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibRemolacha : {
                Toast.makeText(this, "REMOLACHA", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibSandia : {
                Toast.makeText(this, "SANDIA", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibTomate : {
                Toast.makeText(this, "TOMATE", Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.ibUvas : {
                Toast.makeText(this, "UVAS", Toast.LENGTH_LONG).show();
            }
            break;
        }


    }

}
