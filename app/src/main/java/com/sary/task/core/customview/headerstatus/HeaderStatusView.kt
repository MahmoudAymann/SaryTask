package com.sary.task.core.customview.headerstatus

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.sary.task.databinding.HeaderStatusViewBinding

class HeaderStatusView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var _binding: HeaderStatusViewBinding? =
        HeaderStatusViewBinding.inflate(LayoutInflater.from(context), this, true)
    private val binding get() = _binding!!


    fun setHeader(text: String) {
        binding.tvHeader.text = text
    }

    fun setStatus(type: HeaderStatusType) {
        when (type) {
            is HeaderStatusType.End -> {
                binding.endLinearProgress.progress = 100
            }
            is HeaderStatusType.Start -> {
                binding.endLinearProgress.progress = 0
                binding.starLinearProgress.progress = 100
            }
        }
        binding.tvStatus.text = type.message
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }
}