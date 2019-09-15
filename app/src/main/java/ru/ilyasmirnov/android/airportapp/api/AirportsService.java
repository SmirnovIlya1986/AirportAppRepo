package ru.ilyasmirnov.android.airportapp.api;

import java.util.List;

 import retrofit.Call;
 import retrofit.http.GET;
 import retrofit.http.Query;

//import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.Query;

import ru.ilyasmirnov.android.airportapp.content.*;

public interface AirportsService {

    @GET("/places/coords_to_places_ru.json")
    Call<List<ru.ilyasmirnov.android.airportapp.content.Airport>> airports(@Query("coords") String gps);

}
