package com.test.openweathertest.fivedayforecast

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.domainjava.openweatherjava.networkmodel.ListItem
import com.test.openweathertest.R
import kotlinx.android.synthetic.main.five_day_forecast_item.view.*

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>() {

    val listItems: MutableList<ListItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.five_day_forecast_item, parent, false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (listItems.isEmpty()) 0 else listItems.size
    }

    override fun onBindViewHolder(viewHolder: WeatherViewHolder, position: Int) {
        val listItem = listItems[position]
        viewHolder.setData(listItem)
    }

    fun setData(items: List<ListItem>) {
        listItems.clear()
        listItems.addAll(items)
        notifyDataSetChanged()
    }


    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(listItem: ListItem) {
            val parts = listItem.dtTxt.split(" ")
            itemView.date.text = parts[0]
            itemView.time.text = parts[1]
            itemView.weather.text = itemView.resources.getString(R.string.formatted_weather_item,
                    listItem.weather[0].main, listItem.weather[0].description)
        }

    }
}