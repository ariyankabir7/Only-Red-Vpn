package com.onlyredvpn

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.onlyredvpn.databinding.ActivityYtpreviewBinding

class YTPreviewActivity : AppCompatActivity() {
    lateinit var binding: ActivityYtpreviewBinding
    lateinit var title: String
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityYtpreviewBinding.inflate(layoutInflater)
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

        title = intent.getStringExtra("ytname").toString()
        binding.name.text = title
        if (title == "b2k") {
            binding.p1.progress = 84
            binding.p1value.text = "84x"
            binding.p2.progress = 89
            binding.p2value.text = "89x"
            binding.p3.progress = 92
            binding.p3value.text = "92x"
            binding.p4.progress = 99
            binding.p4value.text = "99x"
            binding.p6.progress = 90
            binding.p6value.text = "90x"
        } else if (title == "amit") {
            binding.p1.progress = 87
            binding.p1value.text = "87x"
            binding.p2.progress = 85
            binding.p2value.text = "85x"
            binding.p3.progress = 100
            binding.p3value.text = "100x"
            binding.p4.progress = 82
            binding.p4value.text = "82x"
            binding.p6.progress = 86
            binding.p6value.text = "86x"
        } else if (title == "tg") {
            binding.p1.progress = 95
            binding.p1value.text = "95x"
            binding.p2.progress = 91
            binding.p2value.text = "91x"
            binding.p3.progress = 88
            binding.p3value.text = "88x"
            binding.p4.progress = 99
            binding.p4value.text = "99x"
            binding.p6.progress = 82
            binding.p6value.text = "82x"
        } else if (title == "b99") {
            binding.p1.progress = 87
            binding.p1value.text = "87x"
            binding.p2.progress = 85
            binding.p2value.text = "85x"
            binding.p3.progress = 89
            binding.p3value.text = "89x"
            binding.p4.progress = 93
            binding.p4value.text = "93x"
            binding.p6.progress = 95
            binding.p6value.text = "95x"
        } else if (title == "vvv") {
            binding.p1.progress = 85
            binding.p1value.text = "85x"
            binding.p2.progress = 81
            binding.p2value.text = "81x"
            binding.p3.progress = 92
            binding.p3value.text = "92x"
            binding.p4.progress = 94
            binding.p4value.text = "94x"
            binding.p6.progress = 94
            binding.p6value.text = "94x"
        }
        binding.okaybtn.setOnClickListener {
            finish()
        }
    }
}