package com.maverickstl.remindme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(){
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    var type = 0
    var appPreference : AppPreference? = null
    var user : User? = null
    var allUser : ArrayList<User>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        appPreference = AppPreference(this)
        allUser = appPreference!!.getUsers()!!
        if (allUser == null) {
            allUser = ArrayList()
        }
        sign_in.setOnClickListener {
            type = 0
            email_login_form.visibility = View.VISIBLE
            select_form.visibility = View.GONE
        }

        sign_up.setOnClickListener {
            type = 1
            email_login_form.visibility = View.VISIBLE
            select_form.visibility = View.GONE
        }
        email_sign_in_button.setOnClickListener {
            if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
                if(type == 0) attemptLogin() else attemptRegister()
            else{
                email.error = "Invalid data"
                password.error = "invalid data"
            }
        }
    }

    private fun attemptRegister() {
        val em = email.text.toString()
        val pas = password.text.toString()
        allUser?.let{
            allUser?.forEach { u ->
                if(u.email!!.equals(em, true)){
                    email.error = "Email Exists"
                    return@let
                }
            }
            val u = User()
            u.email = em
            u.password = pas
            it.add(u)
            appPreference!!.setUsers(it)
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra("session",Gson().toJson(u))
            })
            return@let
        }
    }

    private fun attemptLogin() {
        val em = email.text.toString()
        val pas = password.text.toString()
        if(allUser!!.size > 0){
            allUser?.let{
                allUser?.forEach { u ->
                    if(u.email!!.equals(em, true) && u.password!!.equals(pas, true)){
                        startActivity(Intent(this, MainActivity::class.java).apply {
                            putExtra("session",Gson().toJson(u))
                        })
                        return@let
                    }
                }
                Snackbar.make(cood,"User not found", Snackbar.LENGTH_SHORT).show()
            }
        }else{
            email.error = "User Not Found"
            password.error = "User Not Found"
            Snackbar.make(cood,"User not found", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        if( email_login_form.visibility == View.VISIBLE){
            email_login_form.visibility = View.GONE
            select_form.visibility = View.VISIBLE
        }else{
            super.onBackPressed()
        }
    }
}