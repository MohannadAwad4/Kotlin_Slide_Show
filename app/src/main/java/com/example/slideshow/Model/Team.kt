package com.example.slideshow.Model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Team(
    @StringRes val stringResourceId:Int,
    @DrawableRes val imageResourceId:Int

)
