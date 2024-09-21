package com.ismailmesutmujde.kotlinstoragesharedpreferencesloginscreenapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesharedpreferencesloginscreenapp.databinding.ActivityFeedBinding


class FeedActivity : AppCompatActivity() {

    private lateinit var bindingFeed : ActivityFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingFeed = ActivityFeedBinding.inflate(layoutInflater)
        val view = bindingFeed.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("userName", "no username")
        val password = sharedPreferences.getString("password", "no password")

        bindingFeed.textViewResult.text = "User Name : $username - Password : $password"

        bindingFeed.buttonLogOut.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.remove("usrtName")
            editor.remove("password")
            editor.commit()

            val intent = Intent(this@FeedActivity, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}