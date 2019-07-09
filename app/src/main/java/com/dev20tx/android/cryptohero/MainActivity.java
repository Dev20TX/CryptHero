package com.dev20tx.android.cryptohero;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.widget.Toolbar;


import com.dev20tx.android.cryptohero.Model.Coin;
import com.dev20tx.android.cryptohero.adapter.CoinAdapter;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerview;
    private RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Coin> mCoinList = new ArrayList<> ();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        mRecyclerview = findViewById (R.id.recyclerViewId);
        mRecyclerview.setHasFixedSize (false);
        mLayoutManager = new LinearLayoutManager (this);
        mRecyclerview.setLayoutManager (mLayoutManager);


        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ("https://api.coinmarketcap.com/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        Api api = retrofit.create (Api.class);

        Call<ArrayList<Coin>> call = api.getCoins ();

//press control + space on line below to get callback and methods
        call.enqueue (new Callback<ArrayList<Coin>> () {

            @Override
            public void onResponse(Call<ArrayList<Coin>> call, Response<ArrayList<Coin>> response) {
                mAdapter = new CoinAdapter (response.body ());
                mRecyclerview.setAdapter (mAdapter);


            }

            @Override
            public void onFailure(Call<ArrayList<Coin>> call, Throwable t) {
                Toast.makeText (getApplicationContext (), t.getMessage (), Toast.LENGTH_SHORT).show ();


            }

        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
