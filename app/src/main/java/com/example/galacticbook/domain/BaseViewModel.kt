package com.example.galacticbook.domain

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    val bag by lazy { CompositeDisposable() }
    val bag3 by lazy { CompositeDisposable() }

    override fun onCleared() {
        bag.clear()
        bag3.clear()
        super.onCleared()
    }
}