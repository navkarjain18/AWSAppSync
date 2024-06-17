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

import com.example.awsappsyncsampleapp.network.dto.ServerError


internal object ErrorCodeHandler {

    fun getMessageByErrorCode(error: ServerError): String {
        return when (error.statusCode) {
            100, 101, 102 -> {
                ErrorMessages.COMMON_MESSAGE.value
            }
            201, 202 -> {
                ErrorMessages.COMMON_MESSAGE.value
            }

            400, 401, 402, 403, 404, 405, 406, 407, 408 -> {
                ErrorMessages.COMMON_MESSAGE.value
            }

            500, 501, 502, 503, 504 -> {
                ErrorMessages.COMMON_MESSAGE.value
            }

            1001 -> {
                ErrorMessages.USER_ALREADY_EXISTS.value
            }
            1002 -> {
                ErrorMessages.FAMILY_ALREADY_EXISTS.value
            }
            1003 -> {
                ErrorMessages.HOME_ALREADY_EXISTS.value
            }
            1004 -> {
                ErrorMessages.SINGLE_USER_NOT_DELETED.value
            }
            1005 -> {
                ErrorMessages.SINGLE_ADMIN_USER_NOT_DELETED.value
            }
            1006 -> {
                ErrorMessages.USER_PROFILE_MAPPING_EXISTS.value
            }
            1007 -> {
                ErrorMessages.USER_PROFILE_ALREADY_EXISTS.value
            }
            1008 -> {
                ErrorMessages.FAMILY_USER_NOT_FOUND.value
            }
            1009 -> {
                ErrorMessages.IMAGE_NOT_IN_PROPER_FORMAT.value
            }
            1010 -> {
                ErrorMessages.IMAGE_SIZE_EXCEEDS.value
            }
            1011 -> {
                ErrorMessages.MOBILE_NUMBER_EXISTS.value
            }
            2001 -> {
                ErrorMessages.GRAPHQL_VALIDATION_FAILED.value
            }
            2002 -> {
                ErrorMessages.BAD_USER_INPUT.value
            }
            2003 -> {
                ErrorMessages.GRAPHQL_PARSE_FAILED.value
            }
            2004 -> {
                ErrorMessages.FORBIDDEN.value
            }
            2005 -> {
                ErrorMessages.PERSISTED_QUERY_NOT_FOUND.value
            }
            2006 -> {
                ErrorMessages.PERSISTED_QUERY_NOT_SUPPORTED.value
            }
            4001 -> {
                ErrorMessages.USER_NOT_AUTHORIZED.value
            }
            4002 -> {
                ErrorMessages.USER_AUTHORIZATION_NOT_FOUND.value
            }
            4003 -> {
                ErrorMessages.COMMON_MESSAGE.value
            }
            4004 -> {
                ErrorMessages.JSON_WEB_TOKEN_EXPIRED.value
            }
            4005 -> {
                ErrorMessages.USER_HAVING_INSUFFICIENT_PERMISSION.value
            }
            4007 -> {
                ErrorMessages.MUSIC_SERVICE_REFRESH_TOKEN_EXPIRED.value
            }
            5001 -> {
                ErrorMessages.INTERNAL_SERVER_ERROR.value
            }
            5002 -> {
                ErrorMessages.DATABASE_ERROR.value
            }
            else -> {
                ErrorMessages.COMMON_MESSAGE.value
            }
        }
    }

}