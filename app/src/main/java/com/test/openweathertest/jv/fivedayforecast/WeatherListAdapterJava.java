package com.test.openweathertest.jv.fivedayforecast;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.domainjava.openweatherjava.networkmodel.ListItem;
import com.test.openweathertest.R;

import java.util.ArrayList;
import java.util.List;

class WeatherListAdapterJava extends RecyclerView.Adapter<WeatherListAdapterJava.WeatherViewHolder> {

    private List<ListItem> listItems = new ArrayList();


    public void setData(List<ListItem> items) {
        listItems.clear();
        listItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.five_day_forecast_item, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        ListItem listItem = listItems.get(i);
        weatherViewHolder.setData(listItem);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }



    class WeatherViewHolder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView time;
        private TextView weather;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            weather = itemView.findViewById(R.id.weather);
        }

        public void setData(ListItem listItem) {
            String[] parts = listItem.getDtTxt().split(" ");
            date.setText(parts[0]);
            time.setText(parts[1]);
            weather.setText(itemView.getResources().getString(R.string.formatted_weather_item,
                    listItem.getWeather().get(0).getMain(), listItem.getWeather().get(0).getDescription()));
        }

    }
}