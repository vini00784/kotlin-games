package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityCreateGameBinding

class CreateGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
        if(item.title.toString() == "Save") {
//            if (validate()) {
//                save()
//            } else {
//                Toast.makeText(this, "Preencha corretamente os campos!", Toast.LENGTH_SHORT).show()
//            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new, menu)

        return true
    }

    private fun save() {
        TODO("Not yet implemented")
    }

    private fun validate(): Boolean {
        return true
    }


}