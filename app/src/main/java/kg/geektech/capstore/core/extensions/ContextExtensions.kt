package kg.geektech.capstore.core.extensions

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import kg.geektech.capstore.R

fun Context.showCustomToast(
    text: String,
    activity: Activity,
    layoutInflater: LayoutInflater
) {
    val layout = layoutInflater.inflate(
        R.layout.custom_toast,
        activity.findViewById(R.id.custom_toast_layout_id)
    )
    layout.findViewById<TextView>(R.id.tv_custom_toast).text = text
    val toast = Toast(this)
    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
    toast.duration = Toast.LENGTH_SHORT
    toast.view = layout
    toast.show()
}