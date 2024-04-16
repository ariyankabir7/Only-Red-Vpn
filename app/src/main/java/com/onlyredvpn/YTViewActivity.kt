package com.onlyredvpn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.onlyredvpn.databinding.ActivityYtviewBinding

class YTViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityYtviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityYtviewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val insetsController = ViewCompat.getWindowInsetsController(v)
            insetsController?.isAppearanceLightStatusBars = false
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.statusBarColor = resources.getColor(R.color.app_color)
        binding.back.setOnClickListener { finish() }

        binding.b2k.setOnClickListener {
            val intent = Intent(this, YTPreviewActivity::class.java)
            intent.putExtra("ytname", "Born 2 Kill");
            startActivity(intent)
        }
        binding.white444.setOnClickListener {
            val intent = Intent(this, YTPreviewActivity::class.java)
            intent.putExtra("ytname", "White 444");
            startActivity(intent)
        }
        binding.vvv.setOnClickListener {
            val intent = Intent(this, YTPreviewActivity::class.java)
            intent.putExtra("ytname", "Raistar");
            startActivity(intent)
        }
        binding.tg.setOnClickListener {
            val intent = Intent(this, YTPreviewActivity::class.java)
            intent.putExtra("ytname", "Total Gaming");
            startActivity(intent)
        }
        binding.b99.setOnClickListener {
            val intent = Intent(this, YTPreviewActivity::class.java)
            intent.putExtra("ytname", "Badge 99");
            startActivity(intent)
        }

    }
}