package com.womenwhocode.spacex.data.datasources

import com.womenwhocode.spacex.data.model.LaunchDataApi
import com.womenwhocode.spacex.data.services.LaunchApi
import com.womenwhocode.spacex.domain.model.Launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rocio Ortega on 19/05/2018.
 */
class LaunchCloudDataSource(val launchApi: LaunchApi) {
    fun getLaunchs(onSuccess: (List<Launch>) -> Unit, onError: (Throwable?) -> Unit) {

        launchApi.getLaunches().enqueue(object : Callback<List<LaunchDataApi>> {
            override fun onFailure(call: Call<List<LaunchDataApi>>?, t: Throwable?) {
                onError.invoke(t)
            }

            override fun onResponse(call: Call<List<LaunchDataApi>>?, response: Response<List<LaunchDataApi>>?) {
                response?.let {
                    if (it.isSuccessful) {
                        onSuccess.invoke(response.body().map { toDomain(it) })
                    } else {
                        onError.invoke(null)
                    }
                } ?: run { onError.invoke(null) }
            }
        })
    }
}