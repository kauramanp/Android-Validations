package com.aman.validations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.aman.validations.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    private  val TAG = "RegistrationActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rgGender.setOnCheckedChangeListener { radioGroup, id ->
            if(id == R.id.rbOther){
                binding.etOtherName.visibility = View.VISIBLE
            }else{
                binding.etOtherName.visibility = View.INVISIBLE
            }
        }

        binding.etPhoneNumber.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0)<10){
                binding.etPhoneNumber.error = resources.getString(R.string.enter_valid_phone_number)
            }else{
                binding.etPhoneNumber.error = null
            }
        }

        binding.btnSignup.setOnClickListener {
            if(binding.etName.text.toString().isNullOrEmpty()){
                binding.etName.error = resources.getString(R.string.enter_name)
                binding.etName.requestFocus()
            }else if(binding.etEmail.text.toString().isNullOrEmpty()){
                binding.etEmail.error = resources.getString(R.string.enter_your_email)
                binding.etEmail.requestFocus()
            }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()){
                binding.etEmail.error = resources.getString(R.string.enter_your_email)
                binding.etEmail.requestFocus()
            } else if(binding.etPhoneNumber.text.toString().isNullOrEmpty()){
                binding.etPhoneNumber.error = resources.getString(R.string.enter_your_phone_number)
                binding.etPhoneNumber.requestFocus()
            }else if(binding.etPhoneNumber.text.toString().length<10){
                binding.etPhoneNumber.error = resources.getString(R.string.enter_valid_phone_number)
                binding.etPhoneNumber.requestFocus()
            }else if(binding.etPassword.text.toString().isNullOrEmpty()){
                binding.etPassword.error = resources.getString(R.string.enter_password)
                binding.etPassword.requestFocus()
            }else if(binding.etConfirmPassword.text.toString().isNullOrEmpty()){
                binding.etConfirmPassword.error = resources.getString(R.string.enter_confirm_password)
                binding.etConfirmPassword.requestFocus()

            }else if(binding.etPassword.text.toString() != binding.etConfirmPassword.text.toString()){
                binding.etConfirmPassword.error = resources.getString(R.string.passwords_must_be_same)
                binding.etConfirmPassword.requestFocus()

            }else if(binding.rgGender.checkedRadioButtonId == -1){
                Toast.makeText(this, resources.getString(R.string.select_gender), Toast.LENGTH_LONG).show()
            }else if(binding.rbOther.isChecked && binding.etOtherName.text.toString().isNullOrEmpty()){
                binding.etOtherName.error = resources.getString(R.string.enter_other_name)
                binding.etOtherName.requestFocus()
            }else{
                Toast.makeText(this, resources.getString(R.string.registered_successfully), Toast.LENGTH_LONG).show()
            }
        }
    }
}