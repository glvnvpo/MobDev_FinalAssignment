package com.example.twoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button btnActTwo;
    EditText editText;

    final String TAG = "States";

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(1, true);
        return super.onPrepareOptionsMenu(menu);
    }

    // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        // Выведем в TextView информацию о нажатом пункте меню
        if (item.getTitle().toString().equals("Activity 1")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (item.getTitle().toString().equals("Activity 2")) {
            Intent intent = new Intent(this, ActivityTwo.class);
            startActivity(intent);
        } else if (item.getTitle().toString().equals("Activity 3")) {
            Intent intent = new Intent(this, ActivityThree.class);
            startActivity(intent);
        } else if (item.getTitle().toString().equals("Activity 4")) {
            Intent intent = new Intent(this, ActivityFour.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActTwo = (Button) findViewById(R.id.btnActTwo);
        btnActTwo.setOnClickListener(this);

        Log.d(TAG, "MainActivity: onCreate()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActTwo:
                Intent intent = new Intent(this, ActivityTwo.class);
                editText = findViewById(R.id.editText);
                intent.putExtra("name", editText.getText().toString()); //передача объекта с ключом name и значением editText
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
}}
