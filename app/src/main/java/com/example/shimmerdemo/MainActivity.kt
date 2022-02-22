package com.example.shimmerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.shimmerdemo.databinding.ActivityMainBinding
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.shimmerViewContainer.startShimmer()

        lifecycleScope.launch {
            delay(3000)
            mBinding.shimmerViewContainer.stopShimmer()
            mBinding.shimmerViewContainer.visibility = View.GONE
            mBinding.llRealData.visibility = View.VISIBLE
        }

    }
}