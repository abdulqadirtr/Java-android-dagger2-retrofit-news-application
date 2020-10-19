package app.easylink.newsapplication.network;

import app.easylink.newsapplication.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {

    @GET("top-headlines")
    Call<Response> getHeadline(@Query("country") String country, @Query("apiKey") String apiKey);
}
