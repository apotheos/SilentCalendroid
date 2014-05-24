package com.apotheos.silentreminder.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.apotheos.silentreminder.R;
import com.apotheos.silentreminder.model.Calendar;

import java.util.List;

public class CalendarListAdapter extends ArrayAdapter<Calendar> {

    public CalendarListAdapter(Context aContext, int aResource) {
        super(aContext, aResource);
    }

    public CalendarListAdapter(Context aContext, int aResource, List<Calendar> aCalendars) {
        super(aContext, aResource, aCalendars);
        Log.d("CALENDAR", "In CalendarListAdapter");
    }

    @Override
    public View getView(int aPosition, View aConvertView, ViewGroup aParent) {

        View v = aConvertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.fragment_calendar_item, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.calendarNameTextView = (TextView) v.findViewById(R.id.calendarName);
            viewHolder.accountNameTextView = (TextView) v.findViewById(R.id.calendarAccount);
            viewHolder.calendarColorSwatchView = v.findViewById(R.id.calendarColorSwatch);
            v.setTag(viewHolder);
        }

        Calendar calendar = getItem(aPosition);

        ViewHolder viewHolder = (ViewHolder) v.getTag();
        viewHolder.calendarNameTextView.setText(calendar.displayName);
        viewHolder.accountNameTextView.setText(calendar.accountName);
        viewHolder.calendarColorSwatchView.setBackgroundColor(calendar.color);

        return v;
    }

    static class ViewHolder {
        public TextView calendarNameTextView;
        public TextView accountNameTextView;
        public View calendarColorSwatchView;
    }
}
