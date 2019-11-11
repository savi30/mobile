package com.savi30.reads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.savi30.reads.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.hostFragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.hostFragment).navigateUp()
    }
}
