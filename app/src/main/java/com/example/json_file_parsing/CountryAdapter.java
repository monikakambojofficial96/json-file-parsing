package com.example.json_file_parsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    Context context;
    ArrayList<Country> countryNames;


    public CountryAdapter(Context context, ArrayList<Country> countryNames) {
        this.context = context;
        this.countryNames = countryNames;

    }

        @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater= LayoutInflater.from(parent.getContext());
            View view=inflater.inflate(R.layout.item_layout,parent,false);

            return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(countryNames.get(position).name);
    }

    @Override
    public int getItemCount() {
        return countryNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.Text_title);
            imageView=itemView.findViewById(R.id.image_icons);
        }
    }
}
