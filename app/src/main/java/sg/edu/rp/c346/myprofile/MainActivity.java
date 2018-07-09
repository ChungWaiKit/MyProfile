package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rpGender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rpGender = findViewById(R.id.radioButtonGender);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float fltGpa = Float.valueOf(etGPA.getText().toString());
        int selectedId = rpGender.getCheckedRadioButtonId();

        // obtain an instance of sharedpreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // obtain an instance of the sharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // add the key-value pair
        prefEdit.putString("name", strName );
        prefEdit.putFloat("gpa", fltGpa );
        prefEdit.putInt("id",selectedId);
        // call commit() method to save the changes into sharedpreferences
        prefEdit.commit();
    }



    @Override
    protected void onResume() {
        super.onResume();

        //obtain an instance of the sharedpreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("name","");
        Float gpa = prefs.getFloat("gpa",0.0f);
        int rp = prefs.getInt("id", 0);

       etName.setText(msg);
       etGPA.setText(String.valueOf(gpa));
       rpGender.check(rp);
    }
}

