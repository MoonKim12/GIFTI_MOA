package com.example.giftimoa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.giftimoa.databinding.LayoutSignUpBinding
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
    private lateinit var binding: LayoutSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 액션바 활성화
        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.title ="회원가입"

        val signUpButton: Button = binding.signupButton

        signUpButton.setOnClickListener {
            if (validateForm()) {
                val email = binding.IDTextFieldEditText.text.toString()
                val password = binding.PWTextFieldEditText.text.toString()
                val name = binding.usernameEditText.text.toString()
                val phoneNumber = binding.userPhoneNumberEditText.text.toString()
                val username = binding.userNicknameEditText.text.toString()

                val url = "http://10.0.2.2:3000/signup3"
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

    private fun validateForm(): Boolean {
        val email = binding.IDTextFieldEditText.text.toString()
        val password = binding.PWTextFieldEditText.text.toString()
        val confirmPassword = binding.PWReTextFieldEditText.text.toString()
        val name = binding.usernameEditText.text.toString()
        val phoneNumber = binding.userPhoneNumberEditText.text.toString()
        val username = binding.userNicknameEditText.text.toString()

        if (!isValidEmail(email)) {
            binding.IDTextFieldEditText.error = "올바른 이메일을 입력하세요."
            return false
        } else {
            binding.IDTextFieldEditText.error = null
        }

        if (password.length < 8 || !isValidPassword(password)) {
            binding.PWTextFieldEditText.error = "비밀번호는 8자 이상이어야 하며, 영어, 숫자, 특수 문자를 포함해야 합니다."
            return false
        } else {
            binding.PWTextFieldEditText.error = null
        }

        if (password != confirmPassword) {
            binding.PWReTextFieldEditText.error = "비밀번호가 일치하지 않습니다."
            return false
        } else {
            binding.PWReTextFieldEditText.error = null
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            binding.userPhoneNumberEditText.error = "올바른 핸드폰 번호를 입력하세요."
            return false
        } else {
            binding.userPhoneNumberEditText.error = null
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
