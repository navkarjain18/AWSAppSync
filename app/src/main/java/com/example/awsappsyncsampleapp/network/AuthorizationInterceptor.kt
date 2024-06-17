package com.example.awsappsyncsampleapp.network

//import com.apollographql.apollo3.exception.ApolloHttpException
import com.example.awsappsyncsampleapp.network.dto.Error
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody

//internal class AuthorizationInterceptor : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        val requestBuilder = request.newBuilder()
//
//        /*
//        * Taking response to verify network error and display custom json
//        * error message
//        * */
//        val response: Response = chain.proceed(
//            requestBuilder.addHeader("X-API-Key", "da2-2rkf6yinqneatmmv2ovdduzaki").build()
//        )
//
//        if (response.code == 400) {
//            val error = Gson().fromJson(
//                (response.body as ResponseBody).string(), Error::class.java
//            ).errors[0]
//            throw ApolloHttpException(
//                statusCode = error.statusCode ?: 0,
//                body = null,
//                message = error.message ?: "",
//                headers = mutableListOf()
//            )
//        }
//
//        return response
//    }
//}