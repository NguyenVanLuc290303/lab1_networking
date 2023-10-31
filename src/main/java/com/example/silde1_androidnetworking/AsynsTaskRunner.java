package com.example.silde1_androidnetworking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

public class AsynsTaskRunner extends AsyncTask<String ,String , String> {

    private String resp;
    ProgressDialog dialog;
    EditText ed_time;
    Context context;

    public AsynsTaskRunner(Context context, EditText ed_time){
        this.ed_time = ed_time;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context,"Progess" ,"wtatingfor" + ed_time.getText().toString());
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("Sleeping");
        try {
            int time  = Integer.parseInt(strings[0] )  * 1000;
            Thread.sleep(time);
            resp = strings[0];
        } catch (InterruptedException e) {
            e.printStackTrace();
            resp = e.getMessage();
        }

        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (dialog.isShowing()){
            dialog.dismiss();
        }

    }
}
