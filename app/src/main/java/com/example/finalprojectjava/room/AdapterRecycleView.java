package com.example.finalprojectjava.room;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectjava.DefaultActivity;
import com.example.finalprojectjava.R;

import java.util.ArrayList;

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout parentLayout;
        TextView textJudul, textPengarang, textTahun;
        ImageView imageCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textJudul = itemView.findViewById(R.id.textJudul);
            textPengarang = itemView.findViewById(R.id.textPengarang);
            textTahun = itemView.findViewById(R.id.textTahun);
            imageCover = itemView.findViewById(R.id.imageCover);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    public AdapterRecycleView(Context context, ArrayList<ItemModel> dataItem) {
        this.dataItem = dataItem;
        this.context = context;}

    @NonNull
    @Override
    public AdapterRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycleView.ViewHolder holder, int position) {

        TextView textJudul = holder.textJudul;
        TextView textPengarang = holder.textPengarang;
        TextView textTahun = holder.textTahun;
        ImageView imageCover = holder.imageCover;

        textJudul.setText(dataItem.get(position).getJudul());
        textPengarang.setText(dataItem.get(position).getPengarang());
        textTahun.setText(dataItem.get(position).getTahun());
        imageCover.setImageResource(dataItem.get(position).getCover());

        holder.parentLayout.setOnClickListener(v->{
            Toast.makeText(context, "Anda memilih"+ dataItem.get(position).getJudul(), Toast.LENGTH_SHORT).show();

            if(dataItem.get(position).getJudul().equals("Modern Arsitektur")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", dataItem.get(position).getCover());
                intent.putExtra("TEXT_JUDUL", dataItem.get(position).getJudul());
                intent.putExtra("TEXT_PENGARANG", dataItem.get(position).getPengarang());
                intent.putExtra("TEXT_TAHUN", dataItem.get(position).getTahun());
                intent.putExtra("TEXT_ISI", dataItem.get(position).getIsi());
                context.startActivity(intent);
            }
            if(dataItem.get(position).getJudul().equals("Kesetiaan")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", dataItem.get(position).getCover());
                intent.putExtra("TEXT_JUDUL", dataItem.get(position).getJudul());
                intent.putExtra("TEXT_PENGARANG", dataItem.get(position).getPengarang());
                intent.putExtra("TEXT_TAHUN", dataItem.get(position).getTahun());
                intent.putExtra("TEXT_ISI", dataItem.get(position).getIsi());
                context.startActivity(intent);
            }if(dataItem.get(position).getJudul().equals("Gedung Tingkat Modern")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", dataItem.get(position).getCover());
                intent.putExtra("TEXT_JUDUL", dataItem.get(position).getJudul());
                intent.putExtra("TEXT_PENGARANG", dataItem.get(position).getPengarang());
                intent.putExtra("TEXT_TAHUN", dataItem.get(position).getTahun());
                intent.putExtra("TEXT_ISI", dataItem.get(position).getIsi());
                context.startActivity(intent);
            }if(dataItem.get(position).getJudul().equals("Rumah Kecil")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", dataItem.get(position).getCover());
                intent.putExtra("TEXT_JUDUL", dataItem.get(position).getJudul());
                intent.putExtra("TEXT_PENGARANG", dataItem.get(position).getPengarang());
                intent.putExtra("TEXT_TAHUN", dataItem.get(position).getTahun());
                intent.putExtra("TEXT_ISI", dataItem.get(position).getIsi());
                context.startActivity(intent);
            }if(dataItem.get(position).getJudul().equals("Jurnal Siswa Siswi")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", dataItem.get(position).getCover());
                intent.putExtra("TEXT_JUDUL", dataItem.get(position).getJudul());
                intent.putExtra("TEXT_PENGARANG", dataItem.get(position).getPengarang());
                intent.putExtra("TEXT_TAHUN", dataItem.get(position).getTahun());
                intent.putExtra("TEXT_ISI", dataItem.get(position).getIsi());
                context.startActivity(intent);
            }if(dataItem.get(position).getJudul().equals("Buku Catatan")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", dataItem.get(position).getCover());
                intent.putExtra("TEXT_JUDUL", dataItem.get(position).getJudul());
                intent.putExtra("TEXT_PENGARANG", dataItem.get(position).getPengarang());
                intent.putExtra("TEXT_TAHUN", dataItem.get(position).getTahun());
                intent.putExtra("TEXT_ISI", dataItem.get(position).getIsi());
                context.startActivity(intent);
            }if(dataItem.get(position).getJudul().equals("Business Digital")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", dataItem.get(position).getCover());
                intent.putExtra("TEXT_JUDUL", dataItem.get(position).getJudul());
                intent.putExtra("TEXT_PENGARANG", dataItem.get(position).getPengarang());
                intent.putExtra("TEXT_TAHUN", dataItem.get(position).getTahun());
                intent.putExtra("TEXT_ISI", dataItem.get(position).getIsi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public void setFilter(ArrayList<ItemModel> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
