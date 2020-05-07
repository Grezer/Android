package rest

import io.reactivex.Observable
import retrofit2.http.*

interface cloudAPI {
/*
    @Headers("Content-Type: application/json")
    @POST("/getStatistic")
    fun getStatistics (
        @Body bodyData: someData
    ): Observable<List<listOfCountry>>
    */

    @GET("/getCountry")
    fun getCountry(): Observable<listOfCountry>
}