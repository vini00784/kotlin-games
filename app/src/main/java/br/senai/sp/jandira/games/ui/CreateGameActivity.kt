package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityCreateGameBinding
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.repository.GameRepository
import br.senai.sp.jandira.games.repository.UserRepository
import br.senai.sp.jandira.games.utils.getBitmapFromUri
import br.senai.sp.jandira.games.utils.getByteArrayFromBitmap

class CreateGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateGameBinding
    lateinit var game: Game
    var id = 0
    lateinit var gameRepository: GameRepository
    private var photo: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        id = intent.getIntExtra("userId", 0)

        binding.gamePicture.setOnClickListener{
            getImageGallery()
        }

        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(this, R.color.color_wave)
            )
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.title.toString() == "Save") {
            if (validate()) {
                save()
            } else {
                Toast.makeText(this, "Preencha corretamente os campos!", Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new, menu)

        return true
    }

    private fun save() {
        game = Game()
        game.gameName = binding.editTextGameName.text.toString()
        game.gameDeveloper = binding.editTextGameDeveloper.text.toString()
        game.gameDescription = binding.editTextGameDescription.text.toString()
        game.gameReleaseDate = binding.editTextGameReleaseDate.text.toString()
        game.gameImage = getByteArrayFromBitmap(photo)
        game.userId = id

        if(binding.buttonPlaying.isChecked) {
            game.gameStatus = "Playing"
        }
        if(binding.buttonFinished.isChecked) {
            game.gameStatus = "Finished"
        }

        gameRepository = GameRepository(this)
        val gameId = gameRepository.save(game)

        if(gameId > 0) {
            Toast.makeText(this, "Saved with success!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun validate(): Boolean {
        if(binding.editTextGameName.text.isEmpty()) {
            binding.editTextGameName.error = "Game name is required!"
            return false
        } else if(binding.editTextGameDeveloper.text.isEmpty()) {
            binding.editTextGameDeveloper.error = "Game developer is required!"
            return false
        } else if(binding.editTextGameDescription.text.isEmpty()) {
            binding.editTextGameDescription.error = "Game description is required!"
            return false
        } else if(binding.editTextGameReleaseDate.text.isEmpty()) {
            binding.editTextGameReleaseDate.error = "Game release date is required!"
            return false
        }
        return true
    }

    private fun getImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 100)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            photo = getBitmapFromUri(data?.data, this)
        }
    }


}