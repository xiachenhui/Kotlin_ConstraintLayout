package hope.morning.com.kotlintest.loginMvp.contract

import hope.morning.com.kotlintest.bean.LoginResponse
import hope.morning.com.kotlintest.bean.RegisterResponse

/**
 * 创建时间： 2018/1/15 0015.
 * 创建人： MorningHope
 * 功能描述：
 */

interface LoginContract {
    interface Model {
        fun login(username: String, password: String, onLoginListenter: Presenter.onLoginListener)
        fun register(username: String, password: String, email: String, onRegisterListenter: Presenter.onRegisterListener)
    }

    interface View {
        fun loginSuccess(result: LoginResponse)
        fun loginFailed(message: String?)
        fun registerSuccess(result: RegisterResponse)
        fun registerFailed(message: String?)
    }

    interface Presenter {
        interface onLoginListener {
            fun loginSuccess(result: LoginResponse)
            fun loginFailed(message: String?)
        }

        interface onRegisterListener {
            fun registerSuccess(result: RegisterResponse)
            fun registerFailed(message: String?)
        }

        fun login(username: String, password: String)
        fun register(username: String, password: String, email: String)
    }
}
