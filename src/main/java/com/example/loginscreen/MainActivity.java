package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button Login;
    private EditText Username;
    private EditText Password;
    private int counter=3;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.save_login);

        Login.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v){
            Validate(Username.getText().toString(), Password.getText().toString() );

        }
        });

    }

private void Validate (String userName, String userPassword){
      if((userName.equals("Admin")) && (userPassword.equals("123"))){
          Intent intent = new Intent(MainActivity.this, helloWorldActivity.class);
          Toast.makeText(getApplicationContext(),"Giriş Başarılı!", Toast.LENGTH_LONG).show();
          startActivity(intent);
      }else {

          counter--;
          Toast.makeText(getApplicationContext(),"Giriş Başarısız!", Toast.LENGTH_LONG).show();

          if(counter == 0){
              Login.setEnabled(false);
              Toast.makeText(getApplicationContext(),"Hakkınız bitmiştir.!", Toast.LENGTH_LONG).show();

          }
      }
}

}
