package islamic.ebadaty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button reportBtn, fada2elBtn, aboutBtn;
    public int SelectedDaysSpinner;
    public int UserSelectedDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reportBtn = findViewById(R.id.btn_newReport);
        fada2elBtn = findViewById(R.id.btn_fada2el);
        aboutBtn = findViewById(R.id.btn_about);

        reportBtn.setOnClickListener(this);
        fada2elBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View buttonPressed) {
        switch (buttonPressed.getId()) {
            case R.id.btn_newReport:
                openNewReport();
                break;
            case R.id.btn_fada2el:
               startActivity(new Intent(this, WorshipReward.class));
                break;
            case R.id.btn_about:
                startActivity(new Intent(this, About.class));
                break;
            default:
                break;
        }
    }

    private void openNewReport() {
        //Starting Dialog
        LayoutInflater inflater = getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.dialog_settings, (ViewGroup) getCurrentFocus());
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(R.string.dialog_title);
        b.setIcon(android.R.drawable.ic_dialog_info);
        b.setView(dialoglayout);
        //spinner
        Spinner spinner = dialoglayout.findViewById(R.id.sp_days);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sp_days, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //================
        TimePicker timerPicker =  dialoglayout.findViewById(R.id.timer_reportTime);

        b.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                //Starting service

                switch (SelectedDaysSpinner){
                    case 0:
                        UserSelectedDays = 3;
                        break;
                    case 1:
                        UserSelectedDays = 5;
                        break;
                    case 2:
                        UserSelectedDays = 7;
                        break;
                }



            }
        });
        b.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();
            }
        });
        AlertDialog alert = b.create();
        alert.show();

    }
}
