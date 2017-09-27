package com.matrixxun.producttour;

import android.os.Bundle;

import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.enums.NaviType;


public class WalkRouteCalculateActivity extends BaseActivity {
    private double jd;
    private double wd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_navi);
        mAMapNaviView = (AMapNaviView) findViewById(R.id.navi_view);
        mAMapNaviView.onCreate(savedInstanceState);
        mAMapNaviView.setAMapNaviViewListener(this);
        mAMapNaviView.setNaviMode(AMapNaviView.NORTH_UP_MODE);
//        Intent intent=getIntent();
//        jd = intent.getDoubleExtra("jd", 0);
//        wd = intent.getDoubleExtra("wd", 0);
//        Toast.makeText(this,""+jd+","+wd,Toast.LENGTH_LONG).show();





    }

    @Override
    public void onInitNaviSuccess() {
        super.onInitNaviSuccess();
        mAMapNavi.calculateWalkRoute(this.mStartLatlng,this.mEndLatlng);
//        Toast.makeText(this,""+jd+","+wd,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCalculateRouteSuccess() {
        super.onCalculateRouteSuccess();
        mAMapNavi.startNavi(NaviType.GPS);
    }
}
