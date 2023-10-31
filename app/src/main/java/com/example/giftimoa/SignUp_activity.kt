package com.example.giftimoa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class SignUp_activity : AppCompatActivity() {
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var confirmPasswordEditText: TextInputEditText
    private lateinit var nameEditText: TextInputEditText
    private lateinit var phoneNumberEditText: TextInputEditText
    private lateinit var nicknameEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_sign_up)

        val toolbar: Toolbar = findViewById(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.title = "회원가입"
        
        val signUpButton: Button = findViewById(R.id.signup_button)
        emailEditText = findViewById(R.id.ID_textField_editText)
        passwordEditText = findViewById(R.id.PW_textField_editText)
        confirmPasswordEditText = findViewById(R.id.PW_Re_textField_editText)
        nameEditText = findViewById(R.id.username_editText)
        phoneNumberEditText = findViewById(R.id.user_phone_number_editText)
        nicknameEditText = findViewById(R.id.user_nickname_editText)

        //이메일 값 전달받기
        val receivedEmail = intent.getStringExtra("emailtext")
        if (receivedEmail != null) {
            emailEditText.setText(receivedEmail)
        }
        setUseableEditText(emailEditText,false)

        signUpButton.setOnClickListener {
            if (validateForm()) {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val name = nameEditText.text.toString()
                val phoneNumber = phoneNumberEditText.text.toString()
                val username = nicknameEditText.text.toString()

                val url = "http://3.35.110.246:3306/signup3"
                val json = JsonObject().apply {
                    addProperty("email", email)
                    addProperty("password", password)
                    addProperty("phone_number", phoneNumber)
                    addProperty("name", name)
                    addProperty("username", username)
                }
                val mediaType = "application/json; charset=utf-8".toMediaType()
                val requestBody = json.toString().toRequestBody(mediaType)
                val request = Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build()

                // Use CoroutineScope for asynchronous network request
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val response: Response = withContext(Dispatchers.IO) {
                            OkHttpClient().newCall(request).execute()
                        }

                        if (response.isSuccessful) {
                            val intent = Intent(this@SignUp_activity, Login_activity::class.java)
                            startActivity(intent)
                            runOnUiThread {
                                Toast.makeText(this@SignUp_activity, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            runOnUiThread {
                                Toast.makeText(this@SignUp_activity, "회원가입 실패", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        runOnUiThread {
                            Toast.makeText(this@SignUp_activity, "오류 발생", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    private fun setUseableEditText(et: EditText, useable: Boolean) {
        et.isClickable = useable
        et.isEnabled = useable
        et.isFocusable = useable
        et.isFocusableInTouchMode = useable
    }

    private fun validateForm(): Boolean {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()
        val name = nameEditText.text.toString()
        val phoneNumber = phoneNumberEditText.text.toString()
        val username = nicknameEditText.text.toString()

        if (!isValidEmail(email)) {
            emailEditText.error = "올바른 이메일을 입력하세요."
            return false
        } else {
            emailEditText.error = null
        }

        if (password.length < 8 || !isValidPassword(password)) {
            passwordEditText.error = "비밀번호는 8자 이상이어야 하며, 영어, 숫자, 특수 문자를 포함해야 합니다."
            return false
        } else {
            passwordEditText.error = null
        }

        if (password != confirmPassword) {
            confirmPasswordEditText.error = "비밀번호가 일치하지 않습니다."
            return false
        } else {
            confirmPasswordEditText.error = null
        }


        if (!isValidPhoneNumber(phoneNumber)) {
            phoneNumberEditText.error = "올바른 핸드폰 번호를 입력하세요."
            return false
        } else {
            phoneNumberEditText.error = null
        }
        if (name.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "빈칸을 입력하세요.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}"
        return email.matches(emailPattern.toRegex())
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#\$%^&+=]).{8,}$"
        return password.matches(passwordPattern.toRegex())
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phoneNumberPattern = "^01[0-9]{8,9}$"
        return phoneNumber.matches(phoneNumberPattern.toRegex())
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
