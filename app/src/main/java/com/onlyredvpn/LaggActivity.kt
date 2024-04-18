package com.onlyredvpn

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.onlyredvpn.databinding.ActivityLaggBinding

class LaggActivity : AppCompatActivity() {
    lateinit var binding: ActivityLaggBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLaggBinding.inflate(layoutInflater)
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


        window.statusBarColor = resources.getColor(R.color.app_color)

        binding.back.setOnClickListener { finish() }
        val graphics = listOf("Normal Phone", "High Price")
        val resolution =
            listOf("2 GB", "4 GB", "6 GB", "8 GB", "16 GB")
        val fps = listOf("Normal", "High", "Pro")

        val adapter = ArrayAdapter.createFromResource(this,R.array.Lgraphics_array, R.layout.pinner_dropdown_item)
        // Specify the layout to use when the list of choices appearss
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set the adapter to the spinner
        binding.spinner1.adapter = adapter
// Set the selection based on the index of the item in the graphics list
        binding.spinner1.setSelection(0)

        binding.spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                g = graphics[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection if needed
            }
        }

        binding.spinner2.setSelection(0) // Select the first item by default


        val adapter1 = ArrayAdapter.createFromResource(this,R.array.Lresolution, R.layout.pinner_dropdown_item)
        // Specify the layout to use when the list of choices appearss
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set the adapter to the spinner
        binding.spinner2.adapter = adapter1
// Set the selection based on the index of the item in the graphics list
        binding.spinner2.setSelection(0)

        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                r = resolution[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection if needed
            }
        }
        binding.spinner3.setSelection(0) // Select the first item by default

// Define an adapter for the spinner
        val adapter3 = ArrayAdapter.createFromResource(this,R.array.Fgraphics_array, R.layout.pinner_dropdown_item)
        // Specify the layout to use when the list of choices appearss
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set the adapter to the spinner
        binding.spinner3.adapter = adapter3
// Set the selection based on the index of the item in the graphics list
        binding.spinner3.setSelection(0)
        binding.spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                f = fps[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no selection if needed
            }
        }

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
                if (g == "Normal Phone") {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.bad_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                } else if (r == "2 GB") {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.good_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                } else if (f == "Normal") {
                    val customLayout = LayoutInflater.from(this)
                        .inflate(R.layout.nice_popup, null)

                    // Create AlertDialog with custom layout
                    val builder = AlertDialog.Builder(this,R.style.TransparentDialogTheme)
                    builder.setView(customLayout)
                    builder.setCancelable(true) // Prevent dismissing AlertDialog by tapping outside or pressing back button

                    val popupDialog = builder.create()
                    popupDialog.show()
                    // Prevent dismissing AlertDialog by tapping outside or pressing back button
                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)

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
                    val okaybtn = customLayout.findViewById<ConstraintLayout>(R.id.okbtn)

                    okaybtn.setOnClickListener {
                        popupDialog.dismiss()
                    }
                }
            }, 2000) // Delay of 5 seconds
        }
    }

}