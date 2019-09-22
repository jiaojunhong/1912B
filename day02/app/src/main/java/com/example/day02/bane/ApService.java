package com.example.day02.bane;



import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApService {
    //http://www.wanandroid.com/project/list/1/json?cid=294
    String STRING = "http://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Studnet> getjson();


}
