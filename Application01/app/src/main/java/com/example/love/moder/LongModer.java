package com.example.love.moder;

import android.database.Observable;

import com.example.love.bane.ApService;
import com.example.love.bane.Studnet;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by love on 2019/9/10.
 */

public class LongModer {

    public static void addtiti(final Oncreate oncreate) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApService.mString)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApService service = retrofit.create(ApService.class);
        io.reactivex.Observable<Studnet> getjson = service.getjson();
        getjson.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Studnet>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Studnet studnet) {
                        if (studnet.getData().getDatas()!=null){
                            List<Studnet.DataBean.DatasBean> datas = studnet.getData().getDatas();
                            oncreate.addtite(datas);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        oncreate.onFile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface Oncreate{
        void addtite(List<Studnet.DataBean.DatasBean> list);
        void onFile(String str);
    }
}
