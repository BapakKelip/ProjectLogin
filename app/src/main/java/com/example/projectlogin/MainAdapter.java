package com.example.projectlogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List <Model> models;
    private Callback callback;
    private Context context;
    interface  Callback{
        void call(int position);
    }
    public MainAdapter (List<Model> models , Context context , Callback callback){
        this.models = models;
        this.callback = callback;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = models.get(position);
        holder.judul.setText(model.getJudul());
        holder.date.setText(model.getJudul());
        Picasso.get()
                .load(models.get(position).getGambar())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (models != null ) ? models.size() : 0 ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout relativeLayout;
        private TextView date, judul;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgberita);
            date = itemView.findViewById(R.id.txt_date);
            judul = itemView.findViewById(R.id.txt_judul);
            relativeLayout = itemView.findViewById(R.id.relative_item);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.call(getAdapterPosition());
                }
            });
        }
    }
}
