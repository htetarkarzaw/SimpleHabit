package com.arkarzaw.simplehabit.companents;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arkarzaw.simplehabit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressView extends LinearLayout {

    @BindView(R.id.current_day_steak)
    TextView currentDay;

    @BindView(R.id.total_sessions)
    TextView totalSessions;

    @BindView(R.id.total_minutes)
    TextView totalMinutes;

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setCurrentDay(int day){
        currentDay.setText(String.valueOf(day));
    }

    public void setTotalSession(int session){
        totalSessions.setText(String.valueOf(session));
    }

    public void setTotalMinutes(int min){
        totalMinutes.setText(String.valueOf(min));
    }
}
