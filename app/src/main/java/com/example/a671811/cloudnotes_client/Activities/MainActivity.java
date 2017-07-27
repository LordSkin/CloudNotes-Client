package com.example.a671811.cloudnotes_client.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a671811.cloudnotes_client.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText ipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        ipText = (EditText) findViewById(R.id.ipEditText);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, NotesListActivity.class);
        i.putExtra("ip","http:\\\\"+ ipText.getText()+":8080/notes");
        startActivity(i);
    }
}
