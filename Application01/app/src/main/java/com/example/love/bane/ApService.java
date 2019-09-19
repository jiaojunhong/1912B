package com.example.love.bane;



import org.greenrobot.greendao.annotation.Entity;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by love on 2019/9/10.
 */
@Entity
public interface ApService {
   // http://www.wanandroid.com/project/list/1/json?cid=294
    String mString = "http://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Studnet> getjson();


    String fileUrl = "http://cdn.banmi.com/ ";//文件的网络路径

    @GET("banmiapp/apk/banmi_330.apk")
    Call<ResponseBody> downloadFile();
}
