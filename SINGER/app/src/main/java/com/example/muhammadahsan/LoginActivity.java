package com.example.muhammadahsan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhammadahsan.singer.R;

import java.sql.SQLException;
import java.sql.Statement;

import static com.example.muhammadahsan.singer.Splashscreen.connection;
import static com.example.muhammadahsan.singer.Splashscreen.resultSet;
import static com.example.muhammadahsan.singer.Splashscreen.user_id;
import static com.example.muhammadahsan.singer.Splashscreen.user_name;

public class LoginActivity extends Activity {
    public EditText ed_UserID, ed_UserPassword;
    public Button btn_Login;
    public static TextView dbStatus;
    public static String v_userID, v_userPassword;
    String login_id;
    String user_password;
    ProgressBar progressBar;

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
        progressBar = (ProgressBar) findViewById(R.id.login_progress);
        dbStatus = (TextView) findViewById(R.id.tv_databaseStatus);

    }

    public void ElementListners() {
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                v_userID = ed_UserID.getText().toString();
                v_userPassword = ed_UserPassword.getText().toString();

                //Toast.makeText(LoginActivity.this, "Found: "+v_userID, Toast.LENGTH_SHORT).show();

                if (v_userID.length() == 0){
                    Toast.makeText(getApplicationContext(), "User ID not found!", Toast.LENGTH_SHORT).show();
                }else if(v_userPassword.length() == 0){
                    Toast.makeText(getApplicationContext(), "User password not found!", Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        String sql = "SELECT USER_ID, USER_COMPLETE_NAME, USER_LOGIN, USER_PASSWORD FROM USER_SETUP WHERE USER_LOGIN = '" + v_userID + "'";
                        //Toast.makeText(getApplicationContext(), ""+sql, Toast.LENGTH_SHORT).show();
                        Statement stmt = connection.createStatement();
                        resultSet = stmt.executeQuery(sql);
                        //Toast.makeText(getApplicationContext(), ""+resultSet.getString(1), Toast.LENGTH_SHORT).show();
                        if (!resultSet.next()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), "User not found!", Toast.LENGTH_SHORT).show();
                        }else{
                                user_id = resultSet.getString(1);
                                user_name = resultSet.getString(2);
                                login_id = resultSet.getString(3);
                                user_password = resultSet.getString(4);

                            //Toast.makeText(getApplicationContext(), "Result: "+"\n"+user_id+"\n"+login_id+"\n"+user_password, Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            if ((login_id.equals(v_userID)) && (user_password.equals( v_userPassword))){
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
