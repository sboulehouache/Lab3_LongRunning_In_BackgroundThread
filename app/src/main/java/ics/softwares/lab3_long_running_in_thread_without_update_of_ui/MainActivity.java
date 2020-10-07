package ics.softwares.lab3_long_running_in_thread_without_update_of_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnStartThread;
    Button btnMessage;
    String TAG="LongRunning";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartThread=(Button)findViewById(R.id.btnLoop);

        btnStartThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    int index=0;
                    @Override
                    public void run() {
                        try{Thread.sleep(20000);}
                        catch(Exception e){           }
                    }
                }).start();
            }
        });
        btnMessage=(Button)findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: message");
                Toast toast = Toast.makeText(MainActivity.this, "I am a message", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            int index=0;
            @Override
            public void run() {
                try{Thread.sleep(20000);}
                catch(Exception e){           }
            }
        }).start();
    }
}
