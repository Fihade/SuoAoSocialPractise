package com.matrixxun.producttour;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swaggymiller on 2017/7/22.
 */

public class medicineitem extends AppCompatActivity {
    //private DrawerLayout mDrawerLayout;

    private Medicine[] medicines = {new Medicine("藿香正气水", R.drawable.huoxiangzhengqishui),
            new Medicine("阿司匹林", R.drawable.asippilin), new Medicine("牛黄解毒丸", R.drawable.jieduwan),
            new Medicine("速效救心丸", R.drawable.jiuxinwan), new Medicine("烧伤膏", R.drawable.shaoshanggao),
            new Medicine("云南白药", R.drawable.yunnanbaiyao), new Medicine("白树油", R.drawable.baishuyou),
            new Medicine("醋酸氟轻松乳膏", R.drawable.cusuanfuqingsongrugao), new Medicine("酚麻美敏片", R.drawable.fenmameiminpian),
            new Medicine("复方丹参片", R.drawable.fufangdanshanpian), new Medicine("白加黑", R.drawable.heijiabai),
            new Medicine("美扑伪麻片", R.drawable.meipuweimapian), new Medicine("双黄连口服液", R.drawable.shunaghuangliankoufuye),
            new Medicine("头孢克圬片", R.drawable.toubaokewupian), new Medicine("小儿感冒颗粒", R.drawable.xiaoerganmaokeli),
            new Medicine("小儿七新茶颗粒", R.drawable.xiaoerqixinchakeli) };

    private List<Medicine> medicineList = new ArrayList<>();

    private MedicineAdapter adapter;
    public Button bt_getmedicine;
    private BluetoothAdapter mBluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinefirst);

        initMedicines();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MedicineAdapter(medicineList);
        recyclerView.setAdapter(adapter);

        bt_getmedicine = (Button) findViewById(R.id.bt_getmedicine);
        bt_getmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.enable();
                }
            }
        });
    }


    private void initMedicines(){

        medicineList.clear();
        {
            for(int i = 0;i < medicines.length; i++) {

                medicineList.add(medicines[i]);
            }
        }
    }

}
