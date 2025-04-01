package com.example.slideshow.Data

import com.example.slideshow.Model.Team
import com.example.slideshow.R

class DataSource {
    fun loadData():List<Team>{
        return listOf<Team>(
            Team(R.string.caption_1,R.drawable.img_1),
            Team(R.string.caption_2,R.drawable.img_2),
            Team(R.string.caption_3,R.drawable.img_3),
            Team(R.string.caption_4,R.drawable.img_4),
            Team(R.string.caption_5,R.drawable.image1),
            Team(R.string.caption_6,R.drawable.image2),
            Team(R.string.caption_7,R.drawable.image3),
            Team(R.string.caption_8,R.drawable.image4),
            Team(R.string.caption_9,R.drawable.image5),
            Team(R.string.caption_10,R.drawable.image6),
            Team(R.string.caption_11,R.drawable.image7),
        )
    }
}