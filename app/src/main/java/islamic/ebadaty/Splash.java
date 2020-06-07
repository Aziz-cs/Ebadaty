package islamic.ebadaty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2200);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    startActivity(new Intent(Splash.this, MainActivity.class));
                }
            }

        };
        timer.start();
    }
}
