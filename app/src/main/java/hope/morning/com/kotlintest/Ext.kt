package hope.morning.com.kotlintest

import android.util.Log

/**
 * 创建时间： 2018/1/15 0015.
 * 创建人： MorningHope
 * 功能描述：
 */
fun loge(tag: String, content: String) {
    Log.e(tag, content ?: tag)
}