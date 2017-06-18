package com.example.dell.attendancemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends AppCompatActivity {

    EditText mSubjectEditText;
    EditText mSubjectCodeEditText;
    AttDbHelper mdbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSubjectEditText=(EditText)findViewById(R.id.edit_subject_name);
        mSubjectCodeEditText=(EditText)findViewById(R.id.edit_subject_code);
        mdbHelper=new AttDbHelper(this);
    }

    public void insert()
    {
        boolean isInserted= mdbHelper.insertData( mSubjectEditText.getText().toString().trim(),
                mSubjectCodeEditText.getText().toString().trim());

        if(isInserted==true)
            Toast.makeText(EditorActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(EditorActivity.this,"Data insertion falied",Toast.LENGTH_LONG).show();
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_editor, menu);
            return true;
        }


    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_save) {
                insert();
                return true;
            }

        return super.onOptionsItemSelected(item);
        }


}

