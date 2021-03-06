package ru.alexbykov.sailesstat.remote.dto;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.alexbykov.sailesstat.Const;
import rx.schedulers.Schedulers;

/**
 * Created by Alexey on 14.07.2016.
 */
public class ServiceGenerator {


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .baseUrl(Const.URL.UrlService)
                    .addConverterFactory(JacksonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }


}
