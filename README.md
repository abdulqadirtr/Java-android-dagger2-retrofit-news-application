# Java android News Application


**Summary

An application for getting news from api service and show it in recyclerview.


 **Description for the problem.**
 
 1. **Introduction:**
This is a Java android application for getting News from Api data using Retrofit, OkHttp and Dagger2.

 2. **FrameWork and Technologies Used:**
Retrofit
Recyclerview
CardView
OkHttp
Dagger2
Databinding


#### Retrofit,OkHttp, Dagger2, 

```java
@Module
public class ApiModule {
   String mbaseUrl;

    public ApiModule(String mbaseUrl) {
        this.mbaseUrl = mbaseUrl;
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    //interceptor is used for showing logs.

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(mbaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

```



#### RecyclerView, Databinding

```java
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context context;
    List<ArticlesItem> postList = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemsBinding binding= ItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    public PostAdapter(Context context, List<ArticlesItem> items){
        this.context = context;
        postList.clear();
        postList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticlesItem a = postList.get(position);
        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemsBinding binding;

         ViewHolder( ItemsBinding binding ) {
             super(binding.getRoot());
             this.binding = binding;
        }
        public void bind(ArticlesItem a){
            binding.tvTitle.setText(a.getTitle());
            binding.tvDate.setText(a.getSource().getName());
            binding.tvSource.setText(a.getPublishedAt());

            String imgUrl = a.getUrlToImage();
            Picasso.with(context).load(imgUrl).into(binding.image);
        }
    }
}

```
                         
3. **Screenshots**

![Main Screen]
(https://github.com/abdulqadirtr/Java-android-dagger2-retrofit-news-application/blob/master/app/src/main/res/drawable/screen_one.png)


 # Linkedin Profile:
 www.linkedin.com/in/abdul-qadir-009607bb
 
 
                               **********************************************
 
