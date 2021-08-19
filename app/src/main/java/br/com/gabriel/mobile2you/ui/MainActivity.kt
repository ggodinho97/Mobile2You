package br.com.gabriel.mobile2you.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.gabriel.mobile2you.R
import br.com.gabriel.mobile2you.model.Movie
import br.com.gabriel.mobile2you.model.SimilarMovie
import br.com.gabriel.mobile2you.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvany.setOnClickListener {

            viewModel.getMovie(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    Toast.makeText(this@MainActivity, "Sucesso Filme!", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this@MainActivity, "Sucesso  Filme!", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<SimilarMovie>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Falha Filme!", Toast.LENGTH_SHORT).show()
                }


            })

        }


    }
}