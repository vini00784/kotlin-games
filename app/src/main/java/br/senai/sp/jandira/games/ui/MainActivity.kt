package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.UserRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var userRepository: UserRepository
    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        userRepository = UserRepository(this)

        binding.textViewCreateAccount.setOnClickListener {
            val openSignUpActivity = Intent(this, SignUpActivity::class.java)
            startActivity(openSignUpActivity)
        }

        binding.buttonLogin.setOnClickListener {
            if(login()) {
                val openGamesListActivity = Intent(this, GamesListActivity::class.java)
                startActivity(openGamesListActivity)
            } else {
                Toast.makeText(this, "Authentication is failed!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun login(): Boolean {
        if(validate()) {
            val emailText = binding.loginEmail.text.toString()
            user = userRepository.getUserByEmail(emailText)

            if(user == null) {
                Toast.makeText(this, "Email is not found in DataBase!", Toast.LENGTH_SHORT).show()
                return false
            } else if(binding.loginPassword.text.toString() != user?.userPassword) {
                Toast.makeText(this, "Your Password is wrong!", Toast.LENGTH_SHORT).show()
                return false
            }

            return true
        }
        return false
    }

    private fun validate(): Boolean {
        if(binding.loginEmail.text.isEmpty()) {
            binding.loginEmail.error = "Email is required!"
            return false
        } else if(binding.loginPassword.text.isEmpty()) {
            binding.loginPassword.error = "Password is required!"
            return false
        }
        return true
    }
}