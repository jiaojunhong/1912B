package com.example.day03_03.modler;

import com.example.day03_03.bane.ApService;
import com.example.day03_03.bane.Studnet;
import com.example.day03_03.bane.Teacher;
import com.example.day03_03.padgert.Mypagert2;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModler2 {


    public void addtate(final Oncreatk2 Oncreatk2) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApService.STRING)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApService apService = retrofit.create(ApService.class);
        Observable<Studnet> observable = apService.getjson();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Studnet>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Studnet studnet) {
                        if (studnet.getBody().getResult()!=null){
                            List<Studnet.BodyBean.ResultBean> result = studnet.getBody().getResult();
                            Oncreatk2.addtext(result);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Oncreatk2.onFion(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public interface Oncreatk2{
        void  addtext(List<Studnet.BodyBean.ResultBean> list);
        void onFion(String str);

    }
}
