package islamic.ebadaty;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ReportPreferences extends PreferenceActivity {
	SharedPreferences settings;
	Editor editor;
	boolean[] results;
	boolean salah_gama3a, salah_sunna, sawm, quran, quran_hefz;

	public static SharedPreferences pref_day1, pref_day2, pref_day3, pref_day4,
			pref_day5, pref_day6, pref_day7;

	public static boolean[] ResultsOfDayOne;
	public static boolean[] ResultsOfDayTwo;
	public static boolean[] ResultsOfDayThree;
	public static boolean[] ResultsOfDayFour;
	public static boolean[] ResultsOfDayFive;
	public static boolean[] ResultsOfDaySix;
	public static boolean[] ResultsOfDaySeven;

	public static NotificationManager ReportDoneNotfi;
//	 private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setTheme(R.style.fillReport);
		getWindow().setBackgroundDrawableResource(R.drawable.bg_main_simple);
		getListView().setBackgroundColor(Color.TRANSPARENT);
		getListView().setCacheColorHint(Color.TRANSPARENT);
		addPreferencesFromResource(R.xml.pref);
		
/*    	AdRequest adRequest = new AdRequest.Builder().build();
//     	AdRequest adRequest = new AdRequest.Builder().addTestDevice("39404A261727478EC8049EE6B039EABC").build();
    	
        // Create the interstitial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-9911896226381783/4251730552");

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);*/
//		Main.addReport();
		

		
		results = new boolean[5];
	}



	public void resetPreferences() {
		settings = PreferenceManager.getDefaultSharedPreferences(this);
		editor = settings.edit();
		editor.clear();
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(menu.NONE, 0, 0, getResources().getString(R.string.save))
				.setIcon(android.R.drawable.ic_menu_save);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// On clicking save menu item:
		switch (item.getItemId()) {
		case 0:
			// increment report number and store data for this report
			SharedPreferences notifyData = getSharedPreferences("notify", 0);
			int notificationDay = notifyData.getInt("notifyKey", 0);
			SharedPreferences SelectedDays = getSharedPreferences(
					"SelectedDays", 0);
			int selectedDays = SelectedDays.getInt("SELECTEDDAYS", 0);

			storeData(notificationDay);

			if (notificationDay == 3 && selectedDays == 3) {
				//stop service
				showReportFinishedNotification();
				resetReportState();

			} else if (notificationDay == 5 && selectedDays == 5) {
				//stop service
				showReportFinishedNotification();
				resetReportState();
			} else if (notificationDay == 7 && selectedDays == 7) {
				//stop service
				showReportFinishedNotification();
				resetReportState();
			}

			// saving
			Toast.makeText(ReportPreferences.this, R.string.save_confirm,
							Toast.LENGTH_LONG).show();
			// receiving result values:
			/*
			 * settings =
			 * PreferenceManager.getDefaultSharedPreferences(ReportPreferences
			 * .this); salah_gama3a = settings.getBoolean("salah_gama3a",
			 * false); results[0] = salah_gama3a; salah_sunna =
			 * settings.getBoolean("salah_sunna", false); results[1] =
			 * salah_sunna; sawm = settings.getBoolean("sawm", false);
			 * results[2] = sawm; quran = settings.getBoolean("quran", false);
			 * results[3] = quran; quran_hefz =
			 * settings.getBoolean("quran_hefz", false); results[4] =
			 * quran_hefz; calcResult();
			 */
			// ReportService.clearNotification(0);
			resetPreferences();
			// saving permanent data:

			break;
		default:
			break;
		}
		finish();
		return super.onOptionsItemSelected(item);
	}

	public void showReportFinishedNotification() {
/*		ReportDoneNotfi = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notify = new Notification(R.drawable.notify_done, ""
				+ getResources().getString(R.string.report_finished),
				System.currentTimeMillis());
		notify.flags = Notification.FLAG_AUTO_CANCEL;
		notify.defaults = Notification.DEFAULT_ALL;

		Context context = ReportPreferences.this;
		CharSequence title = ""
				+ getResources().getString(R.string.report_finished);
		CharSequence details = ""
				+ getResources().getString(R.string.report_view);
		Intent notifyIntent = new Intent(Intent.ACTION_MAIN);
		notifyIntent.setClass(ReportPreferences.this, ReportResults.class);

		PendingIntent pending = PendingIntent.getActivity(context, 0,
				notifyIntent, 0);
		// notify.sound = Uri.parse("android.resource//com.example.motaba3a/" +
		// R.raw.beep);
		notify.setLatestEventInfo(context, title, details, pending);
		ReportDoneNotfi.notify(1, notify);*/

	}

	public void storeData(int notificationDay) {
		/*
		 * this method stores the data in different sharedPreferences according
		 * to report's day number.
		 */
		settings = PreferenceManager
				.getDefaultSharedPreferences(ReportPreferences.this);
		ResultsOfDayOne = new boolean[5];
		ResultsOfDayTwo = new boolean[5];
		ResultsOfDayThree = new boolean[5];
		ResultsOfDayFour = new boolean[5];
		ResultsOfDayFive = new boolean[5];
		ResultsOfDaySix = new boolean[5];
		ResultsOfDaySeven = new boolean[5];

		Log.i("pref", "in method startDayOf day");

		switch (notificationDay) {
		case 1:

			pref_day1 = getSharedPreferences("pref_day1", 0);
			Editor editorDay1 = pref_day1.edit();
			// copying from default preferences to day preferences
			editorDay1.putBoolean("row1_salah_gama3a",
					settings.getBoolean("row1_salah_gama3a", false));
			editorDay1.putBoolean("row2_salah_sunna",
					settings.getBoolean("row2_salah_sunna", false));
			editorDay1.putBoolean("row3_salah_qeyam",
					settings.getBoolean("row3_salah_qeyam", false));
			editorDay1.putBoolean("row4_salah_wetr",
					settings.getBoolean("row4_salah_wetr", false));
			editorDay1.putBoolean("row5_salah_doha",
					settings.getBoolean("row5_salah_doha", false));
			editorDay1.putBoolean("row6_quran_qera2a",
					settings.getBoolean("row6_quran_qera2a", false));
			editorDay1.putBoolean("row7_quran_hefz",
					settings.getBoolean("row7_quran_hefz", false));
			editorDay1.putBoolean("row8_zekr_saba7_masa2",
					settings.getBoolean("row8_zekr_saba7_masa2", false));
			editorDay1.putBoolean("row9_zekr_nom_estykaz",
					settings.getBoolean("row9_zekr_nom_estykaz", false));
			editorDay1.putBoolean("row10_zekr_afterSalah",
					settings.getBoolean("row10_zekr_afterSalah", false));
			editorDay1.putBoolean("row11_sawm",
					settings.getBoolean("row11_sawm", false));
			editorDay1.commit();

			break;
		case 2:
			pref_day2 = getSharedPreferences("pref_day2", 0);
			Editor editorDay2 = pref_day2.edit();

			editorDay2.putBoolean("row1_salah_gama3a",
					settings.getBoolean("row1_salah_gama3a", false));
			editorDay2.putBoolean("row2_salah_sunna",
					settings.getBoolean("row2_salah_sunna", false));
			editorDay2.putBoolean("row3_salah_qeyam",
					settings.getBoolean("row3_salah_qeyam", false));
			editorDay2.putBoolean("row4_salah_wetr",
					settings.getBoolean("row4_salah_wetr", false));
			editorDay2.putBoolean("row5_salah_doha",
					settings.getBoolean("row5_salah_doha", false));
			editorDay2.putBoolean("row6_quran_qera2a",
					settings.getBoolean("row6_quran_qera2a", false));
			editorDay2.putBoolean("row7_quran_hefz",
					settings.getBoolean("row7_quran_hefz", false));
			editorDay2.putBoolean("row8_zekr_saba7_masa2",
					settings.getBoolean("row8_zekr_saba7_masa2", false));
			editorDay2.putBoolean("row9_zekr_nom_estykaz",
					settings.getBoolean("row9_zekr_nom_estykaz", false));
			editorDay2.putBoolean("row10_zekr_afterSalah",
					settings.getBoolean("row10_zekr_afterSalah", false));
			editorDay2.putBoolean("row11_sawm",
					settings.getBoolean("row11_sawm", false));
			editorDay2.commit();
			break;
		case 3:
			pref_day3 = getSharedPreferences("pref_day3", 0);
			Editor editorDay3 = pref_day3.edit();

			editorDay3.putBoolean("row1_salah_gama3a",
					settings.getBoolean("row1_salah_gama3a", false));
			editorDay3.putBoolean("row2_salah_sunna",
					settings.getBoolean("row2_salah_sunna", false));
			editorDay3.putBoolean("row3_salah_qeyam",
					settings.getBoolean("row3_salah_qeyam", false));
			editorDay3.putBoolean("row4_salah_wetr",
					settings.getBoolean("row4_salah_wetr", false));
			editorDay3.putBoolean("row5_salah_doha",
					settings.getBoolean("row5_salah_doha", false));
			editorDay3.putBoolean("row6_quran_qera2a",
					settings.getBoolean("row6_quran_qera2a", false));
			editorDay3.putBoolean("row7_quran_hefz",
					settings.getBoolean("row7_quran_hefz", false));
			editorDay3.putBoolean("row8_zekr_saba7_masa2",
					settings.getBoolean("row8_zekr_saba7_masa2", false));
			editorDay3.putBoolean("row9_zekr_nom_estykaz",
					settings.getBoolean("row9_zekr_nom_estykaz", false));
			editorDay3.putBoolean("row10_zekr_afterSalah",
					settings.getBoolean("row10_zekr_afterSalah", false));
			editorDay3.putBoolean("row11_sawm",
					settings.getBoolean("row11_sawm", false));
			editorDay3.commit();
			break;
		case 4:
			pref_day4 = getSharedPreferences("pref_day4", 0);
			Editor editorDay4 = pref_day4.edit();

			editorDay4.putBoolean("row1_salah_gama3a",
					settings.getBoolean("row1_salah_gama3a", false));
			editorDay4.putBoolean("row2_salah_sunna",
					settings.getBoolean("row2_salah_sunna", false));
			editorDay4.putBoolean("row3_salah_qeyam",
					settings.getBoolean("row3_salah_qeyam", false));
			editorDay4.putBoolean("row4_salah_wetr",
					settings.getBoolean("row4_salah_wetr", false));
			editorDay4.putBoolean("row5_salah_doha",
					settings.getBoolean("row5_salah_doha", false));
			editorDay4.putBoolean("row6_quran_qera2a",
					settings.getBoolean("row6_quran_qera2a", false));
			editorDay4.putBoolean("row7_quran_hefz",
					settings.getBoolean("row7_quran_hefz", false));
			editorDay4.putBoolean("row8_zekr_saba7_masa2",
					settings.getBoolean("row8_zekr_saba7_masa2", false));
			editorDay4.putBoolean("row9_zekr_nom_estykaz",
					settings.getBoolean("row9_zekr_nom_estykaz", false));
			editorDay4.putBoolean("row10_zekr_afterSalah",
					settings.getBoolean("row10_zekr_afterSalah", false));
			editorDay4.putBoolean("row11_sawm",
					settings.getBoolean("row11_sawm", false));
			editorDay4.commit();
			break;
		case 5:
			pref_day5 = getSharedPreferences("pref_day5", 0);
			Editor editorDay5 = pref_day5.edit();

			editorDay5.putBoolean("row1_salah_gama3a",
					settings.getBoolean("row1_salah_gama3a", false));
			editorDay5.putBoolean("row2_salah_sunna",
					settings.getBoolean("row2_salah_sunna", false));
			editorDay5.putBoolean("row3_salah_qeyam",
					settings.getBoolean("row3_salah_qeyam", false));
			editorDay5.putBoolean("row4_salah_wetr",
					settings.getBoolean("row4_salah_wetr", false));
			editorDay5.putBoolean("row5_salah_doha",
					settings.getBoolean("row5_salah_doha", false));
			editorDay5.putBoolean("row6_quran_qera2a",
					settings.getBoolean("row6_quran_qera2a", false));
			editorDay5.putBoolean("row7_quran_hefz",
					settings.getBoolean("row7_quran_hefz", false));
			editorDay5.putBoolean("row8_zekr_saba7_masa2",
					settings.getBoolean("row8_zekr_saba7_masa2", false));
			editorDay5.putBoolean("row9_zekr_nom_estykaz",
					settings.getBoolean("row9_zekr_nom_estykaz", false));
			editorDay5.putBoolean("row10_zekr_afterSalah",
					settings.getBoolean("row10_zekr_afterSalah", false));
			editorDay5.putBoolean("row11_sawm",
					settings.getBoolean("row11_sawm", false));
			editorDay5.commit();
			break;
		case 6:
			pref_day6 = getSharedPreferences("pref_day6", 0);
			Editor editorDay6 = pref_day6.edit();

			editorDay6.putBoolean("row1_salah_gama3a",
					settings.getBoolean("row1_salah_gama3a", false));
			editorDay6.putBoolean("row2_salah_sunna",
					settings.getBoolean("row2_salah_sunna", false));
			editorDay6.putBoolean("row3_salah_qeyam",
					settings.getBoolean("row3_salah_qeyam", false));
			editorDay6.putBoolean("row4_salah_wetr",
					settings.getBoolean("row4_salah_wetr", false));
			editorDay6.putBoolean("row5_salah_doha",
					settings.getBoolean("row5_salah_doha", false));
			editorDay6.putBoolean("row6_quran_qera2a",
					settings.getBoolean("row6_quran_qera2a", false));
			editorDay6.putBoolean("row7_quran_hefz",
					settings.getBoolean("row7_quran_hefz", false));
			editorDay6.putBoolean("row8_zekr_saba7_masa2",
					settings.getBoolean("row8_zekr_saba7_masa2", false));
			editorDay6.putBoolean("row9_zekr_nom_estykaz",
					settings.getBoolean("row9_zekr_nom_estykaz", false));
			editorDay6.putBoolean("row10_zekr_afterSalah",
					settings.getBoolean("row10_zekr_afterSalah", false));
			editorDay6.putBoolean("row11_sawm",
					settings.getBoolean("row11_sawm", false));
			editorDay6.commit();
			break;
		case 7:
			pref_day7 = getSharedPreferences("pref_day7", 0);
			Editor editorDay7 = pref_day7.edit();

			editorDay7.putBoolean("row1_salah_gama3a",
					settings.getBoolean("row1_salah_gama3a", false));
			editorDay7.putBoolean("row2_salah_sunna",
					settings.getBoolean("row2_salah_sunna", false));
			editorDay7.putBoolean("row3_salah_qeyam",
					settings.getBoolean("row3_salah_qeyam", false));
			editorDay7.putBoolean("row4_salah_wetr",
					settings.getBoolean("row4_salah_wetr", false));
			editorDay7.putBoolean("row5_salah_doha",
					settings.getBoolean("row5_salah_doha", false));
			editorDay7.putBoolean("row6_quran_qera2a",
					settings.getBoolean("row6_quran_qera2a", false));
			editorDay7.putBoolean("row7_quran_hefz",
					settings.getBoolean("row7_quran_hefz", false));
			editorDay7.putBoolean("row8_zekr_saba7_masa2",
					settings.getBoolean("row8_zekr_saba7_masa2", false));
			editorDay7.putBoolean("row9_zekr_nom_estykaz",
					settings.getBoolean("row9_zekr_nom_estykaz", false));
			editorDay7.putBoolean("row10_zekr_afterSalah",
					settings.getBoolean("row10_zekr_afterSalah", false));
			editorDay7.putBoolean("row11_sawm",
					settings.getBoolean("row11_sawm", false));
			editorDay7.commit();
			break;
		default:
			break;
		}
	}

	public void resetReportState() {
		SharedPreferences reportState = getSharedPreferences("STATE", 0);
		Editor report = reportState.edit();
		report.clear();
		report.commit();
	}

	public static void resetAllPreferences() {
		Editor edit = pref_day1.edit();
		edit.clear();
		edit.commit();

		Editor edit2 = pref_day2.edit();
		edit2.clear();
		edit2.commit();

		Editor edit3 = pref_day3.edit();
		edit3.clear();
		edit3.commit();

		/*
		 * Editor edit4 = pref_day4.edit(); edit4.clear(); edit4.commit();
		 * 
		 * Editor edit5 = pref_day5.edit(); edit5.clear(); edit5.commit();
		 * 
		 * Editor edit6 = pref_day6.edit(); edit6.clear(); edit6.commit();
		 * 
		 * Editor edit7 = pref_day7.edit(); edit7.clear(); edit7.commit();
		 */
	}
	

    


/*    // Invoke displayInterstitial() when you are ready to display an interstitial.
    public void displayInterstitial() {
      if (interstitial.isLoaded()) {
        interstitial.show();
      }
    }*/
}
