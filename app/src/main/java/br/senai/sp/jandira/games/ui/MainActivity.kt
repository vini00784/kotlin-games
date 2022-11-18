package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textViewCreateAccount.setOnClickListener {
            val openSignUpActivity = Intent(this, SignUpActivity::class.java)
            startActivity(openSignUpActivity)
        }

        binding.buttonLogin.setOnClickListener {
            login()
            val openGamesActivity = Intent(this, GamesListActivity::class.java)
            startActivity(openGamesActivity)
        }


    }

    private fun login() {
        if(validate()) {

        }
    }

    private fun validate(): Boolean {
        if(binding.loginEmail.text.isEmpty()) {
            binding.loginEmail.error = "Email is required!"
            return false
        } else if(binding.loginPassword.text.isEmpty()) {
            binding.loginEmail.error = "Email is required!"
            return false
        }
        return true
    }
}