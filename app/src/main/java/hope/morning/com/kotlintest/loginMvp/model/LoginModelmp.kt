package hope.morning.com.kotlintest.loginMvp.model

import hope.morning.com.kotlintest.loginMvp.contract.LoginContract
import hope.morning.com.kotlintest.utils.RetrofitUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 创建时间： 2018/1/15 0015.
 * 创建人： MorningHope
 * 功能描述：
 */

class LoginModelmp : LoginContract.Model {
    override fun register(username: String, password: String, email: String, onRegisterListenter: LoginContract.Presenter.onRegisterListener) {
        RetrofitUtils.retrofitService
                .userRegister(username, password, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    when (result.retCode) {
                        "200" -> onRegisterListenter.registerSuccess(result)
                        else -> onRegisterListenter.registerFailed(result.msg)
                    }
                }, { error ->
                    onRegisterListenter.registerFailed(error.message)

                })

    }

    override fun login(username: String, password: String, onLoginListenter: LoginContract.Presenter.onLoginListener) {
        RetrofitUtils.retrofitService
                .userLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    when (result.retCode) {
                        "200" -> onLoginListenter.loginSuccess(result)
                        else -> onLoginListenter.loginFailed(result.msg)
                    }
                }, { error ->
                    onLoginListenter.loginFailed(error.message)
                }
                )
    }

}
