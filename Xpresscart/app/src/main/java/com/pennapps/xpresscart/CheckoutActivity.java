package com.pennapps.xpresscart;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.reimaginebanking.api.java.NessieClient;
import com.reimaginebanking.api.java.NessieException;
import com.reimaginebanking.api.java.NessieResultsListener;
import com.reimaginebanking.api.java.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends Activity {

    private ArrayList<ScanObject> values = new ArrayList<>();
    private NessieClient nessieClient = NessieClient.getInstance();
    private String accountid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        final RadioGroup accountGroup = (RadioGroup)findViewById(R.id.accounts);
        Button pay = (Button)findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Success", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        nessieClient.setAPIKey("73f7573087e61516c5fc1304f6b9e985");
        nessieClient.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object o, NessieException e) {
                if (e == null) {
                    //There is no error, do whatever you need here.
                    // Cast the result object to the type that you are requesting and you are good to go
                    ArrayList<Customer> customers = (ArrayList<Customer>) o;
                    List<String> accountdata = customers.get(0).getAccounts();
                    accountid = customers.get(0).get_id();
                    String accountid2 = customers.get(1).get_id();
                    ((RadioButton) accountGroup.getChildAt(0)).setText(accountid);
                    ((RadioButton) accountGroup.getChildAt(1)).setText(accountid2);
                } else {
                    //There was an error. Handle it here
                }
            }
        });

//        nessieClient.createPurchase("56241a13de4bf40b171127fe", purchase, new NessieResultsListener() {
//            @Override
//            public void onSuccess(Object o, NessieException e) {
//
//            }
//        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_checkout, menu);
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
