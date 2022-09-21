package com.quentinrouet.amazeni;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ListArticlesFragment extends Fragment {
    private static final String TAG = "ListArticlesFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_articles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv = view.findViewById(R.id.recyclerViewArticles);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        //Téléchager mes articles
        OkHttpClient client = new OkHttpClient();
        Request requestArticles = new Request.Builder().url("https://fakestoreapi.com/products/").build();
        client.newCall(requestArticles).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String responseArticles = response.body().string();
                    ArrayList<Article> articleArrayList = new ArrayList<>();
                    // Les transformer en ArrayList<Article>
                    try {
                        JSONArray arrayJsonArticles = new JSONArray(responseArticles);
                        for (int i = 0; i < arrayJsonArticles.length(); i++) {
                            JSONObject ratingJson = arrayJsonArticles.getJSONObject(i).getJSONObject("rating");
                            Rating rating = new Rating(
                                    (float)ratingJson.getDouble("rate"),
                                    ratingJson.getInt("count")
                            );
                            articleArrayList.add(new Article(
                                    arrayJsonArticles.getJSONObject(i).getInt("id"),
                                    arrayJsonArticles.getJSONObject(i).getString("title"),
                                    arrayJsonArticles.getJSONObject(i).getString("description"),
                                    arrayJsonArticles.getJSONObject(i).getString("category"),
                                    arrayJsonArticles.getJSONObject(i).getString("image"),
                                    ((float) arrayJsonArticles.getJSONObject(i).getDouble("price")),
                                    rating
                            ));
                            getActivity().runOnUiThread(() -> {
                                rv.setAdapter(new ArticleAdapter(articleArrayList));
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.i(TAG, "onResponse: " + response.code());
                }
            }
        });

        //Les afficher dans ma recyclerview
    }
}