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

package com.appsyncsample.remote

import android.util.Log
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall
import com.amazonaws.mobileconnectors.appsync.ClearCacheOptions
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.appsyncsample.CreateTodoMutation
import com.appsyncsample.GetTodoDetailsListQuery
import com.appsyncsample.GetTodoDetailsQuery
import com.appsyncsample.OnCreateTodoSubscription
import com.appsyncsample.network.AwsClientInstance
import com.appsyncsample.type.CreateTodoInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CoreRepository {

    private var awsClient: AWSAppSyncClient = AwsClientInstance.getInstance()


    /*
    * Get List of TodoDetails
    * */
    fun getTodoDetailsList(
        onResponse: (List<GetTodoDetailsListQuery.Item>?) -> Unit,
        onFailure: (ApolloException) -> Unit
    ) {
        awsClient.query(
            GetTodoDetailsListQuery.builder().build()
        ).responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
            .enqueue(object : GraphQLCall.Callback<GetTodoDetailsListQuery.Data>() {
                override fun onResponse(response: Response<GetTodoDetailsListQuery.Data>) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onResponse(response.data()?.listTodos()?.items()
                            ?.sortedByDescending { it.createdAt() })
                    }
                }

                override fun onFailure(e: ApolloException) {
                    onFailure(e)
                    Log.e("TAG" , "${e.message}")
                }

            })
    }


    /*
    * Get TodoDetails of particular id
    * */
    fun getTodoDetails(
        id: String,
        onResponse: (GetTodoDetailsQuery.GetTodo?) -> Unit,
        onFailure: (ApolloException) -> Unit
    ) {
        awsClient.query(
            GetTodoDetailsQuery.builder().id(id).build()
        ).responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
            .enqueue(object : GraphQLCall.Callback<GetTodoDetailsQuery.Data>() {
                override fun onResponse(response: Response<GetTodoDetailsQuery.Data>) {
                    onResponse(response.data()?.todo)
                }

                override fun onFailure(e: ApolloException) {
                    onFailure(e)
                    Log.e("TAG" , "${e.message}")
                }

            })
    }

    /*
    * Add TodoDetails to list
    * */
    fun addTodo(
        createTodoInput: CreateTodoInput,
        onResponse: (Response<CreateTodoMutation.Data>) -> Unit,
        onFailure: (ApolloException) -> Unit
    ) {
        awsClient.mutate(
            CreateTodoMutation.builder().input(createTodoInput).build()
        ).enqueue(object : GraphQLCall.Callback<CreateTodoMutation.Data>() {

            override fun onResponse(response: Response<CreateTodoMutation.Data>) {
                onResponse(response)
            }

            override fun onFailure(e: ApolloException) {
                onFailure(e)
                Log.e("TAG" , "${e.message}")
            }

        })
    }

    /*
    * Subscribe to TodoDetails
    * */
    fun subscribeTodoDetails(
        onResponse: (OnCreateTodoSubscription.OnCreateTodo?) -> Unit,
        onFailure: (ApolloException) -> Unit,
        onCompleted: () -> Unit
    ) {
        awsClient.subscribe(
            OnCreateTodoSubscription.builder().build()
        ).execute(object : AppSyncSubscriptionCall.Callback<OnCreateTodoSubscription.Data> {
            override fun onResponse(response: Response<OnCreateTodoSubscription.Data>) {
                CoroutineScope(Dispatchers.Main).launch {
                    onResponse(response.data()?.onCreateTodo())
                }
            }

            override fun onFailure(e: ApolloException) {
                onFailure(e)
                Log.e("TAG" , "${e.message}")
            }

            override fun onCompleted() {
                onCompleted()
            }

        })
    }

    /*
    * Clear Cache
    * */
    fun clearCache() {
        awsClient.clearCaches(
            ClearCacheOptions.builder().clearQueries().build()
        )
    }

}