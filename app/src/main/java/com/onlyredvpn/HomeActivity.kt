package com.onlyredvpn

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.getWindowInsetsController
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.onlyredvpn.databinding.ActivityHomeBinding
import org.json.JSONArray
import org.json.JSONException

class HomeActivity<NativeAd> : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private var mAdManagerInterstitialAd: AdManagerInterstitialAd? = null
    private var VERSION = 2
    private val URL = "https://get-data.in/testctrl/get_settings.php?package=app.test.xyz"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
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
        checkVersion()

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

    private fun checkVersion() {
        val requestQueue = Volley.newRequestQueue(this)
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, URL, null,
            { response ->
                parseResponse(response)
            },
            { error ->
                handleErrorResponse(error)
            })

        requestQueue.add(jsonArrayRequest)
    }

    private fun parseResponse(response: JSONArray) {
        try {
            if (response.length() > 0) {
                val jsonObject = response.getJSONObject(0)
                val version = jsonObject.getString("version").toInt()
                val open_url = jsonObject.getString("updurl")
                val actrl = jsonObject.getString("actrl")
                val aimg = jsonObject.getString("aimg")
                val aurl = jsonObject.getString("aurl")

                val bctrl = jsonObject.getString("bctrl")
                val bimg = jsonObject.getString("bimg")
                val burl = jsonObject.getString("burl")

                if (version > VERSION) {
                    showPopupDialog(open_url)
                } else {

                    val sharedPreferences = getSharedPreferences("TinyDB", MODE_PRIVATE)

                    val editor = sharedPreferences.edit()
                    editor.putString("actrl", actrl)
                    editor.putString("aimg", aimg)
                    editor.putString("aurl", aurl)
                    editor.putString("bctrl", bctrl)
                    editor.putString("bimg", bimg)
                    editor.putString("burl", burl)
                    editor.apply()
                    if (bctrl != "0") {
                        showAppOpenAd(bctrl, bimg, burl)
                    }
                    if (actrl != "0") {
                        showBannerAd(actrl, aimg, aurl)
                    }

                }
            }
        } catch (_: JSONException) {

        }
    }

    private fun showBannerAd(actrl: String, aimg: String, aurl: String) {
        binding.nativeads.visibility = View.VISIBLE
        Glide.with(this)
            .load(Uri.parse(aimg))
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
            .fitCenter()
            .into(binding.bannerAd)
        binding.bannerAd.setOnClickListener {

            if (actrl == "1") {
                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(this, Uri.parse(aurl))

            } else if (actrl == "2") {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(aurl))
                startActivity(intent)
            }
        }
    }

    private fun showPopupDialog(open_url: String) {

        AlertDialog.Builder(
            this, R.style.updateDialogTheme
        ).setView(R.layout.update_popup)
            .setCancelable(false).create().apply {
                show()

                findViewById<MaterialCardView>(R.id.okaybtn)?.setOnClickListener {
                    openPlayStore(open_url)
                }

            }
    }

    private fun openPlayStore(open_url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(open_url)
        startActivity(intent)
    }

    private fun handleErrorResponse(error: VolleyError) {
        Log.e("Volley Error", "Error fetching data from server", error)
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


    private fun showAppOpenAd(bctrl: String, bimg: String, burl: String) {
        AlertDialog.Builder(this, R.style.TransparentDialogTheme).setView(R.layout.appopen_ad_popup)
            .setCancelable(false).create().apply {
                show()

                findViewById<MaterialCardView>(R.id.materialCardView)?.setOnClickListener {
                    dismiss()
                }
                Glide.with(findViewById<ImageView>(R.id.ad)!!.context)
                    .load(Uri.parse(bimg))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                    .fitCenter()
                    .into(findViewById<ImageView>(R.id.ad)!!)


                findViewById<MaterialCardView>(R.id.cv_ad)?.setOnClickListener {
                    if (bctrl == "1") {
                        val builder = CustomTabsIntent.Builder()
                        val customTabsIntent = builder.build()
                        customTabsIntent.launchUrl(this@HomeActivity, Uri.parse(burl))

                    } else if (bctrl == "2") {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(burl))
                        startActivity(intent)
                    }
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
    private fun nativeads() {
//        val adLoader = AdLoader.Builder(this, "/6499/example/native")
//            .forNativeAd { nativeAd ->
//                val adView = findViewById<NativeAdView>(R.id.nativeads)
//                populateNativeAdView(nativeAd, adView)
//            }
//            .build()
//
//        adLoader.loadAd(AdManagerAdRequest.Builder().build())
    }

    private fun populateNativeAdView(
        nativeAd: com.google.android.gms.ads.nativead.NativeAd,
        adView: NativeAdView
    ) {
        // Register the NativeAdView with the native ad
        adView.setNativeAd(nativeAd)

    }
}