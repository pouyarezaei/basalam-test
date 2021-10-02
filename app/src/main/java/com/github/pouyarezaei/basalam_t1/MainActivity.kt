package com.github.pouyarezaei.basalam_t1

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbar: Toolbar
    lateinit var toolbarText: TextView
    lateinit var toolbarBackButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        toolbar = findViewById(R.id.toolbar)
        toolbarBackButton = findViewById(R.id.toolbal_back_button)
        toolbarText = findViewById(R.id.toolbar_title)
        findViewById<ImageButton>(R.id.toolbar_search_button).setOnClickListener(this)
        findViewById<ImageButton>(R.id.toolbar_option_button).setOnClickListener(this)
        setSupportActionBar(toolbar)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.toolbar_search_button -> {
                    Toast.makeText(this, "toolbar_search_button", Toast.LENGTH_LONG).show()
                }
                R.id.toolbar_option_button -> {
                    Toast.makeText(this, "toolbar_option_button", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}