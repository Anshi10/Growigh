package com.example.growgh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.google.android.material.slider.Slider
import com.mikhaellopez.circularimageview.CircularImageView

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialising shared preference
        sharedPreferences = getSharedPreferences("MyPreferences" , Context.MODE_PRIVATE)

        //check if viewPager is shown
        val viewPagerShown = sharedPreferences.getBoolean("shown",false)


        if(!viewPagerShown){
            //show viewPager
            viewPager = findViewById(R.id.viewpager)
            viewPagerAdapter = ViewPagerAdapter(this)
            viewPager.adapter = viewPagerAdapter

            //save the flag indicating view Pager has already shown
            val editor = sharedPreferences.edit()
            editor.putBoolean("shown",true)
            editor.commit()
        }else{
            ToHomePage()
        }

        val skipBtn = findViewById<Button>(R.id.skipbtn)

        skipBtn.setOnClickListener {
            ToHomePage()

            Log.i("anshi","skip")
        }



        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
            val childView = viewPager.getChildAt(position)
                val ready = childView.findViewById<CircularImageView>(R.id.direction)
                ready.setOnClickListener {
                    ToHomePage()

                    Log.i("anshi", "ready")
                }


                Log.i("anshi","onPageSelected Implemented $position")
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    private fun ToHomePage() {
        val intent = Intent(this@MainActivity, HomePage::class.java)
        startActivity(intent)
        finish()
    }
}
