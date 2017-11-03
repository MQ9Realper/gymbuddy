package com.gymbuddy.gymbuddy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.gymbuddy.gymbuddy.R;
import com.gymbuddy.gymbuddy.utils.UniversalUtils;
import com.gymbuddy.gymbuddy.views.Btn;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private UniversalUtils universalUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        universalUtils = new UniversalUtils(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initToolbar();

        initViews();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSignIn);
        toolbar.setTitle("Sign In");
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        universalUtils.centerToolbarTitle(toolbar);
        setSupportActionBar(toolbar);
    }

    private void initViews(){
        Btn btnSignIn = (Btn) findViewById(R.id.btnCompleteSignIn);

        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCompleteSignIn:
                Intent intent = new Intent(SignInActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
