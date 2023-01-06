package com.example.phone__caller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText Phone_no,text_msg;
    ImageButton call_btn,msg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Phone_no=findViewById(R.id.edt1);
       text_msg=findViewById(R.id.edt2);
       call_btn=findViewById(R.id.btn1);
       msg_btn=findViewById(R.id.btn2);
       call_btn.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {

               String UserInput=Phone_no.getText().toString();
               if(UserInput.isEmpty())
               {
                   Toast.makeText(MainActivity.this, "No contact", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Intent intent=new Intent();
                   intent.setAction(Intent.ACTION_CALL);
                   intent.setData(Uri.parse(UserInput));
                   startActivity(intent);
               }
           }
       });
       msg_btn.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               String User_phone_no=Phone_no.getText().toString();
               String User_msg=text_msg.getText().toString();
               if( User_phone_no.isEmpty() && User_msg.isEmpty())
               {
                   Toast.makeText(MainActivity.this, "Message Cannot Send..Please Enter message and phone_no", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   SmsManager sms=SmsManager.getDefault();
                   sms.sendTextMessage(null,User_phone_no,User_msg,null,null);
               }


           }
       });

    }
}