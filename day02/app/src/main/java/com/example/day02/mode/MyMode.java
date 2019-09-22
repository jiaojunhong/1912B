package com.example.day02.mode;

import com.example.day02.bane.ApService;
import com.example.day02.bane.Studnet;
import com.example.day02.perviet.MyPafert;
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

public class MyMode {

    public void addlist(final Oncreatek oncreatek) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApService.STRING)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
                        if (studnet.getData().getDatas()!=null){
                            List<Studnet.DataBean.DatasBean> datas = studnet.getData().getDatas();
                            oncreatek.addtteit((ArrayList<Studnet.DataBean.DatasBean>) datas);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    public interface  Oncreatek{
        void addtteit(ArrayList<Studnet.DataBean.DatasBean> list);
        void  onfion(String str);

    }

}
