package com.example.onboardingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {

    var adapter:OnBoardingAdapter? = null
    var list:ArrayList<OnBoardingIemModel>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list!!.add(OnBoardingIemModel(
            R.drawable.one,
            "Order Your Food",
            "Now you can order food any time right from your mobile"
        ))

        list!!.add(OnBoardingIemModel(
            R.drawable.two,
            "Cooking Safe Food",
            "We are maintain safty and we keep clean while making food"
        ))

        list!!.add(OnBoardingIemModel(
            R.drawable.three,
            "Quick Delivery",
            "Order your favorite meals will be immediately deliver"
        ))

        adapter = OnBoardingAdapter(list!!)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapter
        val wormIndicator = findViewById<WormDotsIndicator>(R.id.indicator)
        wormIndicator.setViewPager2(viewPager)
        val btnNext = findViewById<Button>(R.id.btn_next)
        val btnSkip = findViewById<TextView>(R.id.tv_skip)
        btnNext.setOnClickListener {
            if (viewPager.currentItem+1 < adapter!!.itemCount){
                viewPager.currentItem +=1
            }else{
                val intent = Intent(this@MainActivity,HomeActivity::class.java)
                startActivity(intent)
            }
        }

        btnSkip.setOnClickListener {
            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
        }


    }
}