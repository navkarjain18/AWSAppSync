package com.example.awsappsyncsampleapp.network.dto

internal data class ServerError(
    var status: Boolean?,
    var statusCode: Int?,
    var message: String?,
)

internal data class Error(var errors : ArrayList<ServerError> = arrayListOf())
