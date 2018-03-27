package com.example.myspatialite_android;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.utilities.*;
import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public  void onClick(View v){
        if(v.getId()==R.id.btn_install_to_application){
            try { ActivityHelper.showAlert(this,
                    this.getFilesDir().toString());
                AssetHelper.CopyAsset(this,
                        ActivityHelper.getPath(this, false),
                        getString(R.string.test_db));
            }catch(IOException e){
                ActivityHelper.showAlert(this,"Failed to copy db to application");
            }
        }
       else if(v.getId()==R.id.btn_install_to_external){
            try {
                ActivityHelper.showAlert(this,
                        this.getExternalFilesDir(null).toString());
                AssetHelper.CopyAsset(this,
                        ActivityHelper.getPath(this, true),
                        getString(R.string.test_db));
            }catch(IOException e){
                ActivityHelper.showAlert(this,"Failed to copy db to external");
            }
        }
       else if(v.getId()==R.id.btnbrowsedata){
           Intent myIntent = new Intent(this, TableListActivity.class);
           startActivity(myIntent);
       }
    }
}
