package com.example.day03_03.bane;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApService {
   // http://api.yunxuekeji.cn/yunxue_app_api/content/getData/30/66597/1/10
    String  STRING = "https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<Studnet> getjson();

    //第二个页面
    //https://api.yunxuekeji.cn/yunxue_app_api/teacher/getTeacherPower/191
    String getString = "https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/teacher/getTeacherPower/")
    Observable<Teacher> gettab(@Query("ID") int id);

}
