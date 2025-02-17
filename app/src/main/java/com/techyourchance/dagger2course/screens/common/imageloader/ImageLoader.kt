package com.techyourchance.dagger2course.screens.common.imageloader

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.techyourchance.dagger2course.common.dependencyinjection.activity.ActivityScope
import javax.inject.Inject

@ActivityScope
class ImageLoader @Inject constructor(private val activity: AppCompatActivity) {

    private val requestOptions = RequestOptions().centerCrop()

    fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(activity).load(imageUrl).apply(requestOptions).into(imageView)
    }
}