package com.baidu.totpdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(v -> {
            String totp = TOTP.generateMyTOTP("account01", "12345");

//            boolean account01 = TOTP.verifyTOTPFlexibility("account01", "12345", totp);

            text.setText("totp: " + totp + "\r\ntime: " + Calendar.getInstance().getTime().toLocaleString());
        });
    }
}