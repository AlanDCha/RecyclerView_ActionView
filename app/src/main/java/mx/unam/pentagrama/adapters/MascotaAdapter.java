package mx.unam.pentagrama.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import mx.unam.pentagrama.ListadoMascotas;
import mx.unam.pentagrama.R;
import mx.unam.pentagrama.pojo.Mascota;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas ) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contact, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgPhoto.setImageResource(mascota.getPhoto());
        holder.tvRatingCV.setText(mascota.getRating());
        holder.tvNameCV.setText(mascota.getName());

//        holder.imgBone.setOnClickListener(v -> {
//            Toast.makeText(activity, "You liked to " + mascota.getName(),
//                    Toast.LENGTH_SHORT).show();
//        });

        holder.imgBone.setOnClickListener(v -> Toast.makeText(v.getContext(), "You liked to: " + mascota.getName(), Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return mascotas.size(); // Amount of elements that contains my list
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhoto;
        private TextView tvNameCV;
        private ImageButton imgBone;
        private TextView tvRatingCV;
        private ImageView imgRating;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto   = (ImageView)   itemView.findViewById(R.id.imgPhoto);
            imgBone    = (ImageButton) itemView.findViewById(R.id.imgBone);
            imgRating  = (ImageView)   itemView.findViewById(R.id.imgRating);
            tvNameCV   = (TextView)    itemView.findViewById(R.id.tvNameCV);
            tvRatingCV = (TextView)    itemView.findViewById(R.id.tvRatingCV);
        }
    }
}
