package com.cbalt.miindicadorexample.views.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cbalt.miindicadorexample.R;
import com.cbalt.miindicadorexample.models.Wrapper;
import com.cbalt.miindicadorexample.network.GetIndicatorByDate;
import com.cbalt.miindicadorexample.views.DatePickerFragment;
import com.cbalt.miindicadorexample.views.listener.DatePickerCallback;

public class MainActivity extends AppCompatActivity implements DatePickerCallback {

    TextView ufTextView, dolarTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ufTextView = findViewById(R.id.ufTextView);
        dolarTextView = findViewById(R.id.dolarTextView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = DatePickerFragment.newInstance();
                dialogFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });
    }

    @Override
    public void setDate(String date) {
        new BackgroundUF().execute("uf", date);
        new BackgroundDolar().execute("dolar", date);
    }

    private class BackgroundUF extends GetIndicatorByDate {

        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Wrapper wrapper) {
            if(wrapper != null){
                ufTextView.setText(String.valueOf(wrapper.getSerie()[0].getValor()));
            }
            progressDialog.dismiss();
        }
    }

    private class BackgroundDolar extends GetIndicatorByDate {

        @Override
        protected void onPostExecute(Wrapper wrapper) {
            if(wrapper != null){
                dolarTextView.setText(String.valueOf(wrapper.getSerie()[0].getValor()));
            }
        }
    }


}
