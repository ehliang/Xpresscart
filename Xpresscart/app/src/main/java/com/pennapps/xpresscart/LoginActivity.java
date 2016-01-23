package com.pennapps.xpresscart;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.reimaginebanking.api.java.NessieClient;
import com.reimaginebanking.api.java.NessieException;
import com.reimaginebanking.api.java.NessieResultsListener;
import com.reimaginebanking.api.java.models.Address;
import com.reimaginebanking.api.java.models.Customer;
import com.reimaginebanking.api.java.models.Merchant;

import java.util.ArrayList;

public class LoginActivity extends Activity {

    private static Button loginButton;
    private static TextView username, password;
    NessieClient nessieClient = NessieClient.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.login_button);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        nessieClient.setAPIKey("73f7573087e61516c5fc1304f6b9e985");
//        new login().execute("");
        nessieClient.getMerchants(new NessieResultsListener(){
            @Override
            public void onSuccess(Object result, NessieException e){
                if(e == null){
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    ArrayList<Merchant> merchants = (ArrayList<Merchant>) result;
                    for (Merchant merc : merchants){
                        Log.i("Merchant", merc.getName());
                    }
                } else {
                    //There was an error. Handle it here
                    Log.e("Error", e.toString());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private class login extends AsyncTask<String, Void, Void> {
//        Context c;
//        ProgressDialog dialog = ProgressDialog.show(activity.this, "", "Loading, Please wait...");
//
//        @Override
//        protected int doInBackground(String... params) {
//            try {
//                Boolean response = true;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return 0;
//        }
//
//        protected void onPreExecute() {
//            dialog.show();
//        }
//
//        protected void onPostExecute(int result) {
//            if (dialog != null)
//                dialog.dismiss();
//            if (result) {
//
//            } else {
//                Intent myIntent = new Intent(c, MainActivity.class);
//                startActivity(myIntent);
//            }
//
//
//        }
//
//    }
}
