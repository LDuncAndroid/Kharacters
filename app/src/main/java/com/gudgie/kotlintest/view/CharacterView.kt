package com.gudgie.kotlintest.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.gudgie.kotlintest.R

/**
 * Created by luke on 06/06/17.
 */

class CharacterView(context: Context?) : LinearLayout(context) {

    var characterImageView: ImageView? = null
    var characterNameView: TextView? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_character, this)

        characterImageView = view.findViewById(R.id.character_image_view) as ImageView
        characterNameView = view.findViewById(R.id.character_name_view) as TextView
    }

    fun bind(data: ViewModel) {
        characterNameView?.text = data.name
    }

    class ViewModel(var imageUrl: String, var name: String)

}