package com.gudgie.kotlintest.presenter

import com.gudgie.kotlintest.view.BaseView
import com.gudgie.kotlintest.view.CharacterView

/**
 * Created by luke on 06/06/17.
 */
class CharacterPresenter : BasePresenter<CharacterPresenter.View>() {

    override fun onViewCreated(view: CharacterPresenter.View) {
        super.onViewCreated(view)

        val charsArray = arrayOf(
                CharacterView.ViewModel("", "Peter"),
                CharacterView.ViewModel("", "Stewie"),
                CharacterView.ViewModel("", "Meg")
        )

        getView()?.charactersLoaded(charsArray)

    }

    interface View : BaseView {
        fun charactersLoaded(characters: Array<CharacterView.ViewModel>)
    }

}