package com.univ_amu.food_scanner.ui;

import android.content.res.Resources;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ConverterUtil {
    @BindingAdapter("app:date")
    public static void setDate(TextView view, Date date) {
        if (date==null) return;
        Resources resources = view.getContext().getApplicationContext().getResources();
        view.setText(getStringFromDate(resources,date));
    }

    private static String getStringFromDate(Resources resources, Date date) {
        LocalDate today = LocalDate.now();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int dayCount = (int) ChronoUnit.DAYS.between(localDate, today);
        int monthCount = (int) ChronoUnit.MONTHS.between(localDate, today);
        int yearCount = (int) ChronoUnit.YEARS.between(localDate, today);
        if (dayCount == 0)
            return "" /* TODO */;
        if (yearCount >= 1)
            return "" /* TODO */;
        if (monthCount >= 1)
            return "" /* TODO */;
        return "" /* TODO */;
    }
}