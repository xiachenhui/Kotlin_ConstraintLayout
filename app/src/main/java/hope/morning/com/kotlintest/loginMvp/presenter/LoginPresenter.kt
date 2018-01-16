package hope.morning.com.kotlintest.loginMvp.presenter

import hope.morning.com.kotlintest.bean.LoginResponse
import hope.morning.com.kotlintest.bean.RegisterResponse
import hope.morning.com.kotlintest.loginMvp.contract.LoginContract
import hope.morning.com.kotlintest.loginMvp.model.LoginModelmp


/**
 * 创建时间： 2018/1/15 0015.
 * 创建人： MorningHope
 * 功能描述：
 */

class LoginPresenter(val mLoginView: LoginContract.View) : LoginContract.Presenter, LoginContract.Presenter.onLoginListener, LoginContract.Presenter.onRegisterListener {
    val mLoginModel: LoginContract.Model

    init {
        mLoginModel = LoginModelmp()
    }

    override fun register(username: String, password: String, email: String) {

        mLoginModel.register(username, password, email, this)
    }

    override fun login(username: String, password: String) {

        mLoginModel.login(username, password, this)
    }


    override fun loginSuccess(result: LoginResponse) {

        mLoginView.loginSuccess(result)
    }

    override fun loginFailed(message: String?) {
        mLoginView.loginFailed(message)
    }

    override fun registerSuccess(result: RegisterResponse) {
        mLoginView.registerSuccess(result)
    }

    override fun registerFailed(message: String?) {
        mLoginView.registerFailed(message)
    }

}
