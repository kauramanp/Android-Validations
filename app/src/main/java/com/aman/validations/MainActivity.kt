package com.aman.validations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var tvSignup: TextView
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignup = findViewById(R.id.tvSignup)

        tvSignup.setOnClickListener{
            var intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            System.out.println("Login Clicked")
            var name = etName.text.toString()
            var password = etPassword.text.toString()
            if(name.isNullOrEmpty() == true){
                etName.error = resources.getString(R.string.enter_name)
                etName.requestFocus()
            }else if(password.isNullOrEmpty()) {
                etPassword.error = resources.getString(R.string.login_password)
            }else{
                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
            }
            System.out.println("Login Clicked $name")

        }
    }
}