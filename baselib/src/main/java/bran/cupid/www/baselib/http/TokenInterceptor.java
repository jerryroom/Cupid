package bran.cupid.www.baselib.http;

import android.text.TextUtils;

import java.io.IOException;

import bran.cupid.www.baselib.Constant;
import bran.cupid.www.baselib.util.SpUtils;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String token = SpUtils.getString(Constant.TOKEN, "");
//        String language = SpUtils.getString(Constant.LANGUAGE_SELECT, "zh-cn");
        HttpUrl newHttpUrl = request
                .url().newBuilder()
//                .addQueryParameter("language", language)
                .build();
        String url = request.url().url().getPath();

        Request.Builder builder = request.newBuilder()
                .addHeader("x-ac-token-ticket", token)
                .addHeader("Accept", "application/json")
                .addHeader("Accept-Encoding", "identity");

        if (!TextUtils.isEmpty(url) && url.endsWith("commonms/file/authUploadFiles")) {
            builder.addHeader("Content-Type", "application/json");
        }

        return chain.proceed(builder.url(newHttpUrl).build());
    }
}
