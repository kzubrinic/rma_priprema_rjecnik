package hr.kruno.z2.rma_priprema_k_05_2021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class PregledAdapter extends RecyclerView.Adapter<PregledAdapter.MyViewHolder>{
    private List<StavkaRjecnika> mDataset;
    private Context con;
    // Prima se referenca na izvor podataka - u ovom slučaju polje stringova
    public PregledAdapter(List<StavkaRjecnika> myDataset, Context c) {
        mDataset = myDataset;
        con = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // stvara se novi view iz standardnog jednostavnog layouta retka
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2, parent, false);
        // Unutarnja klasa tipa ViewHolder čuva referencu na view
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Kada se korisnik pozicionira na određeni redak sadržaj retka viewa se ažurira
        // podatkom iz dataseta koji se nalazi na istoj poziciji.
        holder.label1.setText(mDataset.get(position).getRijec());
        //if (mDataset.get(position).getOpis().length() > 30)
        //    holder.label2.setText(mDataset.get(position).getOpis().substring(0,30));
        //else
            holder.label2.setText(mDataset.get(position).getOpis());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();

    }

    // Unutarnja klasa tipa ViewHolder čuva referencu na view
    // U njoj se obrađuje događaj pritiska/klika na stavku
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView label1, label2;
        public MyViewHolder(View itemView) {
            super(itemView);
            label1 = itemView.findViewById(android.R.id.text1);
            label2 = itemView.findViewById(android.R.id.text2);
            // referenca na objekt tipa MyViewHolder se sprema kao tag elementa liste
            itemView.setTag(this);
            // registrira se listener
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // vrati poziciju na koju je korisnik kliknuo
            int pos = getAdapterPosition();
            notifyDataSetChanged();

            // Dohvat podataka iz adaptera
            // Check if an item was deleted, but the user clicked it before the UI removed it
            if (pos != RecyclerView.NO_POSITION) {
                // Dohvaća se podatak iz dataseta koji se nalazi na poziciji kliknutog retka liste
                String pok = mDataset.get(pos).toString();
                Toast.makeText(con, pok, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
