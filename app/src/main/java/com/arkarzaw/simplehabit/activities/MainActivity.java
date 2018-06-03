package com.arkarzaw.simplehabit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.view.MenuItem;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.fragments.MeFragment;
import com.arkarzaw.simplehabit.fragments.MeditateFragment;
import com.arkarzaw.simplehabit.fragments.MoreFragment;

public class MainActivity extends BaseAcitvity implements BottomNavigationView.OnNavigationItemSelectedListener {

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

    @Override
    public void onCurrentItemClick()
    {
        ShowItemActivity.getInstanceCurrent(this);
//        Intent showItem = new Intent(this,ShowItemActivity.class);
//        showItem.putExtra("TYPE","current");
//        startActivity(showItem);
    }
    @Override
    public void onCategoryItemClick(String cateId,String proId) {
//        Intent showItem = new Intent(this,ShowItemActivity.class);
//        showItem.putExtra("CATEGORY_ID", cateId);
//        showItem.putExtra("PRO_ID",proId);
//        showItem.putExtra("TYPE","category");
//        startActivity(showItem);
        ShowItemActivity.getInstanceCategory(this,cateId,proId);
    }
}
