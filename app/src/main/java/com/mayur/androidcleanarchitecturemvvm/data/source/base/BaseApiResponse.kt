package com.mayur.androidcleanarchitecturemvvm.data.source.base

import com.mayur.androidcleanarchitecturemvvm.common.utils.ApiResult
import retrofit2.Response

abstract class BaseApiResponse {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ApiResult<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    ApiResult.Success(body)
                } else {
                    error("Empty response body")
                }
            } else {
                error("Error ${response.code()}: ${response.message()}")
            }
        } catch (ex: Exception) {
            error("Exception: ${ex.localizedMessage ?: ex.toString()}")
        }
    }

    private fun <T> error(errorMessage: String): ApiResult<T> =
        ApiResult.Error(errorMessage)
}
