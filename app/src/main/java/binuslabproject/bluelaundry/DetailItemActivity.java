package binuslabproject.bluelaundry;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText quantity = findViewById(R.id.txtQuantity);
                if(Integer.parseInt(quantity.getText().toString()) < 1)
                {
                    showDialog();
                }
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

    public void showDialog()
    {
        DetailItemDialog dialog = new DetailItemDialog();
        dialog.show(getSupportFragmentManager(), "qtyTag");
    }

}
