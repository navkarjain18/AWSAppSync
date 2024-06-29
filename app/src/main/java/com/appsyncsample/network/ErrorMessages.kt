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

internal enum class ErrorMessages(val value: String) {
    /*Custom Codes Error*/
    USER_ALREADY_EXISTS("A user with these details already exists in the family."),
    FAMILY_ALREADY_EXISTS("A family with these details already exists."),
    HOME_ALREADY_EXISTS("A home with these details already exists."),
    SINGLE_USER_NOT_DELETED("There must be one active resident in the family."),
    SINGLE_ADMIN_USER_NOT_DELETED("There must be one admin resident in the family."),
    USER_PROFILE_MAPPING_EXISTS("User profile mapping already exists."),
    USER_PROFILE_ALREADY_EXISTS("User profile data already exists with same name."),
    FAMILY_USER_NOT_FOUND("Family users not found"),
    IMAGE_NOT_IN_PROPER_FORMAT("Only the following image formats are supported: jpg, jpeg, png."),
    IMAGE_SIZE_EXCEEDS("Image size cannot be more than 5 MB."),
    MULTI_UPLOAD_ERROR( "Some media files could not be uploaded."),
    MEDIA_UPLOAD_FORMAT_ERROR( "The upload media file format is not supported."),
    MOBILE_NUMBER_EXISTS("User with this mobile number already exists in the family."),
    GRAPHQL_VALIDATION_FAILED("We're having some trouble completing your request. Please try again in sometime."),
    BAD_USER_INPUT("We're having some trouble completing your request. Please try again in sometime."),
    GRAPHQL_PARSE_FAILED("We're having some trouble completing your request. Please try again in sometime."),
    FORBIDDEN("We're having some trouble completing your request. Please try again in sometime."),
    PERSISTED_QUERY_NOT_FOUND("We're having some trouble completing your request. Please try again in sometime."),
    PERSISTED_QUERY_NOT_SUPPORTED("We're having some trouble completing your request. Please try again in sometime."),
    USER_NOT_AUTHORIZED("We are unable to find a user with the entered details."),
    USER_AUTHORIZATION_NOT_FOUND("User authorization details not found."),
    FIREBASE_TOKEN_EXPIRED("Firebase Id Token is invalid or expired."),
    JSON_WEB_TOKEN_EXPIRED("Json Web Token is invalid or expired."),
    USER_HAVING_INSUFFICIENT_PERMISSION("User is having insufficient permission."),
    INTERNAL_SERVER_ERROR("We're having some trouble completing your request. Please try again in sometime."),
    DATABASE_ERROR("We're having some trouble completing your request. Please try again in sometime."),
    COMMON_MESSAGE("We're having some trouble completing your request. Please try again in sometime."),
    IMAGE_URL_NULL("Image url is null."),
    MUSIC_SERVICE_REFRESH_TOKEN_EXPIRED("TOKEN_EXPIRED")
}