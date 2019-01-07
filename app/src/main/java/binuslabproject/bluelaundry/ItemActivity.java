package binuslabproject.bluelaundry;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

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
