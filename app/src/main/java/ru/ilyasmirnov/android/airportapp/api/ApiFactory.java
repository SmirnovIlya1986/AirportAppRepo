package ru.ilyasmirnov.android.airportapp.api;

import android.util.Log;

import androidx.annotation.NonNull;

import com.squareup.okhttp.OkHttpClient;
//import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;

import retrofit.Retrofit;
//import retrofit2.Retrofit;

import ru.ilyasmirnov.android.airportapp.BuildConfig;

import static ru.ilyasmirnov.android.airportapp.ui.MainActivity.MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG;

public class ApiFactory {

    private static final int TIMEOUT = 60;
    private static final int WRITE_TIMEOUT = 120;
    private static final int CONNECT_TIMEOUT = 10;

    private static final OkHttpClient CLIENT = new OkHttpClient();

    static {
        CLIENT.setConnectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setWriteTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);
    }

    @NonNull
    public static AirportsService getAirportsService() {

        Log.i(MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG, "ApiFactory.getAirportsService()");

        return buildRetrofit().create(AirportsService.class);
    }

    @NonNull
    private static Retrofit buildRetrofit() {

        Log.i(MAIN_ACTIVITY_AIRPORTS_RESPONSE_BODY_TAG, "ApiFactory.buildRetrofit() : " +
                "\nCLIENT = " + CLIENT.hashCode());

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(CLIENT)
                .build();
    }
}
