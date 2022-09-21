package com.quentinrouet.okhttp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient client = new OkHttpClient();
        Request requestSwapi = new Request.Builder().url("https://swapi.dev/api/people/1").build();
        client.newCall(requestSwapi).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage() );
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String bodyStringLuke = response.body().string();
                    Log.i(TAG, "onResponse: "+bodyStringLuke);
                    try {
                        JSONObject lukeJson = new JSONObject(bodyStringLuke);
                        People luke = new People(
                                lukeJson.getString("name"),
                                lukeJson.getString("height"),
                                lukeJson.getString("mass"),
                                lukeJson.getString("hair_color")
                        );
                        Log.i(TAG, "Le prénom du personnage est "+luke.getName());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}