package com.github.daviduas.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.daviduas.api.RetrofitClien
import com.github.daviduas.data.model.DetailUserRespons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel : ViewModel() {
    val user = MutableLiveData<DetailUserRespons>()

    fun setUserDetail(username: String) {
        RetrofitClien.apiInstances
            .getUserDetai(username)
            .enqueue(object : Callback<DetailUserRespons> {
                override fun onResponse(
                    call: Call<DetailUserRespons>,
                    response: Response<DetailUserRespons>
                ) {
                    if (response.isSuccessful) {
                        user.postValue((response.body()))
                    }
                }

                override fun onFailure(call: Call<DetailUserRespons>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                }

            })
    }

    fun getUserDetail(): LiveData<DetailUserRespons> {
        return user
    }
}