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

package com.appsyncsample.network

import com.appsyncsample.network.dto.ServerError


internal object ErrorCodeHandler {

    fun getMessageByErrorCode(error: ServerError): String {
        return when (error.statusCode) {
            100, 101, 102 -> {
                com.appsyncsample.network.ErrorMessages.COMMON_MESSAGE.value
            }
            201, 202 -> {
                com.appsyncsample.network.ErrorMessages.COMMON_MESSAGE.value
            }

            400, 401, 402, 403, 404, 405, 406, 407, 408 -> {
                com.appsyncsample.network.ErrorMessages.COMMON_MESSAGE.value
            }

            500, 501, 502, 503, 504 -> {
                com.appsyncsample.network.ErrorMessages.COMMON_MESSAGE.value
            }

            1001 -> {
                com.appsyncsample.network.ErrorMessages.USER_ALREADY_EXISTS.value
            }
            1002 -> {
                com.appsyncsample.network.ErrorMessages.FAMILY_ALREADY_EXISTS.value
            }
            1003 -> {
                com.appsyncsample.network.ErrorMessages.HOME_ALREADY_EXISTS.value
            }
            1004 -> {
                com.appsyncsample.network.ErrorMessages.SINGLE_USER_NOT_DELETED.value
            }
            1005 -> {
                com.appsyncsample.network.ErrorMessages.SINGLE_ADMIN_USER_NOT_DELETED.value
            }
            1006 -> {
                com.appsyncsample.network.ErrorMessages.USER_PROFILE_MAPPING_EXISTS.value
            }
            1007 -> {
                com.appsyncsample.network.ErrorMessages.USER_PROFILE_ALREADY_EXISTS.value
            }
            1008 -> {
                com.appsyncsample.network.ErrorMessages.FAMILY_USER_NOT_FOUND.value
            }
            1009 -> {
                com.appsyncsample.network.ErrorMessages.IMAGE_NOT_IN_PROPER_FORMAT.value
            }
            1010 -> {
                com.appsyncsample.network.ErrorMessages.IMAGE_SIZE_EXCEEDS.value
            }
            1011 -> {
                com.appsyncsample.network.ErrorMessages.MOBILE_NUMBER_EXISTS.value
            }
            2001 -> {
                com.appsyncsample.network.ErrorMessages.GRAPHQL_VALIDATION_FAILED.value
            }
            2002 -> {
                com.appsyncsample.network.ErrorMessages.BAD_USER_INPUT.value
            }
            2003 -> {
                com.appsyncsample.network.ErrorMessages.GRAPHQL_PARSE_FAILED.value
            }
            2004 -> {
                com.appsyncsample.network.ErrorMessages.FORBIDDEN.value
            }
            2005 -> {
                com.appsyncsample.network.ErrorMessages.PERSISTED_QUERY_NOT_FOUND.value
            }
            2006 -> {
                com.appsyncsample.network.ErrorMessages.PERSISTED_QUERY_NOT_SUPPORTED.value
            }
            4001 -> {
                com.appsyncsample.network.ErrorMessages.USER_NOT_AUTHORIZED.value
            }
            4002 -> {
                com.appsyncsample.network.ErrorMessages.USER_AUTHORIZATION_NOT_FOUND.value
            }
            4003 -> {
                com.appsyncsample.network.ErrorMessages.COMMON_MESSAGE.value
            }
            4004 -> {
                com.appsyncsample.network.ErrorMessages.JSON_WEB_TOKEN_EXPIRED.value
            }
            4005 -> {
                com.appsyncsample.network.ErrorMessages.USER_HAVING_INSUFFICIENT_PERMISSION.value
            }
            4007 -> {
                com.appsyncsample.network.ErrorMessages.MUSIC_SERVICE_REFRESH_TOKEN_EXPIRED.value
            }
            5001 -> {
                com.appsyncsample.network.ErrorMessages.INTERNAL_SERVER_ERROR.value
            }
            5002 -> {
                com.appsyncsample.network.ErrorMessages.DATABASE_ERROR.value
            }
            else -> {
                com.appsyncsample.network.ErrorMessages.COMMON_MESSAGE.value
            }
        }
    }

}