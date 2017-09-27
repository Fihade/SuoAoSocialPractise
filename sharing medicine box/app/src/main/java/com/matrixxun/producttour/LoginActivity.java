package com.matrixxun.producttour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by swaggymiller on 2017/7/19.
 */

public class LoginActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        //checkShowTutorial();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button bt2=(Button)findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }

//    private void checkShowTutorial(){
//        int oldVersionCode = PrefConstants.getAppPrefInt(this, "version_code");
//        int currentVersionCode = SAppUtil.getAppVersionCode(this);
//        if(currentVersionCode>oldVersionCode){
//            startActivity(new Intent(LoginActivity.this,MainActivity.class));
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//            PrefConstants.putAppPrefInt(this, "version_code", currentVersionCode);
//        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


}
