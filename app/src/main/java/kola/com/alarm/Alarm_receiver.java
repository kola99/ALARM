package kola.com.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by acer on 1/14/2018.
 */

public class Alarm_receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
    Intent inten=new Intent(context,ringtone.class);context.startService(inten);
String get=intent.getExtras().getString("extra");inten.putExtra("extra",get);
    }
}
