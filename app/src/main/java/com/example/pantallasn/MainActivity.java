package com.example.pantallasn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         decorView = getWindow().getDecorView();
         decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
             @Override
             public void onSystemUiVisibilityChange(int i) {
                 if (i==0){
                     decorView.setSystemUiVisibility(EscondeteBarra());
                 }
             }
         });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
      super.onWindowFocusChanged(hasFocus);
      if (hasFocus){
          decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
      }
    }

    private int EscondeteBarra(){
        return View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

}