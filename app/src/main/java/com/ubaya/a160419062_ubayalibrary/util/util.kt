package com.ubaya.a160419062_ubayalibrary.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.a160419062_ubayalibrary.R
import java.lang.Exception

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadImageFromUrl(view: ImageView, url: String, progressBar: ProgressBar) {

    if (url != null) {
        view.loadImage(url,progressBar)
    }
    else
    {
        view.loadImage("",progressBar)
    }
}

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) { }

        })
}