package com.gudgie.kotlintest.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gudgie.kotlintest.view.CharacterView

/**
 * Created by luke on 06/06/17.
 */

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.FamilyGuyViewHolder>() {

    val characters: ArrayList<CharacterView.ViewModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FamilyGuyViewHolder {
        return FamilyGuyViewHolder(CharacterView(parent?.context))
    }

    override fun onBindViewHolder(holder: FamilyGuyViewHolder?, position: Int) {
        holder?.bind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun addCharacters(characters: Array<CharacterView.ViewModel>) {
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    class FamilyGuyViewHolder(private val characterView: CharacterView) : RecyclerView.ViewHolder(characterView) {

        fun bind(character: CharacterView.ViewModel) {
            characterView.bind(character)
        }

    }

}