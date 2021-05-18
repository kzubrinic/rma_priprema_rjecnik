package hr.kruno.z2.rma_priprema_k_05_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PregledActivity extends AppCompatActivity {
    private List<StavkaRjecnika> values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregled);
        setTitle("Pregled rječnika");
        values = procitaj();
        RecyclerView recyclerView = findViewById(R.id.pregled);

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        PregledAdapter mAdapter = new PregledAdapter(values, this);
        recyclerView.setAdapter(mAdapter);
    }
    private List<StavkaRjecnika> procitaj(){
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Context c = getApplicationContext();
        SharedPreferences sp = c.getSharedPreferences("rjecnik", Context.MODE_PRIVATE);
        Map<String, String> sve = (Map<String,String>)sp.getAll();
        List<StavkaRjecnika> sr = new ArrayList<>();
        for(Map.Entry<String, String> el : sve.entrySet()){
            sr.add(new StavkaRjecnika(el.getKey(), el.getValue()));
        }
        if(sr.size() == 0){
            Toast.makeText(this,"Rječnik je prazan!\nUnesite stavke kroz izbornik ažuriranja!", Toast.LENGTH_LONG).show();
        }
        Collections.sort(sr);
        return sr;
    }
}