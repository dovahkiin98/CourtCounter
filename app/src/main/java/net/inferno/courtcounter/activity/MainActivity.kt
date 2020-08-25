package net.inferno.courtcounter.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import net.inferno.courtcounter.R
import net.inferno.courtcounter.databinding.ActivityMainBinding
import net.inferno.courtcounter.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main,
        ).apply {
            viewModel = mainViewModel
            lifecycleOwner = this@MainActivity
        }
    }
}