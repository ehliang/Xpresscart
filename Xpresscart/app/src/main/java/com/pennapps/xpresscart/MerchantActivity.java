package com.pennapps.xpresscart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.reimaginebanking.api.java.NessieClient;
import com.reimaginebanking.api.java.NessieException;
import com.reimaginebanking.api.java.NessieResultsListener;
import com.reimaginebanking.api.java.models.Merchant;

import java.util.ArrayList;

public class MerchantActivity extends AppCompatActivity {

    private NessieClient nessieClient = NessieClient.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);
        nessieClient.setAPIKey("73f7573087e61516c5fc1304f6b9e985");
        nessieClient.getMerchants(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result, NessieException e) {
                if (e == null) {
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    ArrayList<Merchant> merchants = (ArrayList<Merchant>) result;
                    for (Merchant merc : merchants) {
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
        getMenuInflater().inflate(R.menu.menu_merchant, menu);
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
}
