package com.st10462391.tamagotchiapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val petImageView = findViewById<ImageView>(R.id.imageView3)
        val feedButton = findViewById<Button>(R.id.feedbutton)
        val cleanButton = findViewById<Button>(R.id.cleanbutton)
        val playButton = findViewById<Button>(R.id.playbutton)

        val feedTextView = findViewById<TextView>(R.id.feedtextview)
        val cleanTextView = findViewById<TextView>(R.id.cleantextview)
        val playTextView = findViewById<TextView>(R.id.playtextview)

        //Retrieve the message passed from the first screen
        val feedMessage = intent.getStringExtra("Please feed me, i'm hungry")
        //Set the text of the feed TextView to the food message
        feedTextView.text = feedMessage

        //Logic for the Feed button
        feedButton.setOnClickListener {
        //Change the pet's image to match feeding action icon

    petImageView.setImageResource(R.drawable.dogeating)//dogeating

         //Update the pet's status values(e.g, health, hunger, cleanliness)
         //Update the feed TextView
         feedTextView.text = getString(R.string.feed_thank_you)

         //Update the play TextView
         playTextView.text = getString(R.string.play_with_me)

        }

        //Logic for the Clean button
        cleanButton.setOnClickListener {
            //Change the pet's image to match cleaning action icon

    petImageView.setImageResource(R.drawable.dogbathing)//dogbathing
            //Update the pet's status values (e.g, health, hunger, cleaniness)
            //Update the clean textview
            cleanTextView.text = getString(R.string.clean_nice_and_clean)

        }

        //Logic for Play button
        playButton.setOnClickListener {
            //Change the pet's image to match playing action icon

    petImageView.setImageResource(R.drawable.dogplaying)//dogplaying

            //Update the pet's status values (e.g, health, hunger, cleanliness)
            //Update the play Textview
            playTextView.text = getString(R.string.play_that_was_fun)
            //Update the clean textview
            cleanTextView.text = getString(R.string.clean_after_playing)


        }
    }
}
@Suppress("RedundantSamConstructor")
class GameActivity : AppCompatActivity() {

    private lateinit var feedProgressBar: ProgressBar
    private lateinit var playProgressBar: ProgressBar
    private lateinit var cleanProgressBar: ProgressBar

    private var feedProgressStatus = 0
    private var playProgressStatus = 0
    private var cleanProgressStatus = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        feedProgressBar = findViewById(R.id.feedprogressBar)
        playProgressBar = findViewById(R.id.playprogressBar)
        cleanProgressBar = findViewById(R.id.cleanprogressBar)

        val feedButton = findViewById<Button>(R.id.feedbutton)
        val cleanButton = findViewById<Button>(R.id.cleanbutton)
        val playButton = findViewById<Button>(R.id.playbutton)

        feedButton.setOnClickListener {
            feedProgressStatus = 0
            feedProgressBar.progress = feedProgressStatus
            Thread(Runnable {
                while (feedProgressStatus < 100) {
                    feedProgressStatus += 5
                    Thread.sleep(1000)
                    runOnUiThread {
                        feedProgressBar.progress = feedProgressStatus
                    }
                }
                runOnUiThread {
                    //Update feedTextView message
                }
            }).start()
        }

        cleanButton.setOnClickListener {
            cleanProgressStatus = 0
            cleanProgressBar.progress = cleanProgressStatus
            Thread(Runnable {
                while (cleanProgressStatus<100) {
                    Thread.sleep(1000)
                    runOnUiThread {
                        cleanProgressBar.progress = cleanProgressStatus
                    }
                }
                runOnUiThread {
                    //Update cleanTextView message
                }
            }).start()
        }

        playButton.setOnClickListener {
            playProgressStatus = 0
            playProgressBar.progress = playProgressStatus
            while (playProgressStatus<100) {
                playProgressStatus += 5
                Thread.sleep(1000)
                runOnUiThread {
                    playProgressBar.progress = playProgressStatus
                }
            }
                runOnUiThread {
                //Update playTextView message
                }
            }
        }
    }

