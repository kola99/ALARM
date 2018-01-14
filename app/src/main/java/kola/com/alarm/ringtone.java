package kola.com.alarm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by acer on 1/14/2018.
 */

public class ringtone extends Service {
    MediaPlayer mediaPlayer;int id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flag,int startid)
    {mediaPlayer.create(this,R.raw.ip);mediaPlayer.start();
        String st= intent.getExtras().getString("extra");
        if(st.equals("on"))
        {id=1;}
        else if(st.equals("off")){id=2;}
        else
            id=2;
       // if(Context.isRunning&&id==1)mediaPlayer.create(this,R.raw.good);mediaPlayer.start();this.isRunning;}



        return START_NOT_STICKY;}
}
