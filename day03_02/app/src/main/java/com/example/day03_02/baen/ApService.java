package com.example.day03_02.baen;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApService {
    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
   // http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/3
    //http://gitee.com/ccyy2019/server/raw/master/workbook
    String STRING = "http://gitee.com/";
    @GET("ccyy2019/server/raw/master/workbook")
    Observable<Studnet> getjson();

}
