package islamic.ebadaty;

import java.io.InputStream;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class WorshipRewardOnly extends Activity {
	TextView title, desc, feqh;
	Intent intent;
	ImageView icon;
	int Rtitle, Rdesc, Ricon;
//	 private InterstitialAd interstitial;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
 //   requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
	setContentView(R.layout.reward_content);

	/* 	AdRequest adRequest = new AdRequest.Builder().build();
// 	AdRequest adRequest = new AdRequest.Builder().addTestDevice("39404A261727478EC8049EE6B039EABC").build();
	
    // Create the interstitial.
   interstitial = new InterstitialAd(this);
    interstitial.setAdUnitId("ca-app-pub-9911896226381783/2356194953");

    // Begin loading your interstitial.
    interstitial.loadAd(adRequest);*/
 //   getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle);
	title =  findViewById(R.id.tv_reward_title_woFeqh);
	desc =  findViewById(R.id.tv_reward_desc_woFeqh);
	icon =  findViewById(R.id.iv_dispIcon);
	
	intent = getIntent();
	Ricon = intent.getExtras().getInt("ICON");
	icon.setImageDrawable(getResources().getDrawable(Ricon));
	Rtitle = intent.getExtras().getInt("TITLE");
	Rdesc = intent.getExtras().getInt("DESC");
	
	title.setText(getResources().getString(R.string.fadl) + " " + getResources().getString(Rtitle));
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



// Invoke displayInterstitial() when you are ready to display an interstitial.
/*public void displayInterstitial() {
  if (interstitial.isLoaded()) {
    interstitial.show();
  }
}*/
}
