package binuslabproject.bluelaundry;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    ViewPager vp;
    VPCarouselAdapter carouselAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //spinner menu dropdown
        Spinner menuDropDown = findViewById(R.id.menuDropDown);
        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<String>(HomeActivity.this,
                R.layout.drop_down_spinner_item, getResources().getStringArray(R.array.menuDropDown));
        dropDownAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menuDropDown.setAdapter(dropDownAdapter);
        menuDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //greetings
        SharedPreferences sp = getSharedPreferences("LoginGlobalVariable", Activity.MODE_PRIVATE);
        String username = sp.getString("username","Anonymous");
        TextView greetings = findViewById(R.id.greetings);
        greetings.setText("Hello " + username);


        //carousel
        vp = findViewById(R.id.vpCarousel);
        carouselAdapter = new VPCarouselAdapter(getApplicationContext());
        vp.setAdapter(carouselAdapter);

        Timer timer =  new Timer();
        timer.scheduleAtFixedRate(new CarouselTimer(), 0, 5000);
    }

    public class CarouselTimer extends TimerTask
    {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    switch (vp.getCurrentItem())
                    {
                        case 0:
//                            https://developer.android.com/training/animation/screen-slide
//                            vp.setPageTransformer(true, );
                            vp.setCurrentItem(1);
                            break;
                        case 1:
                            vp.setCurrentItem(2);
                            break;
                        case 2:
                            vp.setCurrentItem(3);
                            break;
                        case 3:
                            vp.setCurrentItem(4);
                            break;
                        case 4:
                            vp.setCurrentItem(0);
                            break;
                    }
                }
            });
        }
    }
}
