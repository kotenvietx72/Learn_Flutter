package com.example.lesson4_05

import android.content.Context
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class MyLifecycleObserver (private val context: Context) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        if(context is MainActivity)
            context.setContentView(R.layout.activity_main)
        Log.d(TAG, Lifecycle.Event.ON_CREATE.name)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(TAG, Lifecycle.Event.ON_START.name)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(TAG, Lifecycle.Event.ON_RESUME.name)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(TAG, Lifecycle.Event.ON_PAUSE.name)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(TAG, Lifecycle.Event.ON_STOP.name)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(TAG, Lifecycle.Event.ON_DESTROY.name)
    }

    companion object {
        const val TAG = "MyLifecycleObserver"
    }
}