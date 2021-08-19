package br.com.gabriel.mobile2you.remote

import br.com.gabriel.mobile2you.model.Movie
import br.com.gabriel.mobile2you.model.SimilarMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    companion object {
        const val apiAcessKey = "2fde90715cfd48e912842c417e15a9da"
    }

    @GET("movie/{movie_id}?api_key=$apiAcessKey")
    fun getMovie(
        @Path("movie_id") movieId: String? ="550"
    ): Call<Movie>

    @GET("movie/{movie_id}/similar?api_key=$apiAcessKey")
    fun getSimilar(
        @Path("movie_id") movieId: String? = "550"
    ): Call<SimilarMovie>

}
