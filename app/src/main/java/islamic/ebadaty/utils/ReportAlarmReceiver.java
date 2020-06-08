package islamic.ebadaty.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;

import islamic.ebadaty.MainActivity;
import islamic.ebadaty.R;


public class ReportAlarmReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "Ebadaty";
    public String notificationHeadline = "";
    public String notificationSubtitle = "";

    NotificationCompat.Builder builder;
    Context mContext;
    SharedPreferences defaultPrefs;
    public  final String TAG = "ReportEB";

    int selectedHour, selectedMin;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Report onReceive");
        mContext = context;
 //       setPrefValues();

    }





    /*
     * set user prefs
     */
    private void setPrefValues(){
/*
        defaultPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        isMonday    = defaultPrefs.getBoolean("MONDAY", true);
        isThursday  = defaultPrefs.getBoolean("THURSDAY", true);
        is13        = defaultPrefs.getBoolean("DAY13", true);
        is14        = defaultPrefs.getBoolean("DAY14", true);
        is15        = defaultPrefs.getBoolean("DAY15", true);
        */

    }



    public void showNotification(String aSiamReminder, String aReason, Context context) {
   //     Log.d(TAG, "showNotification ");


        String shareText = aSiamReminder + " - " + aReason + ".\n" +
                            "تم التذكير بواسطة تطبيق (منبه الصيام) متوفر فى جوجل بلاي:" + "\n" +
                            "https://play.google.com/store/apps/details?id=iLighTech.Siam";
        Intent intentShare = new Intent();
        intentShare.setAction(Intent.ACTION_SEND);
        intentShare.putExtra(Intent.EXTRA_TEXT, shareText);
        intentShare.setType("text/plain");
        Intent shareIntent = Intent.createChooser(intentShare, null);

        Intent intentMain = new Intent(mContext, MainActivity.class);

        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intentMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntentShare = PendingIntent.getActivity(mContext, 0,
                shareIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pendingIntentMain = PendingIntent.getActivity(mContext, 0,
                intentMain, PendingIntent.FLAG_UPDATE_CURRENT);

        builder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_ebadaty)
                .setContentTitle(aSiamReminder)
                .setDefaults(Notification.DEFAULT_ALL)
                .setTicker(aSiamReminder)
                .setContentText(aReason)
//                .setVibrate(new long[]{ 600, 1000, 600})
                .setContentIntent(pendingIntentMain)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(false)
//                .setSound(soundUri)
/*                .addAction(android.R.drawable.ic_menu_share,
                        context.getResources().getString(R.string.shareNotification),
                        pendingIntentShare)*/
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = mContext.getSystemService(NotificationManager.class);

            CharSequence name = "MenbehSiam";
            String description = "Siam Alarm";

            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);
            mChannel.setDescription(description);
            mChannel.setLightColor(Color.BLUE);
            mChannel.enableLights(true);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{ 600, 1000, 600});
/*            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            mChannel.setSound(soundUri, audioAttributes);*/
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(mChannel);
            }


        }
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mContext.getApplicationContext());
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());
    }


}
