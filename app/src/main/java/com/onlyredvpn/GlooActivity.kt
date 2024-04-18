package com.onlyredvpn

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.onlyredvpn.databinding.ActivityGlooBinding

class GlooActivity : AppCompatActivity() {
    lateinit var binding: ActivityGlooBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityGlooBinding.inflate(layoutInflater)
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
        var g = 0
        var r = 0
        var f = 0

        window.statusBarColor = resources.getColor(R.color.app_color)

        binding.sb1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                g = progress // Store the updated progress value in g
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.sb2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                r = progress // Store the updated progress value in r
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.sb3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                f = progress // Store the updated progress value in f
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        binding.back.setOnClickListener { finish() }
        binding.checkbtn.setOnClickListener {

            // Inflate custom layout for AlertDialog
            val customLayout = LayoutInflater.from(this)
                .inflate(R.layout.custom_alert_layout, null)
            val progressBar: ProgressBar =
                customLayout.findViewById(R.id.progressBar)
            val textView: TextView = customLayout.findViewById(R.id.textView)

            // Create AlertDialog with custom layout
            val builder = AlertDialog.Builder(this)
            builder.setView(customLayout)
            builder.setCancelable(false) // Prevent dismissing AlertDialog by tapping outside or pressing back button

            // Show AlertDialog
            val alertDialog = builder.create()
            alertDialog.show()

            // Simulating some background task delay
            Handler().postDelayed({
                // Dismiss AlertDialog
                alertDialog.dismiss()

                // Show toast indicating successful operation completion
                //Toast.makeText(this, "Settings Apply successfully!", Toast.LENGTH_SHORT).show()
                //finish()
                if (g <=60) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.bad_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                } else if (r <=70) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.good_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                } else if (f <=80) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.nice_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                } else {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.awesome_popup, null)


                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true)
                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                }
            }, 2000) // Delay of 5 seconds
        }
    }

}