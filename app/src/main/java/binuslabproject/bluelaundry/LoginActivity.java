package binuslabproject.bluelaundry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button Login;
    private EditText Username, Password;
    public static String globalPreferenceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = (Button) findViewById(R.id.btnLogin);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(Username.getText().toString(), Password.getText().toString());
            }

        });
    }

    public void login(String username, String password) {
        if (username.isEmpty()) {
            Toast.makeText(this, "Username is Empty", Toast.LENGTH_LONG).show();
        } else if (username.length() < 5) {
            Toast.makeText(this, "Username need to be atleast 5 characters long", Toast.LENGTH_LONG).show();
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Password is Empty", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences.Editor editor = getSharedPreferences(globalPreferenceName, MODE_PRIVATE).edit();
            editor.putString("username", username);
            editor.commit();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
