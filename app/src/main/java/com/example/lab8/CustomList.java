package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    public Boolean hasCity(City city){
        String cityName = city.getCityName();
        String provinceName = city.getProvinceName();
        for (int i = 0; i < cities.size(); i++) {
            if (cityName != cities.get(i).getCityName() || provinceName != cities.get(i).getProvinceName()) return false;
        }
        return true;
    }

    public List getCities() {
        List list = cities;
        Collections.sort(list);
        return list;
    }

    public void delete(City city) {
        String cityName = city.getCityName();
        String provinceName = city.getProvinceName();
        for (int i = 0; i < cities.size(); i++) {
            if (cityName != cities.get(i).getCityName() || provinceName != cities.get(i).getProvinceName()) throw new IllegalArgumentException();
            if (cityName == cities.get(i).getCityName() && provinceName == cities.get(i).getProvinceName()) {
                this.cities.remove(i);
                return;
            }
        }
    }

    public int countCities() {
        return this.cities.size();
    }

}
