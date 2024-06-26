package com.onlyredvpn

import android.app.AlertDialog
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
import com.onlyredvpn.databinding.ActivityEvoBinding

class EvoActivity : AppCompatActivity() {
    lateinit var  binding: ActivityEvoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityEvoBinding.inflate(layoutInflater)
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
        var sb6 = ""

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
        binding.switch6.setOnCheckedChangeListener { _, isChecked ->
            // Update your variable based on the checked state of the Switch
            sb6 = "true"
        }

        var switchList = listOf(
            binding.switchButton,
            binding.switch2,
            binding.switch3,
            binding.switch4,
            binding.switch5,
            binding.switch6,
            binding.switch7
        ).forEach(::setSwitchTintColor)

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

            Handler().postDelayed({

                alertDialog.dismiss()

                if (!binding.switchButton.isChecked) {
                    val customLayout = LayoutInflater.from(this).inflate(R.layout.bad_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }

                } else if (!binding.switch2.isChecked) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.bad_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }

                } else if (!binding.switch3.isChecked) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.good_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                } else if (!binding.switch4.isChecked) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.good_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                }else if (!binding.switch5.isChecked||!binding.switch6.isChecked) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.nice_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                }else if (!binding.switch7.isChecked) {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.best_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                } else {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.awesome_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
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