package br.com.gabriel.mobile2you.viewmodel

import androidx.lifecycle.ViewModel
import br.com.gabriel.mobile2you.model.Movie
import br.com.gabriel.mobile2you.model.SimilarMovie
import br.com.gabriel.mobile2you.repository.MovieRepository
import retrofit2.Callback


class MovieViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovie(callback: Callback<Movie>) = movieRepository.getMovie(callback = callback)

    fun getSimilarMovie(callback: Callback<SimilarMovie>) = movieRepository.getSimilarMovie(callback = callback)

}
