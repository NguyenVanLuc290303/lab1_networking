package com.example.silde1_androidnetworking;

import android.os.AsyncTask;
import android.util.Log;

public class Chaynen extends AsyncTask<Integer,Integer,String> {
    @Override
    protected String doInBackground(Integer... integers) {

        for (int i = 0 ; i < integers[0] ; i++){
            Log.d("luong","" + i);
            publishProgress(i);
        }
        return "xong";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("luong ngam", "onPostExecute: " + s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d("chay", "onProgressUpdate: " + values[0]);
    }
}
