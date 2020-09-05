package com.example.asynchorniseprogress;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class Mytask extends AsyncTask<Void,Integer,String> {

    Context context;
    TextView mname;
    Button mbtn;
    ProgressDialog progressDialog;

    public Mytask(Context context, TextView mname, Button mbtn) {
        this.context = context;
        this.mname = mname;
        this.mbtn = mbtn;
    }

    @Override
    protected void onPreExecute() {
       progressDialog=new ProgressDialog(context);
       progressDialog.setTitle("Downloading");
       progressDialog.setMax(100);
       progressDialog.setProgress(0);
       progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {

        int i=0;
        synchronized (this){
            while (i<=100){
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "download completed";
    }
    @Override
    protected void onPostExecute(String s) {
        mname.setText(s);
        mbtn.setEnabled(true);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mname.setText("download in progress");
        int progress=values[0];
        progressDialog.setProgress(progress);
    }


}
