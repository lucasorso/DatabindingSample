package com.lucasorso.databindingsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.lucasorso.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mBiding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val mViewModel by lazy {
        val factory = ScoreViewModel.Factory(
            arrayOf(
                Team("Team A"),
                Team("Team B")
            )
        )
        ViewModelProviders.of(this, factory).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBiding.lifecycleOwner = this
        mBiding.viewModel = mViewModel
    }
}
