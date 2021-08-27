package com.example.whichnumberisbigger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var score = 0
    lateinit var scoreview: TextView
    lateinit var buttonLeft: Button
    lateinit var buttonRight: Button
    var minnum = 1
    var maxnum = 100
    var leftnum = (Math.random() * maxnum + minnum).toInt()
    var rightnum = (Math.random() * maxnum + minnum).toInt()
    lateinit var minchange : EditText
    lateinit var maxchange : EditText
    lateinit var buttonReroll : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scoreview = findViewById(R.id.text_main_score)
        buttonLeft = findViewById(R.id.button_main_left)
        buttonRight = findViewById(R.id.button_main_right)
        minchange = findViewById(R.id.number_main_minchange)
        maxchange = findViewById(R.id.number_main_maxchange)
        buttonReroll = findViewById(R.id.button_main_reroll)
        while (rightnum == leftnum) {
            rightnum = (Math.random() * maxnum + minnum).toInt()
        }
        scoreview.text = "$score"
        buttonLeft.text = "$leftnum"
        buttonRight.text = "$rightnum"
        buttonReroll.setOnClickListener() {
            if ((maxchange.text.toString() == "") || (minchange.text.toString() == "")){
                Toast.makeText(this, "Max and/or Min need values", Toast.LENGTH_SHORT).show()
            }
            else {
                while (maxchange.text.toString().toInt() < minchange.text.toString().toInt()) {
                    Toast.makeText(this, "Max must be larger than Min", Toast.LENGTH_SHORT).show()
                }
                minnum = minchange.text.toString().toInt()
                maxnum = maxchange.text.toString().toInt()
                leftnum = (Math.random() * (maxnum - minnum + 1) + minnum).toInt()
                rightnum = (Math.random() * (maxnum - minnum + 1) + minnum).toInt()
                while (rightnum == leftnum) {
                    rightnum = (Math.random() * (maxnum - minnum + 1) + minnum).toInt()
                }
                buttonLeft.text = "$leftnum"
                buttonRight.text = "$rightnum"
                Toast.makeText(this, "Numbers changed between Min and Max, inclusive.", Toast.LENGTH_SHORT).show()
            }
        }
        buttonLeft.setOnClickListener() {
            if (leftnum > rightnum) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score++
                scoreview.text = "$score"
                leftnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                while (rightnum == leftnum) {
                    rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                }
                buttonLeft.text = "$leftnum"
                buttonRight.text = "$rightnum"

            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
                score--
                scoreview.text = "$score"
                leftnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                while (rightnum == leftnum) {
                    rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                }
                buttonLeft.text = "$leftnum"
                buttonRight.text = "$rightnum"
            }
        }
        buttonRight.setOnClickListener() {
            if (rightnum > leftnum) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score++
                scoreview.text = "$score"
                leftnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                while (rightnum == leftnum) {
                    rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                }
                buttonLeft.text = "$leftnum"
                buttonRight.text = "$rightnum"
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
                score--
                scoreview.text = "$score"
                leftnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                while (rightnum == leftnum) {
                    rightnum = (Math.random() * (maxnum-minnum+1)+minnum).toInt()
                }
                buttonLeft.text = "$leftnum"
                buttonRight.text = "$rightnum"
            }
        }
        if(score == 100)
        {
            score = 0
            Toast.makeText(this, "You Win! ", Toast.LENGTH_SHORT).show()
            //wins++
        }
        if(score <= -5)
            score == 0
            Toast.makeText(this , "You Lose! Go back to 1st grade", Toast.LENGTH_SHORT).show()
            //losses++
    }
}