package com.example.cookin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PasosAdapter extends RecyclerView.Adapter<PasosAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<JSONObject> pasosData;

    public PasosAdapter(Context ctx, ArrayList<JSONObject> pasosData) {
        this.ctx = ctx;
        this.pasosData = pasosData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ctx)
            .inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.bindTo(pasosData.get(position));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return pasosData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pasoContent;
        private ImageView pasoImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pasoContent = itemView.findViewById(R.id.pasoContent);
            pasoImg = itemView.findViewById(R.id.imgPaso);
        }

        public void bindTo(JSONObject pasoInfo) throws JSONException {
            pasoContent.setText(pasoInfo.getString("content"));
            int id = ctx.getResources().getIdentifier(pasoInfo.getString("img"), "drawable", ctx.getPackageName());
            pasoImg.setImageResource(id);
        }
    }
}
