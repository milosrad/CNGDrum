package cubes.cngdrum.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cubes.cngdrum.R;

/**
 * Created by User on 30.6.2016.
 */
public class PhoneCallActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);


        PhoneCallListener phoneListener = new PhoneCallListener();
        TelephonyManager telephonyManager = (TelephonyManager) this
                .getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        call();
    }

    private void call() {
        String phonenumber=getIntent().getStringExtra("phonenumber");
        Intent in=new Intent(Intent.ACTION_CALL, Uri.parse(phonenumber));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R..menu_main, menu);
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
    } */



    private class PhoneCallListener extends PhoneStateListener {

        private boolean isPhoneCalling = false;

        String LOG_TAG = "LOGGING 123";

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                // phone ringing
                Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
            }

            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
                // active
                Log.i(LOG_TAG, "OFFHOOK");

                isPhoneCalling = true;
            }

            if (TelephonyManager.CALL_STATE_IDLE == state) {
                // run when class initial and phone call ended,
                // need detect flag from CALL_STATE_OFFHOOK
                Log.i(LOG_TAG, "IDLE");

                if (isPhoneCalling) {

                    Log.i(LOG_TAG, "restart app");

                    // restart app
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(
                                    getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                    isPhoneCalling = false;
                }

            }
        }
    }
}
