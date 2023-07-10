package com.example.growgh

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.mikhaellopez.circularimageview.CircularImageView

class ViewPagerAdapter(val context: Context) : PagerAdapter() {

    var layoutInflater: LayoutInflater? = null

    //array of photos , heading , description
    val imgarray = arrayOf(
        R.drawable.amico,
        R.drawable.pana,
        R.drawable.bro
    )
    val directionarray = arrayOf(
        R.drawable.img,
        R.drawable.img,
        R.drawable.ready
    )
    val headingarray = arrayOf(
        "About Us",
        "Our Mission",
        "Our Vision"
    )
    val descriptionarray = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
    )

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider, container, false)

        val img = view.findViewById<ImageView>(R.id.image)
        val heading = view.findViewById<TextView>(R.id.heading)
        val description = view.findViewById<TextView>(R.id.description)
        val direction = view.findViewById<CircularImageView>(R.id.direction)
        val cardview = view.findViewById<CardView>(R.id.card)

//        val animationDrawable = cardview.background as AnimationDrawable
//        animationDrawable.setEnterFadeDuration(2000)
//        animationDrawable.setExitFadeDuration(1000)
//        animationDrawable.start()

        img.setImageResource(imgarray[position])
        heading.text = headingarray[position]
        description.text = descriptionarray[position]
        direction.setImageResource(directionarray[position])


        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}