package com.example.giftimoa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.giftimoa.databinding.LayoutSignUpBinding
import com.example.giftimoa.databinding.LayoutSignUpEmailBinding

class SignUpemail_activity : AppCompatActivity() {
    private lateinit var binding: LayoutSignUpEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutSignUpEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바 활성화, 뒤로가기 활성화
        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //인증번호 입력 비활성화
/*
        binding.certificationNum.setClickable(false);
        binding.certificationNum.setFocusable(false);
*/

        NextViewBtn()
    }

    private fun emailDoublechkBtn(){
        binding.emailDoubleCheck.setOnClickListener(){
            
        }
    }
    private fun NextViewBtn() {
        binding.nextViewBtn.setOnClickListener {
            val emailtext:String = binding.emailEditText.text.toString()
            val certificationNum = binding.certificationNum.text.toString() // certificationNum을 문자열로 변환

            if (emailtext.isEmpty() || certificationNum.isEmpty()) { // certificationNum을 비교 대상으로 사용
                Toast.makeText(this, "인증번호를 입력하지 않았습니다......", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, SignUp_activity::class.java)
                intent.putExtra("emailtext", emailtext)
                startActivity(intent)
                finish()
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}