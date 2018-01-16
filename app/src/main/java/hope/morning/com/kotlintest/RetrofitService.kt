package hope.morning.com.kotlintest

import hope.morning.com.kotlintest.bean.LoginResponse
import hope.morning.com.kotlintest.bean.RegisterResponse
import hope.morning.com.kotlintest.constant.Constant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 创建时间： 2018/1/15 0015.
 * 创建人： MorningHope
 * 功能描述：
 */
interface RetrofitService {
    @GET("rigister")
    fun userRegister(@Query("username") username:String,
                     @Query("password") password:String,
                     @Query("email") email:String,
                     @Query("key") key:String= Constant.Appkey
    ): Observable<RegisterResponse>


    /**
     * 登录
     * key 用户申请的appkey
     * username 用户名
     * password 用户密码
     */
    @GET("login")
    fun userLogin(
            @Query("username") username: String,
            @Query("password") password: String,
            @Query("key") key: String = Constant.Appkey
    ): Observable<LoginResponse>

}