package com.onlyredvpn

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.onlyredvpn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Start the zoom-in animation
        zoomInAnimation()
    }
    private fun zoomInAnimation() {
        // Get reference to the CardView
        val cardView = findViewById<androidx.cardview.widget.CardView>(R.id.cv)

        // Create ObjectAnimator for scaleX and scaleY properties of the CardView
        val scaleXAnimator = ObjectAnimator.ofFloat(cardView, "scaleX", 1.0f, 1.5f)
        val scaleYAnimator = ObjectAnimator.ofFloat(cardView, "scaleY", 1.0f, 1.5f)

        // Set interpolator to AccelerateInterpolator
        scaleXAnimator.interpolator = AccelerateInterpolator()
        scaleYAnimator.interpolator = AccelerateInterpolator()

        // Set duration for the animation
        scaleXAnimator.duration = 1500
        scaleYAnimator.duration = 1500

        // Add listener to handle animation events
        scaleXAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {

            }

            override fun onAnimationEnd(p0: Animator) {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(p0: Animator) {

            }

            override fun onAnimationRepeat(p0: Animator) {

            }
        })

        // Start the animations
        scaleXAnimator.start()
        scaleYAnimator.start()
    }
}