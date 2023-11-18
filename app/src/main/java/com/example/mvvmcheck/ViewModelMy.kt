package com.example.mvvmcheck

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelMy(val catRepository: CatRepository, application: Application) : AndroidViewModel(
    application
) {
    /**
     *  live data list<cat>
     **/
    val catList: MutableLiveData<List<Cat>> = MutableLiveData()
    /**
     *  get all cats from api
     **/
    fun getCats() = viewModelScope.launch {
        val response = catRepository.getAllCats(10);
        if (response.isSuccessful) {
            catList.postValue(response.body())
        }

    }

    /**
     *  save one cat to local database
     **/
    fun saveCat(catDatabase: CatDatabase) = viewModelScope.launch {
        catRepository.upsert(catDatabase)
    }

    /**
     *  get all cats from local database
     **/
    fun getAllCat() = catRepository.getAllCats()


}