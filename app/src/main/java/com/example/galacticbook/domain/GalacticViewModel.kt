package com.example.galacticbook.domain

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class GalacticViewModel @Inject constructor(
    private val repository: GalacticRepository
) : BaseViewModel() {

    fun fetchAliens(page: Int = 2) {
        repository.fetchAliens(page)
            .compose { upstream ->
                upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
            .subscribe(
                { data ->
                    Log.e("CHECK DATA", "$data")
                },
                { error ->
                    Log.e("ERROR", "${error.message}")

                }).addTo(bag3)
    }

    fun alienDetails(id: Int) {
        repository.alienDetails(id)
            .compose { upstream ->
                upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
            .subscribe(
                { data ->
                    Log.e("CHECK DATA", "$data")
                },
                { error ->
                    Log.e("ERROR", "${error.message}")
                }).addTo(bag3)
    }
}