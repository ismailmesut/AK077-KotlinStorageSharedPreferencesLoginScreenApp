package com.ismailmesutmujde.kotlinstoragesharedpreferencesloginscreenapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesharedpreferencesloginscreenapp.databinding.ActivityLoginBinding


class LogInActivity : AppCompatActivity() {

    private lateinit var bindingLogin : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        val view = bindingLogin.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)

        val autoLoginUsername = sharedPreferences.getString("userName", "no username")
        val autoLoginPassword = sharedPreferences.getString("password", "no password")

        if (autoLoginUsername == "admin" && autoLoginPassword == "123") {
            val intent = Intent(this@LogInActivity, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }

        bindingLogin.buttonLogIn.setOnClickListener {
            val userName = bindingLogin.editTextUserName.text.toString()
            val password = bindingLogin.editTextPassword.text.toString()

            if (userName == "admin" && password == "123") {

                val editor = sharedPreferences.edit()
                editor.putString("userName", userName)
                editor.putString("password", password)
                editor.commit()

                val intent = Intent(this@LogInActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(applicationContext, "Wrong Login", Toast.LENGTH_SHORT).show()
            }


        }

    }
}