package com.github.daviduas.api

import com.github.daviduas.data.model.DetailUserRespons
import com.github.daviduas.data.model.User
import com.github.daviduas.data.model.UserRespons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token d44cee59f205a95297e3eaa6127283a1d0e15fbc")
    fun getSerchUser(
        @Query("q") query: String
    ): Call<UserRespons>

    @GET("users/{username}")
    @Headers("Authorization: token d44cee59f205a95297e3eaa6127283a1d0e15fbc")
    fun getUserDetai(
        @Path("username") username: String
    ): Call<DetailUserRespons>

    @GET("users/{username}/followers")
    @Headers("Authorization: token d44cee59f205a95297e3eaa6127283a1d0e15fbc")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token d44cee59f205a95297e3eaa6127283a1d0e15fbc")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}