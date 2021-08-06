package com.isidro.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.isidro.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = home_fragment()
        val sobremiFragment = sobreMi_fragment()
        val tareasFragment = tareas_fragment()

        binding.bottomNavigationView.itemIconTintList = null;

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home ->{
                    setCurrrentFragment(homeFragment)
                    true
                }
                R.id.nav_tareas ->{
                    setCurrrentFragment(tareasFragment)
                    true
                }
                R.id.nav_me ->{
                    setCurrrentFragment(sobremiFragment)
                    true
                }
                else -> false
            }
        }

    }

    public fun setCurrrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit()
        }
    }

}