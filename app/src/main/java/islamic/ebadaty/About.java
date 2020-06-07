package islamic.ebadaty;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class About extends Activity implements View.OnClickListener {
    Button contactUs, review, share, otherApps, howTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);



        contactUs =  findViewById(R.id.btn_contactUs);
        review    =  findViewById(R.id.btn_review);
        share     =  findViewById(R.id.btn_share);
        otherApps = findViewById(R.id.btn_otherApps);
        howTo     =  findViewById(R.id.btn_howToDialog);

        contactUs.setOnClickListener(this);
        review.setOnClickListener(this);
        share.setOnClickListener(this);
        otherApps.setOnClickListener(this);
        howTo.setOnClickListener(this);

    }

    public void onClick(View buttonPressed) {
        // TODO Auto-generated method stub
        switch (buttonPressed.getId()) {
//==============Share Clicked======================
            case R.id.btn_share:
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "برنامج عبادتى | Ebadaty app");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=islamic.ebadaty" );
                startActivity(shareIntent);
                break;
//==============Review Clicked======================
            case R.id.btn_review:
                Intent ReviewIntent = new Intent();
                ReviewIntent.setAction(Intent.ACTION_VIEW);
                ReviewIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                ReviewIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=islamic.ebadaty"));
                startActivity(ReviewIntent);
                break;
//===============Contact Us Clicked=====================
            case R.id.btn_contactUs:
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                String[] recipients = new String[]{"iLighTechnology@gmail.com"};
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "From Ebadaty User");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                emailIntent.setType("text/plain");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Send mail to developer"));
                finish();
                break;
//================Other Apps Clicked====================
            case R.id.btn_otherApps:
                Intent otherApps = new Intent();
                otherApps.setAction(Intent.ACTION_VIEW);
                otherApps.addCategory(Intent.CATEGORY_BROWSABLE);
                otherApps.setData(Uri.parse("https://play.google.com/store/apps/developer?id=iLighTech"));
                startActivity(otherApps);
                break;
//=================How To Clicked===================
            case R.id.btn_howToDialog:
                LayoutInflater inflater = getLayoutInflater();
                View dialoglayout = inflater.inflate(R.layout.dialog_howto, (ViewGroup) getCurrentFocus());
                View titleView = inflater.inflate(R.layout.dialog_custom_title, null);

                AlertDialog.Builder b = new AlertDialog.Builder(About.this);

                b.setTitle(R.string.howto_title);
                b.setIcon(android.R.drawable.ic_dialog_info);
                b.setView(dialoglayout);
                b.setCustomTitle(titleView);
                b.setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });
                AlertDialog alert = b.create();
                alert.show();


            default:
                break;
        }
    }
}
