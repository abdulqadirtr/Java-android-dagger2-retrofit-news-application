package app.easylink.newsapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.easylink.newsapplication.R;
import app.easylink.newsapplication.model.ArticlesItem;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context context;
    List<ArticlesItem> postList;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);
        return new ViewHolder(view);
    }

    public PostAdapter(Context context, List<ArticlesItem> items){
        this.context = context;
        this.postList = items;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticlesItem a = postList.get(position);
        holder.tvTitle.setText(postList.get(position).getTitle());
        holder.tvData.setText(postList.get(position).getSource().getName());
        holder.tvData.setText(postList.get(position).getPublishedAt());

        String imgUrl = a.getUrlToImage();
        Picasso.with(context).load(imgUrl).into(holder.img);

        Toast.makeText(context,imgUrl,Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSource, tvData;
        ImageView img;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSource = itemView.findViewById(R.id.tvSource);
            tvData = itemView.findViewById(R.id.tvDate);
            img =  itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
