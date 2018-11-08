package com.example.oshemb.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    private EditText editTextSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        editTextSendMessage = findViewById(R.id.editText);
        Button sendButton = findViewById(R.id.button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.sub));
                intent.putExtra(Intent.EXTRA_TEXT, editTextSendMessage.getText());
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(AboutActivity.this, "No e-mail apss", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
