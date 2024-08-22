package com.example.galacticbook.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var galaxyState: GalaxyState by mutableStateOf(GalaxyState.Loading)
        private set
    var characterState: CharacterState by mutableStateOf(CharacterState.Loading)
        private set

    fun fetchAliens(page: Int = 2) {
        repository.fetchAliens(page)
            .compose { upstream ->
                upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
            .subscribe(
                { data ->
                    galaxyState = GalaxyState.Content(data)
                },
                { error ->
                    galaxyState =
                        GalaxyState.Error(error.message ?: "Looks something was wrong")
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
                    characterState = CharacterState.Content(data)
                },
                { error ->
                    characterState =
                        CharacterState.Error(error.message ?: "Looks something was wrong")
                }).addTo(bag3)
    }
}