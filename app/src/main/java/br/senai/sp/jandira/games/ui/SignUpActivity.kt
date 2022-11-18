package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.repository.UserRepository
import br.senai.sp.jandira.games.databinding.ActivitySignUpBinding
import br.senai.sp.jandira.games.model.LevelsEnum
import br.senai.sp.jandira.games.model.User

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var userRepository: UserRepository
    lateinit var user: User
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = User()

        id = intent.getIntExtra("id", 0)

        binding.sliderGameLevel.addOnChangeListener { slider, value, fromUser ->
            binding.textViewLevel.text = getSliderText(binding.sliderGameLevel.value.toInt()).toString()
        }
    }

    private fun getSliderText(position: Int): LevelsEnum {
        if (position <= 1) return LevelsEnum.BEGGINER
        if (position in 2..2) return LevelsEnum.BASIC
        if (position in 3..3) return LevelsEnum.CASUAL
        if (position in 4..4) return LevelsEnum.ADVANCED
        return LevelsEnum.BEGGINER
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
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

    private fun save() {
        user.userEmail = binding.editTextEmail.text.toString()
        user.userPassword = binding.editTextPassword.text.toString()
        user.userName = binding.editTextName.text.toString()
        user.userCity = binding.editTextCity.text.toString()
        // user.userBirthDate = binding.editTextBirthDate.text.toString()

        when(binding.sliderGameLevel.value.toInt()) {
            1 -> {
                user.userLevel = LevelsEnum.BEGGINER
            }
            2 -> {
                user.userLevel = LevelsEnum.BASIC
            }
            3 -> {
                user.userLevel = LevelsEnum.CASUAL
            }
            4 -> {
                user.userLevel = LevelsEnum.ADVANCED
            }
        }

        if(binding.buttonMale.isChecked) {
            user.gender = 'M'
        } else if(binding.buttonFeminine.isChecked) {
            user.gender = 'F'
        }




        userRepository = UserRepository(this)
        val id = userRepository.save(user)
        if (id > 0) {
            Toast.makeText(this, "ID: $id", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun validate(): Boolean {
        if(binding.editTextEmail.text.isEmpty()) {
            binding.editTextEmail.error = "Email is required!"
            return false
        } else if(binding.editTextPassword.text.isEmpty()) {
            binding.editTextPassword.error = "Password is required!"
            return false
        } else if(binding.editTextName.text.isEmpty()) {
            binding.editTextName.error = "Name is required!"
            return false
        } else if(binding.editTextCity.text.isEmpty()) {
            binding.editTextCity.error = "City is required!"
            return false
        } else if(binding.editTextBirthDate.text.isEmpty()) {
            binding.editTextBirthDate.error = "Birth date is required"
            return false
        } else if(binding.editTextPassword.text.isEmpty()) {
            binding.editTextPassword.error = "Password is required"
            return false
        }
        return true
//
    }


}