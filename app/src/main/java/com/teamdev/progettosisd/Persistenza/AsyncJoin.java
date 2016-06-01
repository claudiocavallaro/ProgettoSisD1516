package com.teamdev.progettosisd.Persistenza;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.teamdev.progettosisd.Activity.MainActivity;
import com.teamdev.progettosisd.Network.Peer;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by claud on 01/06/2016.
 */
public class AsyncJoin extends AsyncTask<Void, Void, Void> {

    private MainActivity mainActivity;
    private static Context context;
    private ProgressDialog progressDialog;

    public AsyncJoin(MainActivity mainActivity){
        this.setMainActivity(mainActivity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Join in corso");
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

        String name2 = "P2";
        Peer peer2 = new Peer(localhost, port1, name2);
        peer2.startListening();

        InetAddress gigi = null;
        try {
            gigi = InetAddress.getByName("5.169.104.159");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        peer2.join(gigi, port1);
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        progressDialog.setMessage("JOIN in corso");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        AsyncJoin.context = context;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}
