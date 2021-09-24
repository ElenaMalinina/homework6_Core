package lesson6;

import okhttp3.*;

import java.io.IOException;

public class AccuWeather {
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("accuweather.com")
                .build();

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/288968?apikey=O06ZRrYCpieK1jhrn40ZGtOJYm0auGs9")
                .addHeader("Content-Type", "application/json")
                .get()
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.code());
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
