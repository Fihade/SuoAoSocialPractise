package com.matrixxun.producttour;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

/**
 * Created by swaggymiller on 2017/7/22.
 */
public class MedicineActivity extends AppCompatActivity {

    public static byte string;
    public static final String MEDICINE_NAME = "medicine_name";
    public static final String MEDICINE_IMAGE_ID = "medicine_image_id";
    private BluetoothAdapter mBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        ImageView medicineImageView = (ImageView) findViewById(R.id.medicine_image_view);
        TextView medicineContentText = (TextView) findViewById(R.id.medicine_content_text);

        Intent intent = getIntent();
        String medicineName = intent.getStringExtra(MEDICINE_NAME);
        int medicineImageId = intent.getIntExtra(MEDICINE_IMAGE_ID, 0);

        Glide.with(this).load(medicineImageId).into(medicineImageView);
        String medicineContent = generateMedicineContent(medicineName);
        medicineContentText.setText(medicineContent);

        Button button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                /** 打开蓝牙 **/
                if (!mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.enable();
                }

                Intent intent = new Intent();
                intent.setClass(MedicineActivity.this,Two.class);
                startActivity(intent);

            }
        });
    }

    private String generateMedicineContent(String medicineName) {
        StringBuilder medicineContent = new StringBuilder();
        String [] content = {" 1.有高血压、心脏病、肝病、糖尿病、肾病等慢性病严重者不得使用；\n 2.儿童、孕妇、哺乳期妇女、年老体弱者不得使用；\n 3.对酒精过敏者禁用，过敏体质者慎用；\n 4.服药后不得驾驶机、车、船，从事高空作业、机械作业及操作紧密仪器。",
                " 1.特异性体质、有过敏史或哮喘病者禁用；\n 2.妊娠期妇女禁用；\n 3.10岁以下儿童患流感或水痘者禁用；\n 4.有出血性溃疡病疾病或其他活动性出血者禁用；\n 5.血友病或血小板减少病者禁用。",
                " 1.孕妇禁用。",
                " 1.低血压者慎用；\n 2.对庸香、冰片过敏者禁用。",
                " 1.芝麻过敏者禁用；\n 2.用药部位如有烧灼感、瘙痒、红肿应停止用药，以清水洗净。",
                " 1.孕妇忌用，有过敏史者、严重心律失常者禁用；\n 2.用药过量或中毒时忌用；\n 3.女性在月经期禁用；\n 4.严重的肝肾功能、有血液方面的疾病者禁用；\n 5.颅内出血之类者禁用。",
                " 1.过敏者、本品性状发生改变时禁用；\n 2.用药后局部出现皮疹等过敏变现者禁用；\n 3.对黄蜂等蛰伤或有全身症状者，应去医院就诊。",
                " 1.婴儿、儿童慎用；\n 2.真菌性或病毒性过敏者和对其他皮质类固醇过敏者禁用。",
                " 1.严重肝肾功能不全者禁用；\n 2.心脏病、高血压、甲状腺疾病、糖尿病、前列腺肥大、青光眼、抑郁症、哮喘等患者禁用；\n 3.老年人、孕妇及哺乳期妇女、运动员、过敏者禁用；\n 4.服用降压药或二周内服用过用于抗抑郁及治疗帕金森氏病者禁用。",
                " 1.孕妇、老人、过敏者慎用。",
                " 1.伴有原发性高血压、心脏病、糖尿病、甲亢、青光眼、前列腺肥大引起的排尿困难，肺气肿胀者禁用；\n 2.因吸烟肺气肿、哮喘引起的慢性咳嗽及痰多粘稠患者慎用；\n 3.肝肾功能不全者慎用，妊娠期或哺乳期妇女禁用。",
                " 1.严重肝肾功能不全者禁用；\n 2.心脏病、高血压、甲状腺疾病、糖尿病、前列腺肥大、青光眼、抑郁症以及哮喘等患者禁用；\n 3.老人、孕妇及哺乳期妇女、运动员、过敏者禁用。",
                " 1.儿童、孕妇、哺乳期妇女、年老体弱及脾虚便溏者禁用；\n 2.风寒感冒者慎用；\n 3.高血压、心脏病、肝病、糖尿病、肾病等慢性病严重者禁用。",
                " 1.对头孢菌素类抗生素有过敏史者禁用；\n 2.孕妇、哺乳期妇女、6个月以下儿童禁用；\n 3.有青霉素过敏史、本人及直系亲属有过这种过敏体质者禁用；\n 3.肾功能不全、经口给药困难或非经口摄取营养患病者禁用；\n 4.全身恶液质状态患者、假膜性肠炎患者禁用。",
                " 1.婴儿、糖尿病患儿、脾虚易腹泻者禁用；\n 2.风寒感冒者不适用；\n 3.过敏者禁用；\n 4.本品性状改变时禁用。",
                " 1.过敏体质者禁用；\n 2.本品性状改变时禁用。"};
        switch (medicineName) {
            case "藿香正气水":
                medicineContent.append(content[0]);
                string = '1';
                break;
            case "阿司匹林":
                medicineContent.append(content[1]);
                string = '2';
                break;
            case "牛黄解毒丸":
                medicineContent.append(content[2]);
                string = '3';
                break;
            case "速效救心丸":
                medicineContent.append(content[3]);
                string = '4';
                break;
            case "烧伤膏":
                medicineContent.append(content[4]);
                string = '5';
                break;
            case "云南白药":
                medicineContent.append(content[5]);
                string = '6';
                break;
            case "白树油":
                medicineContent.append(content[6]);
                string = '7';
                break;
            case "醋酸氟轻松乳膏":
                medicineContent.append(content[7]);
                string = '1';
                break;
            case "酚麻美敏片":
                medicineContent.append(content[8]);
                string = '0';
                break;
            case "复方丹参片":
                medicineContent.append(content[9]);
                string = '6';
                break;
            case "白加黑":
                medicineContent.append(content[10]);
                string = '4';
                break;
            case "美扑伪麻片":
                medicineContent.append(content[11]);
                string = '3';
                break;
            case "双黄连口服液":
                medicineContent.append(content[12]);
                string = '2';
                break;
            case "头孢克圬片":
                medicineContent.append(content[13]);
                string = '1';
                break;
            case "小儿感冒颗粒":
                medicineContent.append(content[14]);
                string = '7';
                break;
            case "小儿七新茶颗粒":
                medicineContent.append(content[15]);
                string = '6';
                break;
            default:
                break;
        }
        return medicineContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
