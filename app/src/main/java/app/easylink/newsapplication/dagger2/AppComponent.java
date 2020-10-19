package app.easylink.newsapplication.dagger2;

import javax.inject.Singleton;

import app.easylink.newsapplication.MainActivity;
import app.easylink.newsapplication.dagger2.module.ApiModule;
import app.easylink.newsapplication.dagger2.module.AppModule;
import dagger.Component;
import dagger.Module;
import retrofit2.http.GET;

@Singleton
@Component (modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
