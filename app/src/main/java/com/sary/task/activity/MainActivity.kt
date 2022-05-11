package com.sary.task.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sary.task.R
import com.sary.task.core.android.BaseActivity
import com.sary.task.core.extensions.show
import com.sary.task.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController

        setCity(getString(R.string.app_name))
    }


    fun setCity(city: String) {
        binding.chipCity.text = city
    }

    fun showProgress(show: Boolean) {
        binding.pb.show(show)
    }

}