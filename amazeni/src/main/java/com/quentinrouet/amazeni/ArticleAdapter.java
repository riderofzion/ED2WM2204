package com.quentinrouet.amazeni;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.quentinrouet.amazeni.databinding.ItemArticleListBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by quentin for HelloWorld on 21/09/2022.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private ArrayList<Article> articleArrayList;

    public ArticleAdapter(ArrayList<Article> articleArrayList) {
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemArticleListBinding binding = ItemArticleListBinding.inflate(inflater,parent,false);
        return new ArticleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleArrayList.get(position);
        holder.binding.setArticle(article);
        Picasso.get().load(article.getImage()).into(holder.binding.imageViewApercu);
        holder.itemView.setOnClickListener(
                v-> Navigation.findNavController(holder.itemView).navigate(R.id.actionListToBlank)
        );
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    protected class ArticleViewHolder extends RecyclerView.ViewHolder{
        ItemArticleListBinding binding;
        public ArticleViewHolder(ItemArticleListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
