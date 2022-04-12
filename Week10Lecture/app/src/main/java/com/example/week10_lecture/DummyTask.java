package com.example.week10_lecture;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class DummyTask extends AsyncTask<Void, Integer, Void> {
    ProgressDialog progressDialog;
    Context context;

    public DummyTask(ProgressDialog progressDialog, Context context){
        this.progressDialog = progressDialog;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i++){
            try {
                publishProgress(i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onCancelled(Void unused) {
        super.onCancelled(unused);
        progressDialog.dismiss();
    }


}
