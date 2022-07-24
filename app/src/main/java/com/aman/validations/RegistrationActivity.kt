package com.aman.validations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged

class RegistrationActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etPassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var etOtherName: EditText
    lateinit var rgGender: RadioGroup
    lateinit var rbOther: RadioButton
    lateinit var btnSignup: Button
    private  val TAG = "RegistrationActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etOtherName = findViewById(R.id.etOtherName)
        rgGender = findViewById(R.id.rgGender)
        btnSignup = findViewById(R.id.btnSignup)
        rbOther = findViewById(R.id.rbOther)

        rgGender.setOnCheckedChangeListener { radioGroup, id ->
            if(id == R.id.rbOther){
                etOtherName.visibility = View.VISIBLE
            }else{
                etOtherName.visibility = View.INVISIBLE
            }
        }

        etPhoneNumber.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0)<10){
                etPhoneNumber.error = resources.getString(R.string.enter_valid_phone_number)
            }else{
                etPhoneNumber.error = null
            }
        }

        btnSignup.setOnClickListener {
            if(etName.text.toString().isNullOrEmpty()){
                etName.error = resources.getString(R.string.enter_name)
                etName.requestFocus()
            }else if(etEmail.text.toString().isNullOrEmpty()){
                etEmail.error = resources.getString(R.string.enter_your_email)
                etEmail.requestFocus()
            }else if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()){
                etEmail.error = resources.getString(R.string.enter_your_email)
                etEmail.requestFocus()
            } else if(etPhoneNumber.text.toString().isNullOrEmpty()){
                etPhoneNumber.error = resources.getString(R.string.enter_your_phone_number)
                etPhoneNumber.requestFocus()
            }else if(etPhoneNumber.text.toString().length<10){
                etPhoneNumber.error = resources.getString(R.string.enter_valid_phone_number)
                etPhoneNumber.requestFocus()
            }else if(etPassword.text.toString().isNullOrEmpty()){
                etPassword.error = resources.getString(R.string.enter_password)
                etPassword.requestFocus()
            }else if(etConfirmPassword.text.toString().isNullOrEmpty()){
                etConfirmPassword.error = resources.getString(R.string.enter_confirm_password)
                etConfirmPassword.requestFocus()

            }else if(etPassword.text.toString() != etConfirmPassword.text.toString()){
                etConfirmPassword.error = resources.getString(R.string.passwords_must_be_same)
                etConfirmPassword.requestFocus()

            }else if(rgGender.checkedRadioButtonId == -1){
                Toast.makeText(this, resources.getString(R.string.select_gender), Toast.LENGTH_LONG).show()
            }else if(rbOther.isChecked && etOtherName.text.toString().isNullOrEmpty()){
                etOtherName.error = resources.getString(R.string.enter_other_name)
                etOtherName.requestFocus()
            }else{
                Toast.makeText(this, resources.getString(R.string.registered_successfully), Toast.LENGTH_LONG).show()
            }
        }
    }
}