package hope.morning.com.kotlintest.bean

/**
 * 创建时间： 2018/1/15 0015.
 * 创建人： MorningHope
 * 功能描述：
 *  登录返回result
 * token	用户登录生成的token
 * uid	用户Id
 */
data class LoginResult(var token:String,val uid:String)