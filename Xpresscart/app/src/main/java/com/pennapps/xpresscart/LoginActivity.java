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

public class LoginActivity extends AppCompatActivity {

    private static Button loginButton;
    private static TextView username, password;
    private NessieClient nessieClient = NessieClient.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.login_button);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        nessieClient.setAPIKey("73f7573087e61516c5fc1304f6b9e985");

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                try{
                if (username.getText().toString().equals("abc") && password.getText().toString().equals("abc"))
                {
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                }
                catch (Exception e){
                    e.printStackTrace();
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


        return super.onOptionsItemSelected(item);
    }


}
