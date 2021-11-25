package com.jobesk.calisthenics;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment {
    private View view;
    private ImageView character_img;
    private AnimationDrawable pullUpAnimation, muscleAnimation;

// 0 for pull up normal
    // 1 for muscle up normal
    //2 is for pull up builder
    //3 id for muscl up builder


    private int aniCheck = 0;
    ImageView tap_me_img;


    private CountDownTimer timer;
    private boolean timerRuning = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);


        character_img = view.findViewById(R.id.character_img);
        tap_me_img = view.findViewById(R.id.tap_me_img);


        timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tap_me_img.setVisibility(View.GONE);
                timerRuning = true;

            }

            @Override
            public void onFinish() {
                tap_me_img.setVisibility(View.VISIBLE);
                timerRuning = false;

            }
        }.start();


        character_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (aniCheck) {
                    case 0:
                        tap_me_img.setVisibility(View.GONE);
                        aniCheck = 1;
                        character_img.setImageResource(0);

                        pullUpAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.pull_ups_animation);
                        pullUpAnimation.setOneShot(true);
                        character_img.setBackgroundDrawable(pullUpAnimation);
                        pullUpAnimation.start();
                        break;

                    case 1:
                        tap_me_img.setVisibility(View.GONE);

                        aniCheck = 2;

                        character_img.setImageResource(0);

                        muscleAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.muscle_ups_animation);
                        muscleAnimation.setOneShot(true);
                        character_img.setBackgroundDrawable(muscleAnimation);
                        muscleAnimation.start();

                        break;
                    case 2:

                        tap_me_img.setVisibility(View.GONE);
                        aniCheck = 3;

                        character_img.setImageResource(0);

                        muscleAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.pull_ups_builder_animation);
                        muscleAnimation.setOneShot(true);
                        character_img.setBackgroundDrawable(muscleAnimation);
                        muscleAnimation.start();

                        break;
                    case 3:
                        tap_me_img.setVisibility(View.GONE);

                        aniCheck = 2;

                        character_img.setImageResource(0);

                        muscleAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.muscle_ups_builder_animation);
                        muscleAnimation.setOneShot(true);
                        character_img.setBackgroundDrawable(muscleAnimation);
                        muscleAnimation.start();

                        break;


                }


            }
        });


        return view;

    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if (timerRuning == true) {


            timer.cancel();
        }

    }
}
