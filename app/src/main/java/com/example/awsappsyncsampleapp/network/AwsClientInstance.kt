package com.example.awsappsyncsampleapp.network

import android.util.Log
import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.amazonaws.mobileconnectors.appsync.PersistentMutationsCallback
import com.amazonaws.mobileconnectors.appsync.PersistentMutationsError
import com.amazonaws.mobileconnectors.appsync.PersistentMutationsResponse
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicAPIKeyAuthProvider
import com.example.awsappsyncsampleapp.AwsAppSync
import com.example.awsappsyncsampleapp.utils.AppConstant
import org.json.JSONObject


object AwsClientInstance {

    fun getInstance(): AWSAppSyncClient {

        val awsClient by lazy {

//            AWSAppSyncClient.builder().context(AwsAppSync.instance)
//                .apiKey(BasicAPIKeyAuthProvider(AppConstant.APPSYNC_API_KEY)) // For use with IAM/Cognito authorization
//                .serverUrl(AppConstant.APPSYNC_API_URL)
//                .region(AppConstant.APPSYNC_REGION)
//                .clientDatabasePrefix("API_KEY").useClientDatabasePrefix(true)
//                .persistentMutationsCallback(object : PersistentMutationsCallback {
//                    override fun onResponse(response: PersistentMutationsResponse) {
//                        Log.d("NOTERROR", response.mutationClassName)
//                    }
//
//                    override fun onFailure(error: PersistentMutationsError) {
//                        Log.e("TAG", error.mutationClassName)
//                        Log.e("TAG", "Error", error.exception)
//                    }
//                }).build()

            val configJsonString =
                AwsAppSync.instance.assets.open("awsconfiguration.json").bufferedReader()
                    .use { it.readText() }

            val awsConfiguration = AWSConfiguration(JSONObject(configJsonString))


            AWSAppSyncClient.builder().context(AwsAppSync.instance)
                .awsConfiguration(awsConfiguration)
                .persistentMutationsCallback(object : PersistentMutationsCallback {
                    override fun onResponse(response: PersistentMutationsResponse) {
                        Log.d("TAG", response.mutationClassName)
                    }

                    override fun onFailure(error: PersistentMutationsError) {
                        Log.e("TAG", error.mutationClassName)
                        Log.e("TAG", "Error", error.exception)
                    }
                }).build()
        }
        return awsClient!!
    }
}