package com.maverickstl.remindme

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by robot on 5/14/18.
 */
class ModelConverter{
    companion object {
        val TAG = "ModelConverter"
        //.....................................................Method to convert gson to class
        @JvmName("convert")
        inline fun <reified T> gsonToClass(value: String?):T?{
            return if(value != null && value != ""){
                val type = object : TypeToken<T>() {}.type
                Gson().fromJson(value, type)
            }else{
                null
            }
        }
    }
    inline fun <reified T> gsonToClass(value: String?):T?{
        return if(value != null && value != ""){
            val type = object : TypeToken<T>() {}.type
            Gson().fromJson(value, type)
        }else{
            null
        }
    }
}