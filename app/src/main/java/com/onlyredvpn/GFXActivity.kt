package com.onlyredvpn

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.onlyredvpn.databinding.ActivityGfxactivityBinding

class GFXActivity : AppCompatActivity() {
    lateinit var binding: ActivityGfxactivityBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGfxactivityBinding.inflate(layoutInflater)
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

        var g = ""
        var r = ""
        var f = ""
        var turbo = ""

        window.statusBarColor = resources.getColor(R.color.app_color)

        binding.back.setOnClickListener { finish() }
        val graphics = listOf("Smooth", "Balanced", "HD", "HDR", "Ultra")
        val resolution =
            listOf("960x540", "1024x576", "1280(HD)", "1366x768", "1440(HD+)", "1600x900")
        val fps = listOf("30FPS", "60FPS", "90FPS", "120FPS", "150FPS", "180FPS")

        binding.cpi.setOnClickListener {
            binding.cpi.setBackgroundResource(R.drawable.drawable_green)
            binding.rmi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.gpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.tvCpi.setTextColor(Color.WHITE)
            binding.tvRmi.setTextColor(Color.BLACK)
            binding.tvGpi.setTextColor(Color.BLACK)

            turbo = "cpi"
        }

        binding.rmi.setOnClickListener {
            binding.rmi.setBackgroundResource(R.drawable.drawable_green)
            binding.cpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.gpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.tvRmi.setTextColor(Color.WHITE)
            binding.tvCpi.setTextColor(Color.BLACK)
            binding.tvGpi.setTextColor(Color.BLACK)
            turbo = "rmi"
        }

        binding.gpi.setOnClickListener {
            binding.gpi.setBackgroundResource(R.drawable.drawable_green)
            binding.rmi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.cpi.setBackgroundResource(R.drawable.gfx_spinner_bg)
            binding.tvGpi.setTextColor(Color.WHITE)
            binding.tvRmi.setTextColor(Color.BLACK)
            binding.tvCpi.setTextColor(Color.BLACK)
            turbo = "gpi"
        }

        binding.spinner1.setSelection(0) // Select the first item by default

// Define an adapter for the spinner
        val adapter = ArrayAdapter.createFromResource(this,R.array.graphics_array, R.layout.pinner_dropdown_item)
        // Specify the layout to use when the list of choices appearss
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set the adapter to the spinner
        binding.spinner1.adapter = adapter
// Set the selection based on the index of the item in the graphics list
        binding.spinner1.setSelection(0)
        binding.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                g = graphics[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection if needed
            }
        }
        binding.spinner2.setSelection(0) // Select the first item by default


        val adapter1 = ArrayAdapter.createFromResource(this,R.array.resolution_array, R.layout.pinner_dropdown_item)
        // Specify the layout to use when the list of choices appearss
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set the adapter to the spinner
        binding.spinner2.adapter = adapter1


// Set the selection based on the index of the item in the graphics list
        binding.spinner2.setSelection(0)

        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                r = resolution[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection if needed
            }
        }
        binding.spinner3.setSelection(0) // Select the first item by default

// Define an adapter for the spinner

        val adapter3 = ArrayAdapter.createFromResource(this,R.array.fps_array, R.layout.pinner_dropdown_item)
        // Specify the layout to use when the list of choices appearss
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set the adapter to the spinner
        binding.spinner3.adapter = adapter3
// Set the selection based on the index of the item in the graphics list
        binding.spinner3.setSelection(0)
        binding.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                f = fps[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection if needed
            }
        }



        binding.checkbtn.setOnClickListener {

            // Inflate custom layout for AlertDialog
            val customLayout = LayoutInflater.from(this@GFXActivity)
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
                if (g == "Smooth") {
                    val customLayout = LayoutInflater.from(this@GFXActivity)
                        .inflate(R.layout.bad_popup, null)
                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true)

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                } else if (r == "960x540") {
                    val customLayout = LayoutInflater.from(this@GFXActivity)
                        .inflate(R.layout.bad_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true)

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }

                } else if (f == "30FPS") {
                    val customLayout = LayoutInflater.from(this@GFXActivity)
                        .inflate(R.layout.bad_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true)
                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                } else if (turbo == "") {
                    val customLayout = LayoutInflater.from(this@GFXActivity)
                        .inflate(R.layout.good_popup, null)

                    val okaybtn4 = findViewById<LinearLayout>(R.id.okbtn)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true)

                    val popupAlert = builder.create()
                    popupAlert.show()

                    val okaybtn = customLayout.findViewById<LinearLayout>(R.id.okbtn)
                    okaybtn.setOnClickListener {
                        popupAlert.dismiss()
                    }
                } else {
                    val customLayout =
                        LayoutInflater.from(this@GFXActivity).inflate(R.layout.best_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true)
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


}