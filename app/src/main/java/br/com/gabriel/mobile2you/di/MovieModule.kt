package br.com.gabriel.mobile2you.di

import br.com.gabriel.mobile2you.repository.MovieRepository
import br.com.gabriel.mobile2you.utils.Retrofit
import br.com.gabriel.mobile2you.viewmodel.MovieViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object MovieModule {

    val appModule = module {

        single { Retrofit() }

        factory { MovieRepository( get() ) }

        viewModel { MovieViewModel( get() ) }

    }



}
