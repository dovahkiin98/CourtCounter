package net.inferno.courtcounter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_ui.*

class MainUI : AppCompatActivity() {

    private var _scoreT1 = 0
    private var _scoreT2 = 0

    private var scoreT1
        get() = _scoreT1
        set(value) {
            _scoreT1 = value
            score1.text = scoreT1.toString()
        }
    private var scoreT2
        get() = _scoreT2
        set(value) {
            _scoreT2 = value
            score2.text = scoreT2.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_ui)

        reset.setOnClickListener { scoreT1 = 0; scoreT2 = 0 }

        team1plus2.setOnClickListener { scoreT1 += 2 }

        team2plus2.setOnClickListener { scoreT2 += 2 }

        team1plus3.setOnClickListener { scoreT1 += 3 }

        team2plus3.setOnClickListener { scoreT2 += 3 }
    }
}
