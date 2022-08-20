package mx.unam.pentagrama.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.unam.pentagrama.R;
import mx.unam.pentagrama.pojo.Mascota;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHoler>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public ProfileAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProfileViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_profile, parent, false);
        return new ProfileViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHoler holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgPet.setImageResource(mascota.getPhoto());
        holder.tvValue.setText(mascota.getRating());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class ProfileViewHoler extends RecyclerView.ViewHolder {
        private ImageView imgPet;
        private ImageView imgHueso;
        private TextView  tvValue;

        public ProfileViewHoler(@NonNull View itemView) {
            super(itemView);
            imgHueso = itemView.findViewById(R.id.imgHueso);
            imgPet   = itemView.findViewById(R.id.imgPet);
            tvValue  = itemView.findViewById(R.id.tvValue);
        }
    }
}
