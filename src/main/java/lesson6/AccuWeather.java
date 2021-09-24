package lesson6;

import okhttp3.*;

import java.io.IOException;
//1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени, пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
//2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий: зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint
// и изучите документацию. Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед (этого достаточно для выполнения д/з).
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
