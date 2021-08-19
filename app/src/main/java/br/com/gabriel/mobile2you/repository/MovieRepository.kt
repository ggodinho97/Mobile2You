package br.com.gabriel.mobile2you.repository


import br.com.gabriel.mobile2you.model.Movie
import br.com.gabriel.mobile2you.model.SimilarMovie
import br.com.gabriel.mobile2you.utils.Retrofit
import retrofit2.Callback

class MovieRepository(private val retrofit: Retrofit) {

    fun getMovie(callback: retrofit2.Callback<Movie>) {
        val movieApi = retrofit.movieApi()
        val call =  movieApi.getMovie()
        call.enqueue(callback)
    }

    fun getSimilarMovie(callback: Callback<SimilarMovie>) {
        val movieApi = retrofit.movieApi()
        val call =  movieApi.getSimilar()
        call.enqueue(callback)
    }

}
