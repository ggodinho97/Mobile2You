package br.com.gabriel.mobile2you.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.gabriel.mobile2you.R
import br.com.gabriel.mobile2you.model.Movie
import br.com.gabriel.mobile2you.model.SimilarMovie
import br.com.gabriel.mobile2you.ui.adapter.SimilarMovieAdapter
import br.com.gabriel.mobile2you.utils.Constants
import br.com.gabriel.mobile2you.viewmodel.MovieViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModel()
    private var isLiked = true
    private lateinit var adapter: SimilarMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

    }

    private fun setupView() {
        adapter = SimilarMovieAdapter()
        rvSimilarMovie.adapter = adapter

        setupListenears()
        getMovie()
    }

    private fun setupListenears(){
        imgLike.setOnClickListener {
            isLiked = if (isLiked) {
                imgLike.setImageResource(R.drawable.heart_outline)
                false
            } else {
                imgLike.setImageResource(R.drawable.cards_heart)
                true
            }
        }
    }

    private fun getMovie(){
            viewModel.getMovie(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    val movie = response.body()
                    showMovie(movie)

                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Falha Filme!", Toast.LENGTH_SHORT).show()
                }

            })

            viewModel.getSimilarMovie(object : Callback<SimilarMovie> {

                override fun onResponse(
                    call: Call<SimilarMovie>,
                    response: Response<SimilarMovie>,
                ) {
                    val similar = response.body()
                    adapter.items = similar?.results?.toMutableList()?: mutableListOf()

                }

                override fun onFailure(call: Call<SimilarMovie>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Falha Filme!", Toast.LENGTH_SHORT).show()
                }


            })

        }

    private fun showMovie(movie: Movie?) {
        Glide
            .with(this@MainActivity)
            .load(Constants.BASE_IMAGE_URL + movie?.poster_path)
            .into(imgBanner)

        tvTitle.text = movie?.title
        tvLikes.text = getString(R.string.voteCounts, movie?.vote_count)
        tvViews.text = getString(R.string.countViews, movie?.popularity)
    }


}