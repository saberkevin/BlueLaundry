package binuslabproject.bluelaundry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class DetailItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        Button btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

            }
        });

        btnSubmit.setOnHoverListener(new View.OnHoverListener()
        {
            public boolean onHover(View v, MotionEvent event)
            {
                return false;
            }
        });
    }

}
