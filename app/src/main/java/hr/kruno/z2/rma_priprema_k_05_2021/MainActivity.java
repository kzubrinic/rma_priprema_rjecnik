package hr.kruno.z2.rma_priprema_k_05_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.glavni_izbornik, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Obrada akcija izbornika opcija
        switch (item.getItemId()) {
            case R.id.azuriranje:
                Intent azur = new Intent(this, AzuriranjeActivity.class);
                startActivity(azur);
                return true;
            case R.id.pregled:
                Intent preg = new Intent(this, PregledActivity.class);
                startActivity(preg);
                return true;
             default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void trazi(View view) {
        EditText rijec = findViewById(R.id.rijec);
        EditText opis = findViewById(R.id.opis);
        Context c = getApplicationContext();
        if(rijec.getText().length() <= 0) {
            Toast.makeText(c, "Riječ mora biti unesena!", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = c.getSharedPreferences("rjecnik", Context.MODE_PRIVATE);
        String op = sp.getString(rijec.getText().toString(), "");
        opis.setText(op);
    }
}