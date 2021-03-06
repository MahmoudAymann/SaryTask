package com.sary.task.core.customview.banner

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sary.task.core.extensions.getAppDrawableFromColor
import com.sary.task.core.extensions.viewBinding
import com.sary.task.databinding.BannerViewBinding
import com.sary.task.helper.TimerUtil
import java.util.*


class BannerView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    companion object {
        private const val DELAY: Long = 2000 //delay in milliseconds before auto sliding starts.
        private const val PERIOD: Long = 4000 //time in milliseconds between sliding.
    }

    private var _binding: BannerViewBinding? = viewBinding(BannerViewBinding::inflate)
    private val binding: BannerViewBinding get() = _binding!!

    private var timer: Timer? = null
    private var adapter: BannerAdapter? = null
    private var currentPage = 0


    fun setupBanner(pagerAdapter: BannerAdapter) {
        binding.viewPager.adapter = pagerAdapter
        this.adapter = pagerAdapter
        binding.tabLayout.background = getAppDrawableFromColor(android.R.color.transparent)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()
        setAutoSliding()
    }

    fun setList(list: List<BannerItem>) {
        adapter?.submitList(list)
    }

    private fun setAutoSliding() {
        timer = TimerUtil.setTimerWithPeriodAndDelay({
            if (currentPage == adapter?.itemCount) {
                currentPage = 0
            }
            binding.viewPager.setCurrentItem(currentPage++, true)
        }, delayInMillis = DELAY, periodInMillis = PERIOD)

    }


    fun addOnTabSelectedListener(listener: TabLayout.OnTabSelectedListener) {
        binding.tabLayout.addOnTabSelectedListener(listener)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
        if (timer != null) {
            timer?.cancel()
            timer = null
        }
    }
}