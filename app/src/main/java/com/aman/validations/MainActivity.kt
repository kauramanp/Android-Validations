package com.aman.validations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aman.validations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvSignup.setOnClickListener{
            var intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            var name = binding.etName.text.toString()
            var password = binding.etPassword.text.toString()
            if(name.isNullOrEmpty() == true){
                binding.etName.error = resources.getString(R.string.enter_name)
                binding.etName.requestFocus()
            }else if(password.isNullOrEmpty()) {
                binding.etPassword.error = resources.getString(R.string.login_password)
                binding.etPassword.requestFocus()
            }else{
                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
            }
            System.out.println("Login Clicked $name")

        }
    }
}