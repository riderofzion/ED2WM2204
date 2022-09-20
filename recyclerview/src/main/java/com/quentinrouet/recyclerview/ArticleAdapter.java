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
   private ArrayList<Article> arrayListArticles;

   public ArticleAdapter(ArrayList<Article> arrayListArticles) {
      this.arrayListArticles = arrayListArticles;
   }

   @NonNull
   @Override
   public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater infalter = LayoutInflater.from(parent.getContext());
      //On transforme le fichier de layout en view java
      View v = infalter.inflate(R.layout.layout_article_item,parent,false);

      LayoutArticleItemBinding binding =
              LayoutArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
      return new ArticleViewHolder(binding);
   }

   @Override
   public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
      holder.binding.setArticle(arrayListArticles.get(position));
   }

   @Override
   public int getItemCount() {
      return arrayListArticles.size();
   }

   protected class ArticleViewHolder extends RecyclerView.ViewHolder{
      private LayoutArticleItemBinding binding;
      public ArticleViewHolder(@NonNull LayoutArticleItemBinding binding) {
         super(binding.getRoot());
         this.binding = binding;
      }
   }
}
