package mobile.example.valeria.pratica04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Tela2 extends AppCompatActivity {
    double t;
    double c;
    String cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        Intent it = getIntent();
        Bundle params = it.getExtras();
        double peso = params.getDouble("peso");
        String sexo = params.getString("sexo");
        int copos = params.getInt("copos");
        String jejum = params.getString("jejum");

        if(sexo.equals("m") && jejum.equals("s")){
            c = 0.7;
        }
        else if(sexo.equals("f") && jejum.equals("s")){
            c = 0.6;
        }
        else {
            c = 1.1;
        }

        t = (double) 4.8*copos/(peso*c);

        Log.i("Ciclo de vida",".onRestart chamado." + t);

        if(t > 0.0){
            cl = "Pessoa Alcoolizada";
        }
        else{
            cl = "Pessoa NÃO Alcoolizada";
        }

    }

    public void mensagem(View view) {
        Intent it = new Intent();
        Bundle params = new Bundle();
        params.putDouble("taxa", t);
        params.putString("cl", cl);
        it.putExtras(params);
        setResult(1, it);

        finish();
    }
}