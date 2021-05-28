package com.example.module_login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.module_login.repository.LoginRepository

/**
Created by chene on @date 20-12-10 下午10:24
 **/
class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    suspend fun login(username: String, password: String) =
        repository.login(username, password)

    suspend fun check(username: String) =
        repository.check(username)

    suspend fun register(username: String, password: String, telephone: String? = null) =
        repository.register(username, password, telephone)
}