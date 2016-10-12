package com.lsh.test;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LSH on 2016/10/12.
 */

public class LoadJsonTask extends AsyncTask<String,Void,List<Cinema>> {
    List<Cinema> mList;

    /*
      *接口回调
    */
    public interface OnGetJsonResultListener{
        void OnGetJsonResult(List<Cinema> result);
    }
    private OnGetJsonResultListener mListener;
    public LoadJsonTask(OnGetJsonResultListener listener){
        this.mListener=listener;
    }


    @Override
    protected List<Cinema> doInBackground(String... strings) {
        byte[] data=HttpUtil.loadJson(strings[0]);
        String json=new String(data);
        try {
            JSONObject obj=new JSONObject(json);
            JSONArray array=obj.getJSONArray("cinemaList");
            mList=new ArrayList<>();
            for(int i=0;i<array.length();i++){
                JSONObject obj2=array.getJSONObject(i);
                String name = obj2.getString("name");
                String address = obj2.getString("address");
                String grade = obj2.getString("grade");
                String screenings = obj2.getString("screenings");
                Cinema cinema=new Cinema(name,address,screenings,grade);
                mList.add(cinema);
            }
            return mList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Cinema> cinemas) {
        super.onPostExecute(cinemas);
        if(cinemas!=null){
            mListener.OnGetJsonResult(cinemas);
        }
    }
}
