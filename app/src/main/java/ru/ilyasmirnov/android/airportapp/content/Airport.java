package ru.ilyasmirnov.android.airportapp.content;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import static ru.ilyasmirnov.android.airportapp.ui.MainActivity.MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG;

public class Airport {

    @SerializedName("iata")
    private String iata;

    @SerializedName("name")
    private String name;

    @SerializedName("airport_name")
    private String airportName;

    public Airport() {

        Log.i(MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG, "Airport Constructor.");

    }

    public Airport(String iata, String name, String airportName) {
        this.iata = iata;
        this.name = name;
        this.airportName = airportName;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

}
