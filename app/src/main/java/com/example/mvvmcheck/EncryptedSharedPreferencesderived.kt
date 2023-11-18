package com.example.mvvmcheck

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.MasterKey
import androidx.security.crypto.EncryptedSharedPreferences

class EncryptedSharedPreferencesderived {
    companion object {
        lateinit var mSharedPreferences: SharedPreferences
        /**
         *  implementing secure shared preferences which can't be easily reverse engineered .
         **/
        fun getSharedPreferences(context: Context): EncryptedSharedPreferencesderived.Companion {
            val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
            mSharedPreferences = EncryptedSharedPreferences.create(
                context,
                "vibhavData",
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
            return this

        }

        fun getName(): String {
            return mSharedPreferences.getString("vibhav", "initial value").toString()
        }

        fun setName(name:String): Boolean {
            mSharedPreferences.edit().putString("vibhav", name).apply()
            return true
        }
    }
}