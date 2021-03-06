package org.androidtown.doitmission_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 101;
    Button button;
    EditText id, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);

        Intent passedIntent = getIntent();
        processIntent(passedIntent);

    }   ;

    public void onButton1Clicked(View v){
        String name = id.getText().toString();
        String pass = password.getText().toString();

        if(name.length() ==0 || pass.length() ==0){
            Toast.makeText(this, "아이디랑 비밀번호 둘다 입력해주세요. ", Toast.LENGTH_LONG).show();
        }
       else {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            intent.putExtra("id", name);
            intent.putExtra("password", pass);
            startActivityForResult(intent, REQUEST_CODE);
            finish();
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    public void processIntent(Intent intent) {
            if (intent != null) {
              String  pasword = intent.getStringExtra("password");
              String meu = intent.getStringExtra("menu");
              String i = intent.getStringExtra("id");
                Toast.makeText(this, "main class -> 아이디는 " + i + ",  비밀번호는 " + pasword + ", 메뉴는 "+ meu, Toast.LENGTH_LONG).show();
            }
        }
    }

