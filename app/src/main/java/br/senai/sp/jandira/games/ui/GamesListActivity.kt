package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.dao.game.GamesDao
import br.senai.sp.jandira.games.databinding.ActivityGamesListBinding

class GamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesListBinding

    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var rvGames = binding.rvGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)
        adapterGames.updateGamesList(GamesDao.getGames(this))

        rvGames.adapter = adapterGames

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_games_list, menu)
        return true
    }
}