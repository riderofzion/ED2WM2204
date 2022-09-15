package com.quentinrouet.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quentinrouet.recyclerview.databinding.LayoutArticleItemBinding;

import java.util.ArrayList;

/**
 * Created by quentin for HelloWorld on 15/09/2022.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
   private ArrayList<Article> articles;

   public ArticleAdapter(ArrayList<Article> articles) {
      this.articles = articles;
   }

   @NonNull
   @Override
   public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //Transformer layout_article_item.xml en une vue
      LayoutArticleItemBinding binding = LayoutArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
      return new ArticleViewHolder(binding);
   }

   @Override
   public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
      holder.binding.setArticle(articles.get(position));
   }

   @Override
   public int getItemCount() {
      return articles.size();
   }

   protected class ArticleViewHolder extends RecyclerView.ViewHolder{
      private LayoutArticleItemBinding binding;
      public ArticleViewHolder(@NonNull LayoutArticleItemBinding binding) {
         super(binding.getRoot());
         this.binding = binding;
      }
   }
}
