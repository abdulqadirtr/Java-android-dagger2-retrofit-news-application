package app.easylink.newsapplication.dagger2;

import android.app.Application;

import app.easylink.newsapplication.dagger2.module.ApiModule;
import app.easylink.newsapplication.dagger2.module.AppModule;
import app.easylink.newsapplication.utils.Constants;

public class MyApplication extends Application {
    private  AppComponent mAppcomponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppcomponent = DaggerAppComponent.builder().apiModule(new ApiModule(Constants.url)).appModule(new AppModule(this)).build();
    }

    public AppComponent getNetComponent() {
        return mAppcomponent;
    }
}
