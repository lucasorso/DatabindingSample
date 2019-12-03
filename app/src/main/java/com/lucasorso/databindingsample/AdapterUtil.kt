package com.lucasorso.databindingsample

import android.widget.TextView
import androidx.databinding.BindingAdapter

class TextViewAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("android:text")
        fun intToText(textView: TextView, value: Int) {
            if (value.toString() != textView.text.toString()) {
                textView.text = value.toString()
            }
        }
    }
}