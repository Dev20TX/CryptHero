package com.dev20tx.android.cryptohero;

import com.dev20tx.android.cryptohero.Model.Coin;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("v1/ticker")
    Call<ArrayList<Coin>> getCoins();
}
