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
import android.widget.Toast;

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

        TextView lblSubTotal = findViewById(R.id.lblSubTotal);
        TextView txtSubTotal =  findViewById(R.id.txtSubTotal);

        lblSubTotal.setVisibility(View.GONE);
        txtSubTotal.setVisibility(View.GONE);

////      if quantity content change , subtotal price will change logic (on quantity text change)
//        final EditText txtQuantity = findViewById(R.id.txtQuantity);
//        txtQuantity.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                TextView txtSubTotal = findViewById(R.id.txtSubTotal);
//                String subTotal = "Rp. "+(Integer.parseInt(itemPrice) * Integer.parseInt(txtQuantity.getText().toString()));
//                txtSubTotal.setText(subTotal);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText quantity = findViewById(R.id.txtQuantity);
                String qty = quantity.getText().toString().trim();
                if(qty.isEmpty() || qty.length() == 0 || qty.equals("") || qty == null || Integer.parseInt(qty) == 0)
                {
                    showDialogError();
                }
                else
                {
                    Intent myIntent = getIntent();
                    final String itemPrice= myIntent.getStringExtra("itemPrice");

                    TextView lblSubTotal = findViewById(R.id.lblSubTotal);
                    TextView txtSubTotal =  findViewById(R.id.txtSubTotal);
                    EditText txtQuantity = findViewById(R.id.txtQuantity);

                    lblSubTotal.setVisibility(View.VISIBLE);
                    txtSubTotal.setVisibility(View.VISIBLE);

                    String subTotal = "Rp. "+(Integer.parseInt(itemPrice) * Integer.parseInt(txtQuantity.getText().toString()));
                    txtSubTotal.setText(subTotal);

                    showDialogSuccess();
                }
            }
        });
    }

    public void showDialogError()
    {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(DetailItemActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        builder.setTitle("Validation Error")
                .setMessage("Quantity must be at least one!");

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDialogSuccess()
    {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(DetailItemActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        builder.setTitle("Success")
                .setMessage("A laundry service has been bought!");
        AlertDialog alert = builder.create();
        alert.show();
    }

}
