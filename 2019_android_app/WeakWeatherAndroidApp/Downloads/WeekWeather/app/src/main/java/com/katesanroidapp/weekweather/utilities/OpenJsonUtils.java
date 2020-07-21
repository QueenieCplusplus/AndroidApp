package com.katesanroidapp.weekweather.utilities;

import android.content.ContentValues;
import android.content.Context;

import com.katesanroidapp.weekweather.data.KatesPreference;
import com.katesanroidapp.weekweather.data.WeatherContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

public class OpenJsonUtils {

    private static final String OWM_CITY = "city";
    private static final String OWM_COORD = "coord";

    private static final String OWM_LATITUDE = "lat";
    private static final String OWM_LONGITUDE = "lon";

    private static final String OWM_LIST = "list";

    private static final String OWM_PRESSURE = "pressure";
    private static final String OWM_HUMIDITY = "humidity";
    private static final String OWM_WINDSPEED = "speed";
    private static final String OWM_WIND_DIRECTION = "deg";

    private static final String OWM_TEMPERATURE = "temp";

    private static final String OWM_MAX = "max";
    private static final String OWM_MIN = "min";

    private static final String OWM_WEATHER = "weather";
    private static final String OWM_WEATHER_ID = "id";

    private static final String OWM_MESSAGE_CODE = "cod";


    public static ContentValues[] getWeatherContentValuesFromJson(Context context, String forecastJsonStr)
            throws JSONException {

        JSONObject forecastJson = new JSONObject(forecastJsonStr);

        /* Is there an error? */
        if (forecastJson.has(OWM_MESSAGE_CODE)) {
            int errorCode = forecastJson.getInt(OWM_MESSAGE_CODE);

            switch (errorCode) {
                case HttpURLConnection.HTTP_OK:
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    /* Location invalid */
                    return null;
                default:
                    /* Server probably down */
                    return null;
            }


            JSONArray jsonWeatherArray = forecastJson.getJSONArray(OWM_LIST);
            JSONObject cityJson = forecastJson.getJSONObject(OWM_CITY);
            JSONObject cityCoord = cityJson.getJSONObject(OWM_COORD);
            double cityLatitude = cityCoord.getDouble(OWM_LATITUDE);
            double cityLongitude = cityCoord.getDouble(OWM_LONGITUDE);

            KatesPreference.setLocationDetails(context, cityLatitude, cityLongitude);
            ContentValues[] weatherContentValues = new ContentValues[jsonWeatherArray.length()];


            long normalizedUtcStartDay = KatesDateU.getNormalizedUtcDateForToday();
            for (int i = 0; i < jsonWeatherArray.length(); i++) {
                long dateTimeMillis;
                double pressure;
                int humidity;
                double windSpeed;
                double windDirection;
                double high;
                double low;
                int weatherId;
                JSONObject dayForecast = jsonWeatherArray.getJSONObject(i);
                //ignore all the datetime values embedded in the JSON and assume that
                //the values are returned in-order by day (which is not guaranteed to be correct).
                dateTimeMillis = normalizedUtcStartDay + KatesDateU.DAY_IN_MILLIS * i;
                pressure = dayForecast.getDouble(OWM_PRESSURE);
                humidity = dayForecast.getInt(OWM_HUMIDITY);
                windSpeed = dayForecast.getDouble(OWM_WINDSPEED);
                windDirection = dayForecast.getDouble(OWM_WIND_DIRECTION);

                //Description is in a child array called "weather", which is 1 element long.
                JSONObject weatherObject =
                        dayForecast.getJSONArray(OWM_WEATHER).getJSONObject(0);
                weatherId = weatherObject.getInt(OWM_WEATHER_ID);

                //Temperatures are sent by Open Weather Map in a child object called "temp".
                JSONObject temperatureObject = dayForecast.getJSONObject(OWM_TEMPERATURE);
                high = temperatureObject.getDouble(OWM_MAX);
                low = temperatureObject.getDouble(OWM_MIN);

                ContentValues weatherValues = new ContentValues();
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_DATE, dateTimeMillis);
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_HUMIDITY, humidity);
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_PRESSURE, pressure);
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_WIND_SPEED, windSpeed);
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_DEGREES, windDirection);
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_MAX_TEMP, high);
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_MIN_TEMP, low);
                weatherValues.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_ID, weatherId);

                weatherContentValues[i] = weatherValues;
            }
            return weatherContentValues;

        }


    }





}
