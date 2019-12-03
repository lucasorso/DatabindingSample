package com.lucasorso.databindingsample

import androidx.annotation.IntRange
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Score : BaseObservable() {
    @IntRange(from = 0, to = 100)
    var score: Int = 0
        @Bindable get
        set(value) {
            if (value in 0..100) {
                field = value
                notifyPropertyChanged(BR.score)
            }
        }
}