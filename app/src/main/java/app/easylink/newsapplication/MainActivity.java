package app.easylink.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import app.easylink.newsapplication.adapter.PostAdapter;
import app.easylink.newsapplication.dagger2.MyApplication;
import app.easylink.newsapplication.model.ArticlesItem;
import app.easylink.newsapplication.model.Response;
import app.easylink.newsapplication.network.ApiEndPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter adapter;
    ApiEndPoint apiInterface;
    List<ArticlesItem> articlesItemList = new ArrayList<>();
    String apiKey = "e493eeee716a48dca1336b8a6c60b47b";
    @Inject
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getNetComponent().inject(this);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        fetchDat();
    }

    private void fetchDat() {


        //calliing Retrofit Api
     //   Retrofit retrofit= NewsApi.getClient();

        apiInterface = retrofit.create(ApiEndPoint.class);

        Call<Response> call = apiInterface.getHeadline(getCountry(), apiKey);
        //  Call<DataItem> call = apiInterface.getUser();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
               // Toast.makeText(getApplicationContext(), response.body().getArticles().get(0).getTitle(),Toast.LENGTH_LONG).show();
                List<ArticlesItem> mD = response.body().getArticles();
                Display(mD);
                //Display();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }
    private void Display(List<ArticlesItem> post) {
        PostAdapter adapter = new PostAdapter(this, post);
        recyclerView.setAdapter(adapter);
    }

    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}