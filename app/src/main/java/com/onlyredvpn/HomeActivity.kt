package com.onlyredvpn

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.getWindowInsetsController
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAdView
import com.google.android.material.button.MaterialButton
import com.onlyredvpn.databinding.ActivityHomeBinding

class HomeActivity<NativeAd> : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private var mAdManagerInterstitialAd: AdManagerInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val insetsController = getWindowInsetsController(v)
            insetsController?.isAppearanceLightStatusBars = false
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.statusBarColor = resources.getColor(R.color.app_color)

//        MobileAds.initialize(this) {}


        binding.menu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.evo.setOnClickListener {
            val intent = Intent(this@HomeActivity, EvoActivity::class.java)
            startActivity(intent)
        }

        binding.flying.setOnClickListener {
            val intent = Intent(this@HomeActivity, FlyingActivity::class.java)
            startActivity(intent)
        }

        binding.gfx.setOnClickListener {
            // Check if the interstitial ad is loaded
            if (mAdManagerInterstitialAd != null) {
                // Show the interstitial ad
                mAdManagerInterstitialAd?.fullScreenContentCallback =
                    object : FullScreenContentCallback() {
                        override fun onAdDismissedFullScreenContent() {
                            // Proceed to start GFXActivity after the ad is dismissed
                            val intent = Intent(this@HomeActivity, GFXActivity::class.java)
                            startActivity(intent)
                        }
                    }
                mAdManagerInterstitialAd?.show(this)
                loadInterstialads()
            } else {

               // Toast.makeText(this, "Try Again !", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@HomeActivity, GFXActivity::class.java)
                startActivity(intent)
            }
        }

        binding.onetap.setOnClickListener {

            val intent = Intent(this@HomeActivity, OneTapActivity::class.java)
            startActivity(intent)
        }

        binding.yt.setOnClickListener {
            val intent = Intent(this@HomeActivity, YTViewActivity::class.java)
            startActivity(intent)
        }
        binding.lagg.setOnClickListener {
            val intent = Intent(this@HomeActivity, LaggActivity::class.java)
            startActivity(intent)
        }
        binding.advance.setOnClickListener {
            val intent = Intent(this@HomeActivity, AdvancedActivity::class.java)
            startActivity(intent)
        }
        binding.gloo.setOnClickListener {
            val intent = Intent(this@HomeActivity, GlooActivity::class.java)
            startActivity(intent)
        }
        // nav button code

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.shared -> {

                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    val appLink = "https://play.google.com/store/apps/details?id=$packageName"
                    val shareMessage =
                        "This is H4X Sensi Tool App :\n$appLink"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                    startActivity(Intent.createChooser(shareIntent, "Share app via"))
                    true
                }

                R.id.rate -> {

                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                        )
                    )
                    true
                }

                R.id.privacy -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com")
                        )
                    )
                    true
                }

                R.id.exit -> {
                    showPpopupDialog()
                    true
                }

                else -> {
                    false
                }
            }
        }
        binding.rateus.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                )
            )
        }
        binding.shareus.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val appLink = "https://play.google.com/store/apps/details?id=$packageName"
            val shareMessage =
                "This is H4X Sensi Tool App :\n$appLink"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "Share app via"))
        }

    }


    private fun showPpopupDialog() {
        AlertDialog.Builder(this, R.style.TransparentDialogTheme).setView(R.layout.back_popup)
            .setCancelable(true).create().apply {
                show()

                findViewById<MaterialButton>(R.id.buttonCancel)?.setOnClickListener {
                    dismiss()
                }
                findViewById<MaterialButton>(R.id.buttonConfirm)?.setOnClickListener {
                    dismiss()
                    super.onBackPressed()
                    finish()
                }
            }

    }


    override fun onBackPressed() {
        showPpopupDialog()
        loadInterstialads()
    }

    private fun loadInterstialads() {
//        var adRequest = AdManagerAdRequest.Builder().build()
//
//        AdManagerInterstitialAd.load(
//            this,
//            "/6499/example/interstitial",
//            adRequest,
//            object : AdManagerInterstitialAdLoadCallback() {
//                override fun onAdFailedToLoad(adError: LoadAdError) {
//                    adError?.toString()?.let { Log.d(ContentValues.TAG, it) }
//                    mAdManagerInterstitialAd = null
//                }
//
//                override fun onAdLoaded(interstitialAd: AdManagerInterstitialAd) {
//                    Log.d(ContentValues.TAG, "Ad was loaded.")
//                    mAdManagerInterstitialAd = interstitialAd
//                }
//            })
    }

    @SuppressLint("ResourceType")
    private fun nativeads(){
//        val adLoader = AdLoader.Builder(this, "/6499/example/native")
//            .forNativeAd { nativeAd ->
//                val adView = findViewById<NativeAdView>(R.id.nativeads)
//                populateNativeAdView(nativeAd, adView)
//            }
//            .build()
//
//        adLoader.loadAd(AdManagerAdRequest.Builder().build())
    }
    private fun populateNativeAdView(nativeAd: com.google.android.gms.ads.nativead.NativeAd, adView: NativeAdView) {
        // Register the NativeAdView with the native ad
        adView.setNativeAd(nativeAd)

    }
}