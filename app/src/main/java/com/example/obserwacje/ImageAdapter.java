package com.example.obserwacje;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private List<Image> images;

    public ImageAdapter(Context context, List<Image> images){
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Image image = images.get(position);
        String species = image.getSpecies();
        String name = image.getName();
        String place = image.getPlace();
        String county = image.getCounty();
        String date = image.getDate();
        holder.textView.setText(species+", obs. "+name+", "+place+" (gm. "+county+"). "+date);
        Picasso.get().load(image.getImageURI()).fit().centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;

        public ImageViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.galleryTextView);
            imageView = view.findViewById(R.id.imageView);
        }
    }
}
