package com.teamdev.progettosisd.Persistenza;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.teamdev.progettosisd.Activity.ActivityListening;
import com.teamdev.progettosisd.Activity.MainActivity;
import com.teamdev.progettosisd.Network.Peer;

/**
 * Created by claud on 01/06/2016.
 */
public class AsyncStart extends AsyncTask<Void, Void, Void> {

    private MainActivity mainActivity;
    private static Context context;
    private ProgressDialog progressDialog;

    public AsyncStart(MainActivity mainActivity){
        this.setMainActivity(mainActivity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Creazione rete in corso");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        InetAddress localhost = null;
        try {
            localhost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        int port1 = 8090;
        String name1 = "P1";
        Peer peer1 = new Peer(localhost, port1, name1);
        peer1.startListening();
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        progressDialog.setMessage("Creazione rete in corso");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();

        Intent i = new Intent(mainActivity, ActivityListening.class);
        mainActivity.finish();
        mainActivity.startActivity(i);

    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        AsyncStart.context = context;
    }

}
