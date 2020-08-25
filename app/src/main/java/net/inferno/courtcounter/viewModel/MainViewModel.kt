package net.inferno.courtcounter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val teamScores = List(2) {
        MutableLiveData(0)
    }

    val firstTeam get() = teamScores[0]
    val secondTeam get() = teamScores[1]

    fun addScore(teamIndex: Int, value: Int) = teamScores[teamIndex].postValue(
        teamScores[teamIndex].value!! + value
    )

    fun resetScores() = teamScores.forEach {
        it.postValue(0)
    }
}