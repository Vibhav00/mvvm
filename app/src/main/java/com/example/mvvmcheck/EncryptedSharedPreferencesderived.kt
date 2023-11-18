package com.example.mvvmcheck

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.MasterKey
import androidx.security.crypto.EncryptedSharedPreferences

class EncryptedSharedPreferencesderived {
    companion object {
        lateinit var mSharedPreferences: SharedPreferences
        fun getSharedPreferences(context: Context): EncryptedSharedPreferencesderived.Companion {
            val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
//         mSharedPreferences=context.getSharedPreferences("vk",Context.MODE_PRIVATE)
            mSharedPreferences = EncryptedSharedPreferences.create(
                context,
                "vibhav",
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
            return this

        }

        fun getName(): String {
            return mSharedPreferences.getString("vibhav", "lskdjf").toString()
        }

        fun setName(name:String): Boolean {
            mSharedPreferences.edit().putString("vibhav", name).apply()
            return true
        }
    }
}