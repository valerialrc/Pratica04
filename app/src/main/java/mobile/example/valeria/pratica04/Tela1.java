package mobile.example.valeria.pratica04;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tela1 extends AppCompatActivity {
    static final int TELA2_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela1);
    }

    public void enviar(View view) {
        EditText peso = (EditText) findViewById(R.id.editPeso);
        EditText sexo = (EditText) findViewById(R.id.editSexo);
        EditText copos = (EditText) findViewById(R.id.editCopos);
        EditText jejum = (EditText) findViewById(R.id.editJejum);

        //Intent it = new Intent(getBaseContext(), Tela2.class);

        Intent it = new Intent("ACAO");

        Bundle params = new Bundle();

        params.putDouble("peso", Double.parseDouble(peso.getText().toString()));
        params.putString("sexo", sexo.getText().toString());
        params.putInt("copos", Integer.parseInt(copos.getText().toString()));
        params.putString("jejum", jejum.getText().toString());

        it.putExtras(params);
        startActivityForResult(it, TELA2_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TELA2_REQUEST) {
            Toast.makeText(this, "Taxa de Alcoolemia: ", Toast.LENGTH_LONG).show();
            if(data != null){
                Bundle params = data.getExtras();
                double t = params.getDouble("taxa");
                String cl = params.getString("cl");

                DecimalFormat df = new DecimalFormat("0.##");

                Toast.makeText(this, "Taxa de Alcoolemia: " + df.format(t) + "\nClassificação: " + cl, Toast.LENGTH_LONG).show();
            }
        }
    }
}