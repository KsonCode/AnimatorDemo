package com.laoxu.animatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv);



        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了图片", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 点击移动
     * @param view
     */
    public void click(View view) {
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate);
//        animation.setDuration(3000);
//        animation.setFillAfter(true);
//        iv.startAnimation(animation);



    }

    /**
     * 平移
     * @param view
     */
    public void transltaion(View view) {
        //第一个参数代表：操作的对象，第二个参数属性的配置,第三个参数是具体的值
        ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(iv,"translationX",0f,1000f);

        //第二步设置
        translateAnimator.setDuration(3000);

        translateAnimator.start();


        //第一个参数代表：操作的对象，第二个参数属性的配置,第三个参数是具体的值
        ObjectAnimator translateYAnimator = ObjectAnimator.ofFloat(iv,"translationY",0f,1000f,500f,1000f);

        translateYAnimator.setRepeatCount(-1);//无限循环
        //第二步设置
        translateYAnimator.setDuration(3000);

        translateYAnimator.start();
    }

    /**
     * 旋转
     * @param view
     */
    public void rotate(View view) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv,"rotation",0f,360f,0f,360f,0f,180f,120f);

        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(2);//循环执行两次

        objectAnimator.start();

    }

    /**
     * 渐变
     * @param view
     */
    public void alpha(View view) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv,"alpha",0f,1f,0f,0.5f);

        objectAnimator.setDuration(1000);

        objectAnimator.start();
    }

    /**
     * 缩放
     * @param view
     */
    public void scale(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv,"scaleY",1f,2f,3f,100f);

        objectAnimator.setDuration(1000);

        objectAnimator.start();
    }

    /**
     * 组合所有动画
     * @param view
     */
    public void animatorSet(View view) {

        //平移

        ObjectAnimator py = ObjectAnimator.ofFloat(iv,"translationX",0f,1000f);



        //渐变

        ObjectAnimator jb = ObjectAnimator.ofFloat(iv,"scaleX",0f,1f);



        //旋转

        ObjectAnimator xz = ObjectAnimator.ofFloat(iv,"rotation",0f,360f);




        //组合

        AnimatorSet  set = new AnimatorSet();

        //play播放动画，with和谁一起执行，before在谁之前执行,after在谁之后执行
        set.play(py).with(jb).with(xz);




        //开始动画

        set.setDuration(3000);
        set.start();


    }
}
