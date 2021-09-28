package com.github.pouyarezaei.basalam_t1.util

import android.content.res.Resources.getSystem
import android.graphics.Typeface
import android.widget.TextView

val Int.toDP: Int get() = (this / getSystem().displayMetrics.density).toInt()

val Int.toPX: Int get() = (this * getSystem().displayMetrics.density).toInt()

fun TextView.setFont(fontPath: String) {
    val typeface = Typeface.createFromAsset(this.context.assets, fontPath);
    this.typeface = typeface
}