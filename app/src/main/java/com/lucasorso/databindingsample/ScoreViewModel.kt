package com.lucasorso.databindingsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoreViewModel(private val teamList: Array<Team>) : ViewModel() {

    val teamA by lazy { teamList[0] }
    val teamB by lazy { teamList[1] }

    fun incrementTeamA() {
        teamA.teamScore.score++
    }

    fun incrementTeamB() {
        teamB.teamScore.score++
    }

    fun reset() {
        teamList.forEach { it.teamScore.score = 0 }
    }

    class Factory(private val teamList: Array<Team>) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
                return ScoreViewModel(teamList) as T
            }
            throw Exception("This is not correct View Model Class!")
        }
    }
}