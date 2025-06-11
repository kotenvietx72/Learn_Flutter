package com.example.lesson4_07_startactivityforresult
import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class GetInforObserver(private val registry: ActivityResultRegistry, private val context: Context) : DefaultLifecycleObserver {
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        launcher = registry.register("MY_KEY", owner, ActivityResultContracts.StartActivityForResult()) {
            (context as MainActivity).handleResult(it)
        }
    }

    fun launchActivity() {
        Intent(context, InformationActivity::class.java).apply {
            launcher.launch(this)
        }
    }
}