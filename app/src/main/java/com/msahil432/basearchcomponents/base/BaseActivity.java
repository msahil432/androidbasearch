package com.msahil432.basearchcomponents.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.arch.lifecycle.Observer;

import androidx.navigation.Navigation;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());

        getViewModel().getData().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                initializeViews();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, getContainerFragment()).navigateUp();
    }

    protected abstract int setLayout();

    protected abstract BaseViewModel getViewModel();

    protected abstract void initializeViews();

    protected abstract int getContainerFragment();
}
