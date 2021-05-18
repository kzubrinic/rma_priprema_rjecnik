package hr.kruno.z2.rma_priprema_k_05_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AzuriranjeActivity extends AppCompatActivity {
    private EditText rijec, opis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azuriranje);
        rijec = findViewById(R.id.rijec);
        opis = findViewById(R.id.opis);
        setTitle("Ažuriranje rječnika");
    }

    public void azuriranje(View view) {
        Context c = getApplicationContext();
        if(rijec.getText().length() <= 0 || opis.getText().length() <= 0){
            Toast.makeText(c, "Riječ i opis moraju biti uneseni!", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = c.getSharedPreferences("rjecnik", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(rijec.getText().toString(), opis.getText().toString());
        editor.apply();
        Toast.makeText(c, "Podaci su spremljeni!", Toast.LENGTH_SHORT).show();
   }

    public void brisanje(View view) {
        Context c = getApplicationContext();
        if(rijec.getText().length() <= 0) {
            Toast.makeText(c, "Riječ mora biti unesena!", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = c.getSharedPreferences("rjecnik", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(rijec.getText().toString());
        editor.apply();
        Toast.makeText(c, "Podaci su izbrisani!", Toast.LENGTH_SHORT).show();
        //rijec.setText("");
        //opis.setText("");
        rijec.requestFocus();
    }
}