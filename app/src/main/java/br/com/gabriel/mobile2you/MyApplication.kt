package br.com.gabriel.mobile2you

import android.app.Application
import br.com.gabriel.mobile2you.di.MovieModule
import org.koin.android.ext.android.startKoin


class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf( MovieModule.appModule ))
    }
}