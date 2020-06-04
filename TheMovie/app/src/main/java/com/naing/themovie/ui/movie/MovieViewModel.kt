package com.naing.themovie.ui.movie

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.naing.themovie.model.RetrofitManager
import com.naing.themovie.model.api.MovieAPI
import com.naing.themovie.model.dto.Movie
import com.naing.themovie.model.service.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val service: MovieService
    private val compositeDisposable = CompositeDisposable()
    val movie = MutableLiveData<Movie>()

    init {
        service = MovieService(RetrofitManager.create(MovieAPI::class.java))
    }

    fun loadPopular() {
        val disposable = service.getPopular()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movie.value = it
                Log.d("TAG", it.title)
            }, {
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    /* fun loadNowPlaying() {
         val disposable = service.getNowPlaying()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe()
         compositeDisposable.add(disposable)
     }

     fun loadUpComing() {
         val disposable = service.getUpComing()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe()
         compositeDisposable.add(disposable)
     }

     fun loadTopRated() {
         val disposable = service.getTopRated()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe()
         compositeDisposable.add(disposable)
     }

     fun loadGenres() {
         val disposable = service.getGenres()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe()
         compositeDisposable.add(disposable)
     }
 */
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}