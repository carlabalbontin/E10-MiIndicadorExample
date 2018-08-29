package com.cbalt.miindicadorexample.views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import com.cbalt.miindicadorexample.views.listener.DatePickerCallback;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatePickerCallback callback;

    public static DatePickerFragment newInstance(){
        return new DatePickerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (DatePickerCallback) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day );
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date = String.valueOf(i2) + "-" + String.valueOf(i1) + "-" + String.valueOf(i);
        callback.setDate(date);
    }
}
