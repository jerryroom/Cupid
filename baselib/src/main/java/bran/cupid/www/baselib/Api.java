package bran.cupid.www.baselib;

import bran.cupid.www.baselib.module.ModuleSplash;
import bran.cupid.www.baselib.module.req.LoginReq;
import bran.cupid.www.baselib.module.rsp.LoginRsp;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * 作者: bran
 * 日期: 2019/10/26 0026
 * 描述：
 */
public interface Api {

    @GET
    Flowable<ModuleSplash> getSplashImg(@Url String url);


    @POST("")
    Flowable<LoginRsp> login(@Body LoginReq req);
}
