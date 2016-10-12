package com.lsh.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;
    private List<Cinema> mList;
    private MyAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mLv= (ListView) findViewById(R.id.lv_content);
        mList=new ArrayList<>();

        new LoadJsonTask(new LoadJsonTask.OnGetJsonResultListener() {
            @Override
            public void OnGetJsonResult(List<Cinema> result) {
                myadapter=new MyAdapter(result);
                mLv.setAdapter(myadapter);
            }
        }).execute(Constant.PATH);
    }
}


