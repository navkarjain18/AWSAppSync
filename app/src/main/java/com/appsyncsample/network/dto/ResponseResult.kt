package com.appsyncsample.network.dto

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val exception: String) : ResponseResult<Nothing>()
    object NoInternet : ResponseResult<Nothing>()
    object Loading : ResponseResult<Nothing>()
    data class ForceLogout(val exception: String) : ResponseResult<Nothing>()
}