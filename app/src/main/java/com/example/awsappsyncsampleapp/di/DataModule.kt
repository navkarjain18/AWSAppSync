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

package com.example.awsappsyncsampleapp.di

import android.content.Context
import android.util.Log
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.amazonaws.mobileconnectors.appsync.PersistentMutationsCallback
import com.amazonaws.mobileconnectors.appsync.PersistentMutationsError
import com.amazonaws.mobileconnectors.appsync.PersistentMutationsResponse
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicAPIKeyAuthProvider
import com.example.awsappsyncsampleapp.remote.CoreRepository
import com.example.awsappsyncsampleapp.utils.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideAwsClientInstance(@ActivityContext context: Context): AWSAppSyncClient {
        return AWSAppSyncClient.builder().context(context)
            .apiKey(BasicAPIKeyAuthProvider(AppConstant.APPSYNC_API_KEY)) // For use with IAM/Cognito authorization
            .region(AppConstant.APPSYNC_REGION).serverUrl(AppConstant.APPSYNC_API_URL)
            .persistentMutationsCallback(object : PersistentMutationsCallback {
                override fun onResponse(response: PersistentMutationsResponse) {
                    Log.d("NOTERROR", response.mutationClassName)
                }

                override fun onFailure(error: PersistentMutationsError) {
                    Log.e("TAG", error.mutationClassName)
                    Log.e("TAG", "Error", error.exception)
                }
            }).build()
    }

    @Provides
    @Singleton
    fun provideCoreRepo(): CoreRepository = CoreRepository()

}