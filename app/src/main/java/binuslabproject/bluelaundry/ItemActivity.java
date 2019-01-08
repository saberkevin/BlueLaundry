package binuslabproject.bluelaundry;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

//====================================================================================================================================================
        //spinner menu dropdown
        final Spinner menuDropDown = findViewById(R.id.menuDropDown);
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<String>(ItemActivity.this,
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
                        startActivity(new Intent(ItemActivity.this, ItemActivity.class));
                        menuDropDown.setSelection(3);
                        break;
                    case 1:
                        startActivity(new Intent(ItemActivity.this, AboutActivity.class));
                        menuDropDown.setSelection(3);
                        break;
                    case 2:
                        startActivity(new Intent(ItemActivity.this, LoginActivity.class));
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
//====================================================================================================================================================

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.add(new ClothingFragment(), "Clothing");
        adapter.add(new OthersFragment(), "Others");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater  = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() ==  R.id.login)
//        {
//            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//            intent.putExtra("text", "Hello");
//            startActivity(intent);
//        }
//        else if(item.getItemId() ==  R.id.register)
//        {
//            Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_LONG).show();
//        }
//        return super.onOptionsItemSelected(item);
        return false;
    }

}
