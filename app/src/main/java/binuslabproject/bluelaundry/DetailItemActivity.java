package binuslabproject.bluelaundry;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        Intent myIntent = getIntent();
        String itemName = myIntent.getStringExtra("itemName");
        final String itemPrice= myIntent.getStringExtra("itemPrice");
        String itemDesc = myIntent.getStringExtra("itemDesc");
        String price = "Rp. "+itemPrice;

        TextView txtName = findViewById(R.id.detailName);
        TextView txtPrice = findViewById(R.id.txtPrice);
        TextView txtDesc = findViewById(R.id.detailDescription);
        txtName.setText(itemName);
        txtPrice.setText(price);
        txtDesc.setText(itemDesc);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(DetailItemActivity.this, ItemActivity.class));
            }
        });

        final EditText txtQuantity = findViewById(R.id.txtQuantity);
        txtQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView txtSubTotal = findViewById(R.id.txtSubTotal);
                String subTotal = "Rp. "+(Integer.parseInt(itemPrice) * Integer.parseInt(txtQuantity.getText().toString()));
                txtSubTotal.setText(subTotal);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        Button btnSubmit = findViewById(R.id.btnSubmit);
//        btnSubmit.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                EditText quantity = findViewById(R.id.txtQuantity);
//                if(Integer.parseInt(quantity.getText().toString()) < 1)
//                {
//                    showDialog();
//                }
//            }
//        });
//
//        btnSubmit.setOnHoverListener(new View.OnHoverListener()
//        {
//            public boolean onHover(View v, MotionEvent event)
//            {
//                return false;
//            }
//        });
    }

    public void showDialog()
    {
        DetailItemDialog dialog = new DetailItemDialog();
        dialog.show(getSupportFragmentManager(), "qtyTag");
    }

}
