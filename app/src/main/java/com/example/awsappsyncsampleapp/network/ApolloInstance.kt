/*
 * Copyright 2023 DigiValet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.awsappsyncsampleapp.network

//import com.apollographql.apollo3.ApolloClient
//import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

//internal object ApolloInstance {
//
//    private const val timeoutTime: Long = 35
//
//    fun getApolloClient(): ApolloClient {
//
//        /*
//        * client with caching
//        * */
//        val apolloClient by lazy {
//
//            val client = OkHttpClient.Builder().readTimeout(timeoutTime, TimeUnit.SECONDS)
//                .addInterceptor(AuthorizationInterceptor()).build()
//
//
//            val apolloClientBuilder = ApolloClient.Builder()
//            apolloClientBuilder.serverUrl("https://2mx3kna6dzhefaf54jc7il3xsm.appsync-api.us-east-1.amazonaws.com/graphql")
//
//            apolloClientBuilder.okHttpClient(client).build()
//        }
//        return apolloClient
//    }
//}