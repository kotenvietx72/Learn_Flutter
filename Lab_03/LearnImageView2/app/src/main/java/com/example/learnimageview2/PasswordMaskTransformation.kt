package com.example.learnimageview2

import android.text.method.PasswordTransformationMethod
import android.view.View

class PasswordMaskTransformation : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
        return PasswordCharSequence(source!!)
    }

    class PasswordCharSequence(private val charSequence: CharSequence) : CharSequence {
        override val length: Int
            get() = charSequence.length

        override fun get(index: Int): Char {
            return '*'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return charSequence.subSequence(startIndex, endIndex)
        }

    }
}