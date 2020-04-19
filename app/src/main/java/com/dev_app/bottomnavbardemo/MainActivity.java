package com.dev_app.bottomnavbardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;



/*This tutorial is created by Dayo Jaiye. You can contact me for any support
in Android development. dayojaiye74@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private MusicFragment musicFragment;
    private VideoFragment videoFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navBar);



        homeFragment = new HomeFragment();
        musicFragment = new MusicFragment();
        videoFragment = new VideoFragment();

        setFragment(homeFragment); //...The home fragment is set as default whenever the app is open




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        setFragment(homeFragment);
                        Toast.makeText(MainActivity.this, "Home is clicked", Toast.LENGTH_SHORT).show();
                    return true;

                    case R.id.music:
                        setFragment(musicFragment);
                        Toast.makeText(MainActivity.this, "Music is clicked", Toast.LENGTH_SHORT).show();
                    return true;

                    case R.id.video:
                        setFragment(videoFragment);
                        Toast.makeText(MainActivity.this, "Video is clicked", Toast.LENGTH_SHORT).show();

                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    //Fragment transaction Method....

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTrans = getSupportFragmentManager().beginTransaction();
        fragmentTrans.replace(R.id.mainFrame,fragment);
        fragmentTrans.commit();
    }
}
