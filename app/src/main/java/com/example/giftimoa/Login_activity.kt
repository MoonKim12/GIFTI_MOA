package com.example.giftimoa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        // XML에서 정의한 위젯들과 연결
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val Login_Sign_up = findViewById<TextView>(R.id.Login_Sign_up)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val login_ID_Find = findViewById<TextView>(R.id.Login_ID_Find)
        val login_PW_Find = findViewById<TextView>(R.id.Login_PW_Find)

        // 로그인 버튼 클릭 시 이벤트 처리
        loginButton.setOnClickListener(View.OnClickListener {
            // 입력된 이메일과 비밀번호 가져오기
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // 서버 URL 설정
            val serverUrl = "http://10.0.2.2:3000/users?email=$email&password=$password"


            // HTTP GET 요청 보내기
            Thread {
                try {
                    val url = URL(serverUrl)
                    val connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"

                    // 서버 응답 코드 확인
                    val responseCode = connection.responseCode

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        // 서버 응답을 읽어올 BufferedReader 생성
                        val reader = BufferedReader(InputStreamReader(connection.inputStream))
                        val response = StringBuilder()
                        var line: String?

                        // 응답 데이터를 읽어서 response에 저장
                        while (reader.readLine().also { line = it } != null) {
                            response.append(line)
                        }

                        // 응답 처리 (로그인 성공 또는 실패에 따라 다른 처리)
                        val jsonResponse = response.toString()
                        try {
                            val jsonObject = JSONObject(jsonResponse)
                            val result = jsonObject.getInt("result")

                            if (result == 0) {
                                // 로그인 성공 시 다음 화면으로 이동
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else if (result == 1) {
                                runOnUiThread {
                                    Toast.makeText(applicationContext, "이메일 또는 비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                runOnUiThread {
                                    Toast.makeText(applicationContext, "서버 오류 또는 알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            runOnUiThread {
                                Toast.makeText(applicationContext, "응답 데이터 파싱 오류", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        // 서버 응답이 실패인 경우
                        runOnUiThread {
                            Toast.makeText(applicationContext, "서버 응답 실패", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    runOnUiThread {
                        Toast.makeText(applicationContext, "오류 발생: " + e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        })

        //회원가입 클릭 이벤트
        Login_Sign_up.setOnClickListener {
            val intent = Intent(this, SignUp_activity::class.java)
            startActivity(intent)

        }
        //아이디 찾기 클릭
        login_ID_Find.setOnClickListener {
            val intent = Intent(this, ID_Find_activity::class.java)
            startActivity(intent)

        }
        //비밀번호 클릭
        login_PW_Find.setOnClickListener {
            val intent = Intent(this, PW_Find_activity::class.java)
            startActivity(intent)

        }
    }
}
