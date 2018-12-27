package com.muhaiminurabir.slider;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cooltechworks.creditcarddesign.CreditCardView;

import java.util.ArrayList;

public class CoverFlowAdapter extends BaseAdapter {

    private ArrayList<CARD> data;
    private AppCompatActivity activity;

    public CoverFlowAdapter(AppCompatActivity context, ArrayList<CARD> objects) {
        this.activity = context;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CARD getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_one, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //viewHolder.creditCardView.setImageResource(data.get(position).getImageSource());
        viewHolder.gameName.setText(data.get(position).getName());

        viewHolder.creditCardView.setCVV(data.get(position).getCvv());
        viewHolder.creditCardView.setCardHolderName(data.get(position).getName());
        viewHolder.creditCardView.setCardExpiry(data.get(position).getExpiry());
        viewHolder.creditCardView.setCardNumber(data.get(position).getCardNumber());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_card_info);
                dialog.setCancelable(true); // dimiss when touching outside
                dialog.setTitle("Game Details");

                TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(getItem(position).getName());
                CreditCardView creditCardView = (CreditCardView) dialog.findViewById(R.id.card);
                //creditCardView.setImageResource(getItem(position).getImageSource());
                creditCardView.setCVV(data.get(position).getCvv());
                creditCardView.setCardHolderName(data.get(position).getName());
                creditCardView.setCardExpiry(data.get(position).getExpiry());
                creditCardView.setCardNumber(data.get(position).getCardNumber());

                dialog.show();
            }
        };
    }


    private static class ViewHolder {
        private TextView gameName;
        private CreditCardView creditCardView;

        public ViewHolder(View v) {
            creditCardView = (CreditCardView) v.findViewById(R.id.card);
            gameName = (TextView) v.findViewById(R.id.name);
        }
    }
}