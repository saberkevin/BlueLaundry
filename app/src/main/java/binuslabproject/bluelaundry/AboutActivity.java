package binuslabproject.bluelaundry;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //spinner menu dropdown
        final Spinner menuDropDown = findViewById(R.id.menuDropDown);
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<String>(AboutActivity.this,
                R.layout.drop_down_spinner_item, getResources().getStringArray(R.array.menuDropDown))
        {
            @Override
            public int getCount() {
                return 3;
            }
        };
        dropDownAdapter.setDropDownViewResource(R.layout.drop_down_spinner_item_list);
        menuDropDown.setAdapter(dropDownAdapter);
        menuDropDown.setSelection(3);
        menuDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        startActivity(new Intent(AboutActivity.this, ItemActivity.class));
                        menuDropDown.setSelection(3);
                        break;
                    case 1:
                        startActivity(new Intent(AboutActivity.this, AboutActivity.class));
                        menuDropDown.setSelection(3);
                        break;
                    case 2:
                        startActivity(new Intent(AboutActivity.this, LoginActivity.class));
                        menuDropDown.setSelection(3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //greetings
        SharedPreferences sp = getSharedPreferences(LoginActivity.globalPreferenceName, Activity.MODE_PRIVATE);
        String username = sp.getString("username","Anonymous");
        TextView greetings = findViewById(R.id.greetings);
        greetings.setText("Hello, \n" + username);
    }
}
