package kola.com.alarm;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;TimePicker timePicker;PendingIntent pendingIntent;Context context;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button tx;Button t;

        timePicker=(TimePicker)findViewById(R.id.tp);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

            final Calendar calendar=Calendar.getInstance();

        tx=(Button)findViewById(R.id.on);
       t=(Button)findViewById(R.id.off);
       final Intent intent=new Intent(this,Alarm_receiver.class);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getHour());
                calendar.set(Calendar.MINUTE,timePicker.getMinute());
                int hour=timePicker.getHour();
                int minutes=timePicker.getMinute();
                String h=String.valueOf(hour);
                String m=String.valueOf(minutes);

                if(hour>12){h=String.valueOf(hour-12);}
                if(minutes<10){m= "0"+String.valueOf(minutes);}intent.putExtra("extra","on");
                setalarm("AlaRM SET"+h+m);
                pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setalarm("alarm off");
                alarmManager.cancel(pendingIntent);sendBroadcast(intent);intent.putExtra("extra","off");
            }
        });
    }
    public void setalarm(String s)
    {TextView txt=(TextView)findViewById(R.id.txt);
        txt.setText(s);



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
    }
}
