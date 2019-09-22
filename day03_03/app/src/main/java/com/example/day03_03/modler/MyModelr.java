package com.example.day03_03.modler;

import com.example.day03_03.bane.ApService;
import com.example.day03_03.bane.Studnet;
import com.example.day03_03.padgert.Mypaetet;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelr {

    public static void addtext(final Oncreatk Oncreatk) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApService.STRING)
                .build();
        ApService apService = retrofit.create(ApService.class);
        Observable<Studnet> getjson = apService.getjson();
        getjson.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Studnet>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Studnet studnet) {
                     if (studnet.getBody().getResult()!=null){
                         List<Studnet.BodyBean.ResultBean> result = studnet.getBody().getResult();
                         Oncreatk.addtext(result);
                     }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Oncreatk.onFion(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public interface Oncreatk{
        void  addtext(List<Studnet.BodyBean.ResultBean> list);
        void onFion(String str);

    }
}
