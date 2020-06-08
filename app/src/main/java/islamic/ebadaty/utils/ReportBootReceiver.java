package islamic.ebadaty.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class ReportBootReceiver extends BroadcastReceiver {
    public static final String TAG = "ReportEB";
    SharedPreferences defaultPrefs;
    int selectedHour, selectedMin;
    @Override
    public void onReceive(Context context, Intent intent) {
 //       Log.d(TAG, "SiamBootReceiver onReceive");
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
  //          Log.d(TAG, "SiamBootReceiver onReceive action.BOOT_COMPLETED");
            defaultPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            selectedHour = defaultPrefs.getInt("PICKER_HOUR", 21);
            selectedMin = defaultPrefs.getInt("PICKER_MIN",0);

  //          Log.d(TAG, "SiamBootReceiver Hour: " + selectedHour);
  //          Log.d(TAG, "SiamBootReceiver Min: " + selectedMin);

//            MainActivity.setAlarmOn(context, selectedHour, selectedMin);
        }
    }


}
