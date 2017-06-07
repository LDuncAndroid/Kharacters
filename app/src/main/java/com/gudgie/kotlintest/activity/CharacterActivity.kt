package com.gudgie.kotlintest.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.gudgie.kotlintest.R
import com.gudgie.kotlintest.adapter.CharacterAdapter
import com.gudgie.kotlintest.presenter.CharacterPresenter
import com.gudgie.kotlintest.view.CharacterView

class CharacterActivity : AppCompatActivity(), CharacterPresenter.View {

    private val presenter: CharacterPresenter? = CharacterPresenter()
    private var toolbar: Toolbar? = null
    private var recyclerView: RecyclerView? = null
    private val adapter: CharacterAdapter? = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        toolbar = findViewById(R.id.toolbar) as Toolbar
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView

        setupToolbar()
        setupRecyclerView()

        presenter?.onViewCreated(this)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.toolbar_title)
    }

    private fun setupRecyclerView() {
        recyclerView?.adapter = adapter
    }

    override fun charactersLoaded(characters: Array<CharacterView.ViewModel>) {
        adapter?.addCharacters(characters)
    }

}
