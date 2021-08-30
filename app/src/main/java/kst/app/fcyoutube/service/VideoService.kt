package kst.app.fcyoutube.service

import kst.app.fcyoutube.dto.VideoDto
import retrofit2.Call
import retrofit2.http.GET

interface VideoService {

    @GET("/v3/5a68bd5a-06d3-41fd-b762-f079603d309f")
    fun listVideos(): Call<VideoDto>
}