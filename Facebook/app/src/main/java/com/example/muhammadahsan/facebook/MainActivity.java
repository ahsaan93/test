package com.example.muhammadahsan.facebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

/*

    public void doLogin(View view){

        Toast.makeText(this,R.string.description,Toast.LENGTH_SHORT).show();
    }
*/





        public void doLogin(View view){
            String cName;
            String iName;
        EditText loginName= (EditText) findViewById(R.id.editText_loginName);
        EditText password = (EditText) findViewById(R.id.editText_password);
        Button login = (Button) findViewById(R.id.button_login);

        login log= new login(getString(R.string.name));
     //       login log= new login("Muhammad Ahsan");

            cName=log.getLoginName();
            iName = loginName.getText().toString();

        if(cName.equals(iName)){
            Toast.makeText(this,R.string.ifMatched,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,R.string.ifNotMatched,Toast.LENGTH_SHORT).show();
            }
        }


}
