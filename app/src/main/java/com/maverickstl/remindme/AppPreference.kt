package com.maverickstl.remindme

import android.content.Context
import android.content.SharedPreferences
import android.graphics.ColorSpace
import com.google.gson.Gson

/**
 * Created by robot on 5/14/18.
 */
class AppPreference( var cont:Context){
    internal var spref: SharedPreferences = cont.getSharedPreferences(cont.packageName, Context.MODE_PRIVATE)

    fun setUsers(value : ArrayList<User>) {
        val editor = spref.edit()
        editor.putString("users", Gson().toJson(value)).apply()
    }

    fun getUsers(): ArrayList<User>? {
        var temp = spref.getString("users", "")
        if (temp != "" && temp != null)
        {
            return ModelConverter.gsonToClass<ArrayList<User>>(temp)
        } else  return ArrayList()
    }

    fun setPassword(value: String) {
        val editor = spref.edit()
        editor.putString("password", value).apply()
    }

    fun getPassword(): String {
        return spref.getString("password", null)
    }
}