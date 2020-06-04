package net.inferno.courtcounter.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.inferno.courtcounter.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var scoreTeam1 = 0
        set(value) {
            field = value
            score1.text = scoreTeam1.toString()
        }
    private var scoreTeam2 = 0
        set(value) {
            field = value
            score2.text = scoreTeam2.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reset.setOnClickListener {
            scoreTeam1 = 0
            scoreTeam2 = 0
        }

        team1plus2.setOnClickListener { scoreTeam1 += 2 }

        team2plus2.setOnClickListener { scoreTeam2 += 2 }

        team1plus3.setOnClickListener { scoreTeam1 += 3 }

        team2plus3.setOnClickListener { scoreTeam2 += 3 }
    }
}