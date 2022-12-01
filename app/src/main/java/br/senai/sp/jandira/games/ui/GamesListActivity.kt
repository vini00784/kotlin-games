package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.databinding.ActivityGamesListBinding
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.UserRepository
import br.senai.sp.jandira.games.utils.getBitmapFromByteArray
import java.time.Year

class GamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesListBinding
    lateinit var userRepository: UserRepository
    var user: User? = null
    var userId = 0;

    lateinit var adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRepository = UserRepository(this)
        createProfile()

        var rvGames = binding.rvGames
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)

        rvGames.adapter = adapterGames

        setGameAdapterData()

        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(this, R.color.color_wave)
            )
        )
    }

    private fun createProfile() {
        userId = intent.getIntExtra("userId", 0)

        user = userRepository.getUserById(userId)

        binding.textViewUsername.text = user?.userName
        binding.textViewEmail.text = user?.userEmail
        binding.gamesTextViewLevel.text = user?.userLevel.toString()
        binding.profilePicture.setImageBitmap(getBitmapFromByteArray(user?.userImage))

        val games = userRepository.getUserGame(userId)[0].games

        var counterFinished = 0;
        var counterPlaying = 0;

        games.forEach { game ->
            if (game.gameStatus[0].equals("F")) {
                counterFinished++
            } else {
                counterPlaying++
            }
        }


        binding.textViewGamesFinished.text = counterFinished.toString()

        binding.textViewGamesPlaying.text = counterPlaying.toString()

        binding.textViewAge.text =
            (Year.now().value - ((user?.birthDate?.substring(user?.birthDate.toString().length - 4))?.toInt()
                ?: Year.now().value)).toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_games_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title.toString() == "Add") {
            val openCreateGameActivity =
                Intent(this, CreateGameActivity::class.java).putExtra("userId", user?.code)
            startActivity(openCreateGameActivity)
        }
        return false
    }

    private fun setGameAdapterData() {
        val gameList = userRepository.getUserGame(userId)[0].games
        adapterGames.updateGamesList(gameList)
    }

    override fun onResume() {
        super.onResume()
        setGameAdapterData()
    }
}