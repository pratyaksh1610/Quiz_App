package com.pratyakshkhurana.quizapp

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import org.w3c.dom.Text

class AdapterViewPager(var context:Context,var item:ArrayList<OnBoardIngItems>): PagerAdapter() {
    override fun getCount(): Int {
        return item.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view:View=LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout,null);
        var image=view.findViewById<ImageView>(R.id.imageView)
        var text = view.findViewById<TextView>(R.id.textView)


        image.setImageResource(item[position].Image)
        text.text=item[position].text
        container.addView(view)
        return view
    }
}