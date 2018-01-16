package hope.morning.com.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import hope.morning.com.kotlintest.bean.LoginResponse
import hope.morning.com.kotlintest.bean.RegisterResponse
import hope.morning.com.kotlintest.loginMvp.contract.LoginContract
import hope.morning.com.kotlintest.loginMvp.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.morning.com.kotlintest.R

class MainActivity : AppCompatActivity(), View.OnClickListener, LoginContract.View {

    var mLoginPresenter: LoginContract.Presenter? = null
    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_register.setOnClickListener(this)
        button_login.setOnClickListener(this)
        mLoginPresenter = LoginPresenter(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_register ->
                mLoginPresenter?.register(et_username.text.toString(), et_password.text.toString(), et_email.text.toString())
            R.id.button_login ->
                mLoginPresenter?.login(et_username.text.toString(), et_password.text.toString())

        }
    }

    override fun loginSuccess(result: LoginResponse) {
        loge(TAG, "loginSuccess--" + result.result.uid)
    }

    override fun loginFailed(message: String?) {

        loge(TAG, "loginFailed--" + message)
    }

    override fun registerSuccess(result: RegisterResponse) {

        loge(TAG, "registerSuccess--" + result.msg)
    }

    override fun registerFailed(message: String?) {
        loge(TAG, "registerFailed--" + message)
    }
}
