package app.easylink.newsapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import app.easylink.newsapplication.R;
import app.easylink.newsapplication.databinding.ItemsBinding;
import app.easylink.newsapplication.model.ArticlesItem;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context context;
    List<ArticlesItem> postList = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemsBinding binding= ItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    public PostAdapter(Context context, List<ArticlesItem> items){
        this.context = context;
        postList.clear();
        postList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticlesItem a = postList.get(position);
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemsBinding binding;

         ViewHolder( ItemsBinding binding ) {
             super(binding.getRoot());
             this.binding = binding;
        }
        public void bind(ArticlesItem a){
            binding.tvTitle.setText(a.getTitle());
            binding.tvDate.setText(a.getSource().getName());
            binding.tvSource.setText(a.getPublishedAt());

            String imgUrl = a.getUrlToImage();
            Picasso.with(context).load(imgUrl).into(binding.image);
        }
    }
}
