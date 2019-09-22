package com.example.day03_02.baen;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModer {

    public void adtate(final OncreatLong OncreatLong) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApService.STRING)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApService service = retrofit.create(ApService.class);
        Observable<Studnet> getjson = service.getjson();
        getjson.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Studnet>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Studnet studnet) {
                        Log.i("TAG", "onNext:Studnet "+studnet.getResults().toString());
                            List<Studnet.ResultsBean> list = studnet.getResults();
                            OncreatLong.addtite(list);



                    }

                    @Override
                    public void onError(Throwable e) {

                        OncreatLong.onfint(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public interface OncreatLong{
        void addtite(List<Studnet.ResultsBean> list);
        void onfint(String str);

    }
}
