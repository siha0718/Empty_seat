package com.example.vincenzo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.Manifest;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;


import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.security.MessageDigest;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    //private Frag1 frag1;
    private Frag1_1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;


    private CafeRecyclerAdapter adapter;

    private Button button1;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 위치좌표 받아오기
        GpsTracker gpsTracker = new GpsTracker(MainActivity.this);
        double currentLatitude = gpsTracker.getLatitude();
        double currentLongitude = gpsTracker.getLongitude();

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_favorite:
                        setFrag(1);
                        break;
                    case R.id.action_account:
                        setFrag(2);
                        break;
                    case R.id.action_setting:
                        setFrag(3);
                        break;

                }
                return true;
            }
        });
        frag1 = new Frag1_1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        setFrag(0);//첫 프래그먼트 화면을 무엇으로 지정해줄것인지 선택



    }
    //프래그먼트 교체가 일어나는 실행문
    public void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame,frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frag4);
                ft.commit();
                break;
        }
    }


} //MainActivity