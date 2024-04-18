package com.onlyredvpn

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.onlyredvpn.databinding.ActivityFlyingBinding

class FlyingActivity : AppCompatActivity() {
    lateinit var binding: ActivityFlyingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFlyingBinding.inflate(layoutInflater)
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
        var sb1 = ""
        var sb2 = ""
        var sb3 = ""
        var sb4 = ""
        var sb5 = ""
        var turbo = ""

        window.statusBarColor = resources.getColor(R.color.app_color)

        binding.switchButton.setOnCheckedChangeListener { _, isChecked ->
            // Update your variable based on the checked state of the Switch
            sb1 = "true"
        }
        binding.switch2.setOnCheckedChangeListener { _, isChecked ->
            // Update your variable based on the checked state of the Switch
            sb2 = "true"
        }
        binding.switch3.setOnCheckedChangeListener { _, isChecked ->
            // Update your variable based on the checked state of the Switch
            sb3 = "true"
        }
        binding.switch4.setOnCheckedChangeListener { _, isChecked ->
            // Update your variable based on the checked state of the Switch
            sb4 = "true"
        }
        binding.switch5.setOnCheckedChangeListener { _, isChecked ->
            // Update your variable based on the checked state of the Switch
            sb5 = "true"
        }

        binding.back.setOnClickListener { finish() }

        binding.cpi.setOnClickListener {
            binding.cpi.setBackgroundResource(R.drawable.drawable_green)
            binding.rmi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.gpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.tvCpi.setTextColor(Color.WHITE)
            binding.tvRmi.setTextColor(Color.BLACK)
            binding.tvGpi.setTextColor(Color.BLACK)

            turbo = "30"
        }

        binding.rmi.setOnClickListener {
            binding.rmi.setBackgroundResource(R.drawable.drawable_green)
            binding.cpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.gpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.tvRmi.setTextColor(Color.WHITE)
            binding.tvCpi.setTextColor(Color.BLACK)
            binding.tvGpi.setTextColor(Color.BLACK)
            turbo = "1"
        }

        binding.gpi.setOnClickListener {
            binding.gpi.setBackgroundResource(R.drawable.drawable_green)
            binding.rmi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.cpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.tvGpi.setTextColor(Color.WHITE)
            binding.tvRmi.setTextColor(Color.BLACK)
            binding.tvCpi.setTextColor(Color.BLACK)
            turbo = "2"
        }
        var switchList = listOf(
            binding.switchButton,
            binding.switch2,
            binding.switch3,
            binding.switch4,
            binding.switch5
        ).forEach(::setSwitchTintColor)





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

                if (!binding.switchButton.isChecked) {
                    val customLayout = LayoutInflater.from(this).inflate(R.layout.bad_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }

                } else if (!binding.switch2.isChecked) {

                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.good_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                } else if (!binding.switch3.isChecked) {

                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.nice_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }

                } else if (!binding.switch4.isChecked) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.nice_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }

                } else if (!binding.switch5.isChecked) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.best_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }

                } else {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.awesome_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                }
            }, 2000) // Delay of 5 seconds
        }
    }

    private fun setSwitchTintColor(switchButton: Switch) {
        switchButton.setOnCheckedChangeListener { buttonView, isChecked ->
            // Change the color when the switch is toggled
            if (isChecked) {
                switchButton.thumbDrawable.setTint(getResources().getColor(R.color.light_green))
            } else {
                switchButton.thumbDrawable.setTint(getResources().getColor(R.color.off_switch))
            }
        }
    }

}