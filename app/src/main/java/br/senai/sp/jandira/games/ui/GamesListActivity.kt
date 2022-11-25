package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.databinding.ActivityGamesListBinding
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.UserRepository

class GamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesListBinding
    lateinit var userRepository: UserRepository
    var user: User? = null

    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createProfile()

        var rvGames = binding.rvGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)
//        adapterGames.updateGamesList(GamesDao.getGames(this))

        rvGames.adapter = adapterGames

    }

    private fun createProfile() {
        val userId = intent.getIntExtra("userId", 0)

        userRepository = UserRepository(this)
        user = userRepository.getUserById(userId)

        binding.textViewUsername.text = user?.userName
        binding.textViewEmail.text = user?.userEmail
        binding.gamesTextViewLevel.text = user?.userLevel.toString()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_games_list, menu)
        return true
    }
}