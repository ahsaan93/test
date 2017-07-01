package com.example.muhammadahsan;

import android.os.Bundle;
import android.app.Activity;

import com.example.muhammadahsan.singer.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

import static com.example.muhammadahsan.MainActivity.resultSet;
import static com.example.muhammadahsan.MainActivity.stmt;
import static com.example.muhammadahsan.MainActivity.user_id;

public class LoginActivity extends Activity {
    public EditText ed_UserID, ed_UserPassword;
    public Button btn_Login;
    public static String v_userID, v_userPassword;
    String login_id;
    String user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ElementInitialization();
        ElementListners();
    }

    public void ElementInitialization() {
        ed_UserID = (EditText) findViewById(R.id.ed_userId);
        ed_UserPassword = (EditText) findViewById(R.id.ed_userPassword);
        btn_Login = (Button) findViewById(R.id.btn_SignIn);
    }

    public void ElementListners() {
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v_userID = ed_UserID.getText().toString();
                v_userPassword = ed_UserPassword.getText().toString();

                //Toast.makeText(LoginActivity.this, "Found: "+v_userID, Toast.LENGTH_SHORT).show();

                if (v_userID.length() == 0){
                    Toast.makeText(getApplicationContext(), "User ID not found!", Toast.LENGTH_SHORT).show();
                }else if(v_userPassword.length() == 0){
                    Toast.makeText(getApplicationContext(), "User password not found!", Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        String sql = "SELECT USER_ID, USER_LOGIN, USER_PASSWORD FROM USER_SETUP WHERE USER_LOGIN = '" + v_userID + "'";
                        //Toast.makeText(getApplicationContext(), ""+sql, Toast.LENGTH_SHORT).show();
                        resultSet = stmt.executeQuery(sql);
                        //Toast.makeText(getApplicationContext(), ""+resultSet.getString(1), Toast.LENGTH_SHORT).show();
                        if (!resultSet.next()){
                            Toast.makeText(getApplicationContext(), "User not found!", Toast.LENGTH_SHORT).show();
                        }else{
                            while(resultSet.next()) {
                                user_id = resultSet.getString(1);
                                login_id = resultSet.getString(2);
                                user_password = resultSet.getString(3);
                            }

                            Toast.makeText(getApplicationContext(), "Result: "+"\n"+user_id+"\n"+login_id+"\n"+user_password, Toast.LENGTH_SHORT).show();

                            if (login_id.equals(v_userID) && user_password.equals(v_userPassword)){
                                Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                                user_id = null;
                                login_id = null;
                                user_password = null;
                            }

                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


    }
}
