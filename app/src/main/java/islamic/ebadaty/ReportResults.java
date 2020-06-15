package islamic.ebadaty;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ReportResults extends ListActivity {
	  boolean []ResultsOfRow1 	= new boolean[7];
	  boolean []ResultsOfRow2	= new boolean[7]; 
	  boolean []ResultsOfRow3 	= new boolean[7];
	  boolean []ResultsOfRow4 	= new boolean[7];
	  boolean []ResultsOfRow5	= new boolean[7];
	  boolean []ResultsOfRow6	= new boolean[7];
	  boolean []ResultsOfRow7	= new boolean[7];
	  boolean []ResultsOfRow8	= new boolean[7];
	  boolean []ResultsOfRow9	= new boolean[7];
	  boolean []ResultsOfRow10	= new boolean[7];
	  boolean []ResultsOfRow11	= new boolean[7];
//		 private InterstitialAd interstitial;

	  SharedPreferences day1, day2, day3, day4, day5, day6, day7, userSelected; 
	  int UserSelectedDays;
	  Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

  /*  	AdRequest adRequest = new AdRequest.Builder().build();
    	
        // Create the interstitial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-9911896226381783/2495795753");

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);*/
        
		Toast.makeText(this, getResources().getString(R.string.resultsToast), Toast.LENGTH_LONG).show();
		setListAdapter(new ReportResultsAdapter(this,
						android.R.layout.simple_list_item_1,
						R.id.tv_reportName,
						getResources().getStringArray(R.array.report_names)));
			

		userSelected = getSharedPreferences("SelectedDays", 0);
		UserSelectedDays = userSelected.getInt("SELECTEDDAYS", 0);
			 
			
			 day1 = getSharedPreferences("pref_day1", 0);
			 day2 = getSharedPreferences("pref_day2", 0);
			 day3 = getSharedPreferences("pref_day3", 0);
			 day4 = getSharedPreferences("pref_day4", 0);
			 day5 = getSharedPreferences("pref_day5", 0);
			 day6 = getSharedPreferences("pref_day6", 0);
			 day7 = getSharedPreferences("pref_day7", 0);
			 
			 getResultOfRow(1);
			 getResultOfRow(2);
			 getResultOfRow(3);
			 getResultOfRow(4);
			 getResultOfRow(5);
			 getResultOfRow(6);
			 getResultOfRow(7);
			 getResultOfRow(8);
			 getResultOfRow(9);
			 getResultOfRow(10);
			 getResultOfRow(11);
			
			}
		
	private class ReportResultsAdapter extends ArrayAdapter<String>{

		public ReportResultsAdapter(Context context, int resource,
				int textViewResourceId, String[] objects) {
			super(context, resource, textViewResourceId, objects);
			// TODO Auto-generated constructor stub
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.report_results, parent, false);
			String []ReportItems = getResources().getStringArray(R.array.report_names);
			
			TextView separator = (TextView) row.findViewById(R.id.tv_separator);
			TextView report_tv = (TextView) row.findViewById(R.id.tv_reportName);
			ImageView report_image = (ImageView) row.findViewById(R.id.iv_reportImage);
			
			ProgressBar report_progress = (ProgressBar) row.findViewById(R.id.pb_reportProgress);
			switch (position) {
			case 0:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
				separator.setVisibility(View.VISIBLE);
				separator.setText(R.string.category_salah);
				report_tv.setText(R.string.row1_salah_gama3a);
				report_progress.setProgress(calcResults(ResultsOfRow1, UserSelectedDays));
				break;
			case 1:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
				report_tv.setText(R.string.row2_salah_sunna);
				report_progress.setProgress(calcResults(ResultsOfRow2, UserSelectedDays));
				break;
			case 2:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
				report_tv.setText(R.string.row3_salah_qeyam);
				report_progress.setProgress(calcResults(ResultsOfRow3, UserSelectedDays));
				break;
			case 3:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
				report_tv.setText(R.string.row4_salah_wetr);
				report_progress.setProgress(calcResults(ResultsOfRow4, UserSelectedDays));
				break;
			case 4:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
				report_tv.setText(R.string.row5_salah_doha);
				report_progress.setProgress(calcResults(ResultsOfRow5, UserSelectedDays));
				break;
			case 5:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_quran));
				separator.setVisibility(View.VISIBLE);
				separator.setText(R.string.category_quran);
				report_tv.setText(R.string.row6_quran_qera2a);
				report_progress.setProgress(calcResults(ResultsOfRow6, UserSelectedDays));
				break;
			case 6:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_quran));
				report_tv.setText(R.string.row7_quran_7efz);
				report_progress.setProgress(calcResults(ResultsOfRow7, UserSelectedDays));
				break;
			case 7:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_zekr));
				separator.setVisibility(View.VISIBLE);
				separator.setText(R.string.category_zekr);
				report_tv.setText(R.string.row8_zekr_saba7_masa2);
				report_progress.setProgress(calcResults(ResultsOfRow8, UserSelectedDays));
				break;
			case 8:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_zekr));
				report_tv.setText(R.string.row9_zekr_estykaz_nom);
				report_progress.setProgress(calcResults(ResultsOfRow9, UserSelectedDays));
				break;
			case 9:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_zekr));
				report_tv.setText(R.string.row10_zekr_afterSalah);
				report_progress.setProgress(calcResults(ResultsOfRow10, UserSelectedDays));
				break;
			case 10:
				report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_sawm));
				separator.setVisibility(View.VISIBLE);
				separator.setText(R.string.category_sawm);
				report_tv.setText(R.string.row11_sawm);
				report_progress.setProgress(calcResults(ResultsOfRow11, UserSelectedDays));
				break;
			default:
				break;
			}
			
			return row;
		}
		
		
	}
	
@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
	// TODO Auto-generated method stub
	super.onListItemClick(l, v, position, id);
	
	switch (position) {
	case 0:
		intent = new Intent(this, WorshipRewardOnly.class);
		intent.putExtra("TITLE", R.string.row1_salah_gama3a);
		intent.putExtra("DESC", R.raw.salah_gamaa);
		intent.putExtra("ICON", R.drawable.lv_salah);
		startActivity(intent);
		break;
	case 1:
		intent = new Intent(this, WorshipRewardContent.class);
		intent.putExtra("TITLE", R.string.row2_salah_sunna);
		intent.putExtra("DESC", R.raw.salah_sunna);
		intent.putExtra("FEQH", R.raw.salah_sunna_feqh);
		intent.putExtra("ICON", R.drawable.lv_salah);
		startActivity(intent);
		break;
	case 2: //qeyam still
		intent = new Intent(this, WorshipRewardContent.class);
		intent.putExtra("TITLE", R.string.row3_salah_qeyam);
		intent.putExtra("DESC", R.raw.salah_qeyam);
		intent.putExtra("FEQH", R.raw.salah_qeyam_feqh);
		intent.putExtra("ICON", R.drawable.lv_salah);
		startActivity(intent);
		break;
	case 3:
		intent = new Intent(this, WorshipRewardContent.class);
		intent.putExtra("TITLE", R.string.row4_salah_wetr);
		intent.putExtra("DESC", R.raw.salah_wetr);
		intent.putExtra("FEQH", R.raw.salah_wetr_feqh);
		intent.putExtra("ICON", R.drawable.lv_salah);
		startActivity(intent);
		break;
	case 4:
		intent = new Intent(this, WorshipRewardContent.class);
		intent.putExtra("TITLE", R.string.row5_salah_doha);
		intent.putExtra("DESC", R.raw.salah_doha);
		intent.putExtra("FEQH", R.raw.salah_doha_feqh);	
		intent.putExtra("ICON", R.drawable.lv_salah);
		startActivity(intent);
		break;
	case 5:
		intent = new Intent(this, WorshipRewardOnly.class);
		intent.putExtra("TITLE", R.string.row6_quran_qera2a);
		intent.putExtra("DESC", R.raw.quran_qeraaa);
		intent.putExtra("ICON", R.drawable.lv_quran);
		startActivity(intent);
		break;
	case 6:
		intent = new Intent(this, WorshipRewardOnly.class);
		intent.putExtra("TITLE", R.string.row7_quran_7efz);
		intent.putExtra("DESC", R.raw.quran_hefz);
		intent.putExtra("ICON", R.drawable.lv_quran);
		startActivity(intent);
		break;
	case 7: // zekr still
		intent = new Intent(this, WorshipRewardOnly.class);
		intent.putExtra("TITLE", R.string.row8_zekr_saba7_masa2);
		intent.putExtra("DESC", R.raw.zekr_sabah_masaa);
		intent.putExtra("ICON", R.drawable.lv_zekr);
		startActivity(intent);
		break;
	case 8:
		intent = new Intent(this, WorshipRewardContent.class);
		intent.putExtra("TITLE", R.string.row9_zekr_estykaz_nom);
		intent.putExtra("DESC", R.raw.zekr_estykaz);
		intent.putExtra("FEQH", R.raw.zekr_nom);
		intent.putExtra("ICON", R.drawable.lv_zekr);
		startActivity(intent);
		break;
	case 9:
		intent = new Intent(this, WorshipRewardContent.class);
		intent.putExtra("TITLE", R.string.row10_zekr_afterSalah);
		intent.putExtra("DESC", R.raw.zekr_aftersalah);
		intent.putExtra("FEQH", R.raw.zekr_aftersalah_feqh);	
		intent.putExtra("ICON", R.drawable.lv_zekr);
		startActivity(intent);
		break;
	case 10:
		intent = new Intent(this, WorshipRewardContent.class);
		intent.putExtra("TITLE", R.string.row11_sawm);
		intent.putExtra("DESC", R.raw.sawm);
		intent.putExtra("FEQH", R.raw.sawm_feqh);
		intent.putExtra("ICON", R.drawable.lv_sawm);
		startActivity(intent);
		break;
	default:
		break;
	}
}
	
	public int calcResults(boolean[]rowNumber, int UserSelectedDays){
		/*
		 * this method calculates results according to the setted days.
		 */
		int result = 0;
		switch (UserSelectedDays) {
		case 3:
			for(int i=0; i<3; i++){
				if(rowNumber[i] == true){
					if(rowNumber == ResultsOfRow11 || rowNumber == ResultsOfRow7){
						result += 80;
					}
					result += 34;
					if(rowNumber == ResultsOfRow11 || rowNumber == ResultsOfRow7){
						result -= 34;
					}
				}
			}
			break;
		case 5:
			for(int i=0; i<5; i++){
				if(rowNumber[i] == true){
					if(rowNumber == ResultsOfRow11 || rowNumber == ResultsOfRow7){
						result += 50;
					}
					result += 20;
					if(rowNumber == ResultsOfRow11 || rowNumber == ResultsOfRow7){
						result -= 20;
					}
				}
			}
			break;
		case 7:
			for(int i=0; i<7; i++){
				if(rowNumber[i] == true){
					if(rowNumber == ResultsOfRow11 || rowNumber == ResultsOfRow7){
						result += 35;
					}
					result += 15;
					if(rowNumber == ResultsOfRow11 || rowNumber == ResultsOfRow7){
						result -= 15;
					}
				}
			}
			break;
		default:
			break;
		}
		
		
		return result;
	}
	
	/*
	 * row1_salah_gama3a
	row2_salah_sunna
	row3_salah_qeyam
	row4_salah_wetr
	row5_salah_doha
	row6_quran_qera2a
	row7_quran_hefz
	row8_zekr_saba7_masa2
	row9_zekr_nom_estykaz
	row10_zekr_afterSalah
	row11_sawm*/
	public void getResultOfRow(int rowNumber){
		/*
		 * this method get preferences values and store it in arrays according to row numbers
		 */
		switch (rowNumber) {
		case 1:
			ResultsOfRow1[0] = day1.getBoolean("row1_salah_gama3a", false);
			ResultsOfRow1[1] = day2.getBoolean("row1_salah_gama3a", false);
			ResultsOfRow1[2] = day3.getBoolean("row1_salah_gama3a", false);
			ResultsOfRow1[3] = day4.getBoolean("row1_salah_gama3a", false);
			ResultsOfRow1[4] = day5.getBoolean("row1_salah_gama3a", false);
			ResultsOfRow1[5] = day6.getBoolean("row1_salah_gama3a", false);
			ResultsOfRow1[6] = day7.getBoolean("row1_salah_gama3a", false);
			break;
		case 2:
			ResultsOfRow2[0] = day1.getBoolean("row2_salah_sunna", false);
			ResultsOfRow2[1] = day2.getBoolean("row2_salah_sunna", false);
			ResultsOfRow2[2] = day3.getBoolean("row2_salah_sunna", false);
			ResultsOfRow2[3] = day4.getBoolean("row2_salah_sunna", false);
			ResultsOfRow2[4] = day5.getBoolean("row2_salah_sunna", false);
			ResultsOfRow2[5] = day6.getBoolean("row2_salah_sunna", false);
			ResultsOfRow2[6] = day7.getBoolean("row2_salah_sunna", false);
			break;
		case 3:
			ResultsOfRow3[0] = day1.getBoolean("row3_salah_qeyam", false);
			ResultsOfRow3[1] = day2.getBoolean("row3_salah_qeyam", false);
			ResultsOfRow3[2] = day3.getBoolean("row3_salah_qeyam", false);
			ResultsOfRow3[3] = day4.getBoolean("row3_salah_qeyam", false);
			ResultsOfRow3[4] = day5.getBoolean("row3_salah_qeyam", false);
			ResultsOfRow3[5] = day6.getBoolean("row3_salah_qeyam", false);
			ResultsOfRow3[6] = day7.getBoolean("row3_salah_qeyam", false);
			break;
		case 4:
			ResultsOfRow4[0] = day1.getBoolean("row4_salah_wetr", false);
			ResultsOfRow4[1] = day2.getBoolean("row4_salah_wetr", false);
			ResultsOfRow4[2] = day3.getBoolean("row4_salah_wetr", false);
			ResultsOfRow4[3] = day4.getBoolean("row4_salah_wetr", false);
			ResultsOfRow4[4] = day5.getBoolean("row4_salah_wetr", false);
			ResultsOfRow4[5] = day6.getBoolean("row4_salah_wetr", false);
			ResultsOfRow4[6] = day7.getBoolean("row4_salah_wetr", false);
			break;
		case 5:
			ResultsOfRow5[0] = day1.getBoolean("row5_salah_doha", false);
			ResultsOfRow5[1] = day2.getBoolean("row5_salah_doha", false);
			ResultsOfRow5[2] = day3.getBoolean("row5_salah_doha", false);
			ResultsOfRow5[3] = day4.getBoolean("row5_salah_doha", false);
			ResultsOfRow5[4] = day5.getBoolean("row5_salah_doha", false);
			ResultsOfRow5[5] = day6.getBoolean("row5_salah_doha", false);
			ResultsOfRow5[6] = day7.getBoolean("row5_salah_doha", false);
			break;
		case 6:
			ResultsOfRow6[0] = day1.getBoolean("row6_quran_qera2a", false);
			ResultsOfRow6[1] = day2.getBoolean("row6_quran_qera2a", false);
			ResultsOfRow6[2] = day3.getBoolean("row6_quran_qera2a", false);
			ResultsOfRow6[3] = day4.getBoolean("row6_quran_qera2a", false);
			ResultsOfRow6[4] = day5.getBoolean("row6_quran_qera2a", false);
			ResultsOfRow6[5] = day6.getBoolean("row6_quran_qera2a", false);
			ResultsOfRow6[6] = day7.getBoolean("row6_quran_qera2a", false);
			break;
		case 7:
			ResultsOfRow7[0] = day1.getBoolean("row7_quran_hefz", false);
			ResultsOfRow7[1] = day2.getBoolean("row7_quran_hefz", false);
			ResultsOfRow7[2] = day3.getBoolean("row7_quran_hefz", false);
			ResultsOfRow7[3] = day4.getBoolean("row7_quran_hefz", false);
			ResultsOfRow7[4] = day5.getBoolean("row7_quran_hefz", false);
			ResultsOfRow7[5] = day6.getBoolean("row7_quran_hefz", false);
			ResultsOfRow7[6] = day7.getBoolean("row7_quran_hefz", false);
			break;
		case 8:
			ResultsOfRow8[0] = day1.getBoolean("row8_zekr_saba7_masa2", false);
			ResultsOfRow8[1] = day2.getBoolean("row8_zekr_saba7_masa2", false);
			ResultsOfRow8[2] = day3.getBoolean("row8_zekr_saba7_masa2", false);
			ResultsOfRow8[3] = day4.getBoolean("row8_zekr_saba7_masa2", false);
			ResultsOfRow8[4] = day5.getBoolean("row8_zekr_saba7_masa2", false);
			ResultsOfRow8[5] = day6.getBoolean("row8_zekr_saba7_masa2", false);
			ResultsOfRow8[6] = day7.getBoolean("row8_zekr_saba7_masa2", false);
			break;
		case 9:
			ResultsOfRow9[0] = day1.getBoolean("row9_zekr_nom_estykaz", false);
			ResultsOfRow9[1] = day2.getBoolean("row9_zekr_nom_estykaz", false);
			ResultsOfRow9[2] = day3.getBoolean("row9_zekr_nom_estykaz", false);
			ResultsOfRow9[3] = day4.getBoolean("row9_zekr_nom_estykaz", false);
			ResultsOfRow9[4] = day5.getBoolean("row9_zekr_nom_estykaz", false);
			ResultsOfRow9[5] = day6.getBoolean("row9_zekr_nom_estykaz", false);
			ResultsOfRow9[6] = day7.getBoolean("row9_zekr_nom_estykaz", false);
			break;
		case 10:
			ResultsOfRow10[0] = day1.getBoolean("row10_zekr_afterSalah", false);
			ResultsOfRow10[1] = day2.getBoolean("row10_zekr_afterSalah", false);
			ResultsOfRow10[2] = day3.getBoolean("row10_zekr_afterSalah", false);
			ResultsOfRow10[3] = day4.getBoolean("row10_zekr_afterSalah", false);
			ResultsOfRow10[4] = day5.getBoolean("row10_zekr_afterSalah", false);
			ResultsOfRow10[5] = day6.getBoolean("row10_zekr_afterSalah", false);
			ResultsOfRow10[6] = day7.getBoolean("row10_zekr_afterSalah", false);
			break;
		case 11:
			ResultsOfRow11[0] = day1.getBoolean("row11_sawm", false);
			ResultsOfRow11[1] = day2.getBoolean("row11_sawm", false);
			ResultsOfRow11[2] = day3.getBoolean("row11_sawm", false);
			ResultsOfRow11[3] = day4.getBoolean("row11_sawm", false);
			ResultsOfRow11[4] = day5.getBoolean("row11_sawm", false);
			ResultsOfRow11[5] = day6.getBoolean("row11_sawm", false);
			ResultsOfRow11[6] = day7.getBoolean("row11_sawm", false);
			break;
		default:
			break;
		}
	}
	
	public void resetPreferences(SharedPreferences day){
		Editor edit = day.edit();
		edit.clear();
		edit.commit();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
//		ReportPreferences.resetAllPreferences();
		resetPreferences(day1);
		resetPreferences(day2);
		resetPreferences(day3);
		resetPreferences(day4);
		resetPreferences(day5);
		resetPreferences(day6);
		resetPreferences(day7);
		
	}
	

	
	
	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		Thread timer = new Thread(){
			@Override
			public void run() {
				try{
					sleep(3200);


				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();

				}finally{

					closeOptionsMenu();				}
			}
		};
		openOptionsMenu();
		timer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(menu.NONE, 0, 0, getResources().getString(R.string.makeNewReport)).setIcon(android.R.drawable.ic_menu_agenda);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		ReportResults.this.finish();
		return super.onOptionsItemSelected(item);
	}
	
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	super.onBackPressed();
  //  	displayInterstitial();
    }
    

/*
    // Invoke displayInterstitial() when you are ready to display an interstitial.
    public void displayInterstitial() {
      if (interstitial.isLoaded()) {
        interstitial.show();
      }
    }*/
}
