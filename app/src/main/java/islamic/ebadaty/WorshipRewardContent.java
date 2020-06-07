package islamic.ebadaty;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;

public class WorshipRewardContent extends Activity {
	TextView title, desc, feqh;
	Intent intent;
	int Rtitle, Rdesc, Rfeqh, Ricon;
	TabWidget ebadaty_tabWG;
	ImageView icon;
//	 private InterstitialAd interstitial;

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
 //   requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	setContentView(R.layout.worship_reward_content);
//    getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);


    // Create the interstitial.
 /*   interstitial = new InterstitialAd(this);
    interstitial.setAdUnitId("ca-app-pub-9911896226381783/9879461752");

    // Begin loading your interstitial.
    interstitial.loadAd(adRequest);*/
    
	title = (TextView) findViewById(R.id.tv_reward_title);
	desc = (TextView) findViewById(R.id.tv_reward_desc);
	feqh = (TextView) findViewById(R.id.tv_reward_feqh);
	icon = (ImageView) findViewById(R.id.iv_fada2el_dispIcon);
	
    TabHost th = (TabHost) findViewById(R.id.tabH_reward);
    ebadaty_tabWG = th.getTabWidget();

       
	intent = getIntent();
	Ricon = intent.getExtras().getInt("ICON");
	icon.setImageDrawable(getResources().getDrawable(Ricon));
	Rtitle = intent.getExtras().getInt("TITLE");
	Rdesc = intent.getExtras().getInt("DESC");
	Log.i("FEQH", "" + Rfeqh);
	Rfeqh = intent.getExtras().getInt("FEQH");
	Log.i("FEQH", "" + Rfeqh);
	
	if(Rfeqh != 0){
		readAndSetFile(Rfeqh, feqh);
	}

    th.setup();										//Setup the basics of the Tab and intilize it
    TabSpec specs = th.newTabSpec("tag1");			//create new tab on the tabhost we dragged
    specs.setContent(R.id.tab1);					//what to display on the tab (id of linearlayout)
    specs.setIndicator(getResources().getString(R.string.tab_feqh), getResources().getDrawable(android.R.drawable.ic_menu_info_details));
 //what will be displayed on the tab title.
    if(Rtitle == R.string.title_nom){
    	specs.setIndicator(getResources().getString(R.string.title_estykaz));
    }
    th.addTab(specs);								//add this tab on the tabhost.
    
    
    specs = th.newTabSpec("tag2");
    specs.setContent(R.id.tab2);
    specs.setIndicator(getResources().getString(R.string.tab_fadl), getResources().getDrawable(R.drawable.tabs_feqh));
    if(Rtitle == R.string.row9_zekr_estykaz_nom){
    	specs.setIndicator(getResources().getString(R.string.title_estykaz));
    }
    th.addTab(specs);

    th.setCurrentTab(1);
    title.setText(getResources().getString(Rtitle));
	readAndSetFile(Rdesc, desc);
}



public String readAndSetFile(int id, TextView tv){
	
try {
    Resources res = getResources();
    InputStream in_s = res.openRawResource(id);

    byte[] b = new byte[in_s.available()];
    
    in_s.read(b);
    tv.setText(new String(b));
} catch (Exception e) {
    // e.printStackTrace();
	tv.setText("Error: can't view content.");
}
return null;
}

@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
//	displayInterstitial();
}


/*
// Invoke displayInterstitial() when you are ready to display an interstitial.
public void displayInterstitial() {
  if (interstitial.isLoaded()) {
    interstitial.show();
  }
}
*/
}
