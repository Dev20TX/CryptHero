package com.dev20tx.android.cryptohero.adapter;


import android.content.res.Resources;
import android.graphics.Color;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev20tx.android.cryptohero.Model.Coin;
import com.dev20tx.android.cryptohero.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.RecyclerViewHolder> {


    private ArrayList<Coin> mCoinList;


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView coin_icon;
        public TextView coin_symbol, coin_name, coin_price, one_hour_change, twentyFour_hour_change, seven_day_change;

        public RecyclerViewHolder(View itemView) {
            super (itemView);

            coin_icon = itemView.findViewById (R.id.coin_icon);
            coin_symbol = itemView.findViewById (R.id.coin_symbol);
            coin_name = itemView.findViewById (R.id.coin_name);
            coin_price = itemView.findViewById (R.id.priceUsdText);
            one_hour_change = itemView.findViewById (R.id.oneHourText);
            twentyFour_hour_change = itemView.findViewById (R.id.twentyFourHourText);
            seven_day_change = itemView.findViewById (R.id.sevenDayText);


        }

    }

    public CoinAdapter(ArrayList<Coin> CoinList) {
        mCoinList = CoinList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ())
                .inflate (R.layout.content_main, parent, false);
        RecyclerViewHolder rvh = new RecyclerViewHolder (view);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Coin currentCoin = mCoinList.get (position);


        holder.coin_name.setText (currentCoin.getName ());
        holder.coin_symbol.setText (currentCoin.getSymbol ());
        holder.coin_price.setText (String.format ("%.2f", Double.parseDouble (currentCoin.getPrice_usd ())));
        holder.one_hour_change.setText (String.format ("1hr " + "%.2f", Double.parseDouble (currentCoin.getPercent_change_1h ())) + "%");
        holder.twentyFour_hour_change.setText (String.format ("24hr " + "%.2f", Double.parseDouble (currentCoin.getPercent_change_24h ())) + "%");
        holder.seven_day_change.setText (String.format ("7d " + "%.2f", Double.parseDouble (currentCoin.getPercent_change_7d ())) + "%");


        //Using picasso to load image/
  /*       Picasso.with(activity)
         .load(new StringBuilder ("https://res.cloudinary.com/dxi90ksom/image/upload/")
         .append(currentCoin.getSymbol ().toLowerCase ()).append(".png").toString ())
         .into(holder.coin_icon);
*/
        holder.one_hour_change.setTextColor (currentCoin.getPercent_change_1h ().contains ("-") ?
                Color.parseColor ("#FF0000") : Color.parseColor ("#32CD32"));
        holder.twentyFour_hour_change.setTextColor (currentCoin.getPercent_change_24h ().contains ("-") ?
                Color.parseColor ("#FF0000") : Color.parseColor ("#32CD32"));
        holder.seven_day_change.setTextColor (currentCoin.getPercent_change_7d ().contains ("-") ?
                Color.parseColor ("#FF0000") : Color.parseColor ("#32CD32"));

    }

    @Override
    public int getItemCount() {
        return mCoinList.size ();
    }
}