package com.kerubyte.retropunk.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kerubyte.retropunk.R
import com.kerubyte.retropunk.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(
                this,
                R.layout.activity_main
            )

        val navHostFragment = supportFragmentManager
            .findFragmentById(
                R.id.nav_host_fragment_container
            ) as NavHostFragment

        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)

    }
}