package com.ttfh21.testlifehack

import retrofit2.http.GET
import io.reactivex.Observable

interface MyApi {
    @get:GET("schedule/get_group_lessons_v2/1")
    val posts: Observable<List<Company>>

}