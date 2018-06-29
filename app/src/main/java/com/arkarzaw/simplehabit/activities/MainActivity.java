package com.arkarzaw.simplehabit.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.view.MenuItem;
import android.widget.Toast;

import com.arkarzaw.simplehabit.R;
import com.arkarzaw.simplehabit.controllers.HomePresenterDelecate;
import com.arkarzaw.simplehabit.controllers.ItemClickListener;
import com.arkarzaw.simplehabit.datas.VO.BaseVO;
import com.arkarzaw.simplehabit.fragments.MeFragment;
import com.arkarzaw.simplehabit.fragments.MeditateFragment;
import com.arkarzaw.simplehabit.fragments.MoreFragment;
import com.arkarzaw.simplehabit.fragments.NewSeriesFragment;
import com.arkarzaw.simplehabit.mvp.presenters.SeriesPresenter;
import com.arkarzaw.simplehabit.mvp.views.SeriesView;

import java.util.List;

import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

public class MainActivity extends BaseAcitvity implements HomePresenterDelecate,SeriesView,BottomNavigationView.OnNavigationItemSelectedListener {

    SeriesPresenter seriesPresenter;
    MeditateFragment meditateFragment;
    NewSeriesFragment newSeriesFragment;

    List<BaseVO> baseVOList;
    CoordinatorLayout frag_holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);
        frag_holder = findViewById(R.id.frag_holder);
        BottomNavigationView navigation =findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle(R.string.title_meditate);
        meditateFragment = new MeditateFragment();
        loadFragment(meditateFragment);
        seriesPresenter = ViewModelProviders.of(this).get(SeriesPresenter.class);
        seriesPresenter.initPresenter(this);
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
                fragment = meditateFragment;
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
    public SeriesPresenter getSeriesPresenter() {
        return seriesPresenter;
    }

    @Override
    public void displayPrograms(List<BaseVO> baseVO) {
//        newSeriesFragment= meditateFragment.getSeriesFragment();
//        newSeriesFragment.displayDataFromActivity(baseVO);
    }

    @Override
    public void onLaunchCurrentDetail() {
        ShowItemActivity.getInstanceCurrent(this);
    }

    @Override
    public void onLaunchDetailProgram(String categoryId, String categoryItemId) {
        ShowItemActivity.getInstanceCategory(this,categoryId,categoryItemId);
    }

    @Override
    public void displayErrorMsg(String errMessage) {
        Toast.makeText(this, errMessage, Toast.LENGTH_SHORT).show();
    }


//    @Override
//    public void onCurrentItemClick()
//    {
//        ShowItemActivity.getInstanceCurrent(this);
////        Intent showItem = new Intent(this,ShowItemActivity.class);
////        showItem.putExtra("TYPE","current");
////        startActivity(showItem);
//    }
//    @Override
//    public void onCategoryItemClick(String cateId,String proId) {
////        Intent showItem = new Intent(this,ShowItemActivity.class);
////        showItem.putExtra("CATEGORY_ID", cateId);
////        showItem.putExtra("PRO_ID",proId);
////        showItem.putExtra("TYPE","category");
////        startActivity(showItem);
//        ShowItemActivity.getInstanceCategory(this,cateId,proId);
//    }
}
