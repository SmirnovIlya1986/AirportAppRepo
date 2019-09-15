package ru.ilyasmirnov.android.airportapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit.Call;
//import retrofit2.Call;

import retrofit.Callback;
//import retrofit2.Callback;

import retrofit.Response;
//import retrofit2.Response;

import ru.ilyasmirnov.android.airportapp.R;
import ru.ilyasmirnov.android.airportapp.api.AirportsService;
import ru.ilyasmirnov.android.airportapp.api.ApiFactory;

import ru.ilyasmirnov.android.airportapp.content.*;
// import ru.ilyasmirnov.android.airportapp.content.Airport;

public class MainActivity extends AppCompatActivity implements Callback
        <List<Airport>> {

    public static String MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG = "main_activity_airports_response_body";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AirportsService service = ApiFactory.getAirportsService();

        // Call<List<Airport>> call = service.airports("55.749792,37.6324949");
        Call<List<Airport>> call = service.airports("55.749792,37.6324949");

        // Пулково :
        // Широта: 59.9745800°
        // Долгота: 29.1943800°
        // Call<List<Airport>> call = service.airports("59.9745800,29.1943800");

        Log.i(MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG, "MainActivity.onCreate() : " +
                "\nAirportsService service = " + service.hashCode() +
                "\nCall<List<Airport>> call = " + call.hashCode());


        call.enqueue(this);
    }

    @Override
    public void onResponse(Response<List<Airport>> response) {

        if (response.isSuccess()) {

            List<Airport> airports = response.body();

            // do something here

            Log.i(MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG, "MainActivity.onResponse() : " +
                    "\nresponse.isSuccess()");

        }

//        Log.i(MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG, "MainActivity.onResponse() : " +
//                "\n!response.isSuccess()" +
//                "\nresponse = " + response.hashCode() );

    }

    @Override
    public void onFailure(Throwable t) {

    }

    protected void onCreate2(Bundle savedInstanceState) {

        AirportsService service = ApiFactory.getAirportsService();

        Call<List<Airport>> call = service.airports("55.749792,37.6324949");

        call.enqueue(this);
    }


    public void onResponse2(Response<List<Airport>> response) {

        if (response.isSuccess()) {

            List<Airport> airports = response.body();

        }
    }
}
