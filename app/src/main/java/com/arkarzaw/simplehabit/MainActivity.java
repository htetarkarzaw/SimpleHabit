package com.arkarzaw.simplehabit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.arkarzaw.simplehabit.Fragments.MeFragment;
import com.arkarzaw.simplehabit.Fragments.MeditateFragment;
import com.arkarzaw.simplehabit.Fragments.MoreFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    CoordinatorLayout frag_holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag_holder = findViewById(R.id.frag_holder);


        BottomNavigationView navigation =findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle(R.string.title_meditate);
        loadFragment(new MeditateFragment());
    }

    private boolean loadFragment(android.support.v4.app.Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_holder,fragment)
                    .commit();
                    return  true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        android.support.v4.app.Fragment fragment=null;
        switch (item.getItemId()){
            case R.id.navigation_meditate:
                fragment = new MeditateFragment();
                getSupportActionBar().setTitle(R.string.title_meditate);
                break;
            case R.id.navigation_me:
                fragment = new MeFragment();
                getSupportActionBar().setTitle(R.string.title_me);
                break;
            case R.id.navigation_more:
                fragment = new MoreFragment();
                getSupportActionBar().setTitle(R.string.title_more);
                break;

        }
        return loadFragment(fragment);
    }
}
