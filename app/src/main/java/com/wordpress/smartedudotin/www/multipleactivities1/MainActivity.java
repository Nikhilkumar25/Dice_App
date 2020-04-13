package com.wordpress.smartedudotin.www.multipleactivities1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Button btnRoll = findViewById (R.id.btnRollTheDice);
        final ImageView img1 = findViewById (R.id.imgdice1);
        final ImageView img2 = findViewById (R.id.imgdice2);
        final MediaPlayer mp  = MediaPlayer.create (this,R.raw.dice_sound);

        final int [] diceImage  = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        btnRoll.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Log.i ("MyDiceApp", "button is tapped");

                Random rndObject = new Random ();
                Random rndObject1 = new Random ();
                int radNumber = rndObject.nextInt (6); //0..5
                int radNumber1 = rndObject1.nextInt (6); // 0..5

                Log.i ("MyDiceApp", "my random number is " + radNumber);

                img1.setImageResource (diceImage[radNumber]);
                img2.setImageResource (diceImage[radNumber1]);

                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(0)
                        .playOn(img1);

                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(0)
                        .playOn(img2);


                mp.start ();
            }
        });
    }
}
