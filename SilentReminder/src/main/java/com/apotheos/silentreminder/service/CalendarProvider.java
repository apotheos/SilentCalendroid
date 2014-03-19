package com.apotheos.silentreminder.service;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.apotheos.silentreminder.model.Calendar;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import android.provider.CalendarContract.Calendars;

public class CalendarProvider {

    private Context mContext;

    public CalendarProvider(Context aContext) {
        mContext = aContext;
    }

    public Collection<Calendar> getCalendars() {
        Set<Calendar> calendars = new HashSet<Calendar>();

        String[] columns = new String[]{
                Calendars._ID,
                Calendars.ACCOUNT_NAME,
                Calendars.CALENDAR_DISPLAY_NAME,
                Calendars.CALENDAR_COLOR,
                Calendars.VISIBLE,
                Calendars.DELETED
        };

        Cursor cursor = mContext.getContentResolver().query(
                Calendars.CONTENT_URI,
                columns,
                null,
                new String[]{},
                null
        );

        if (cursor == null) { return null; }

        cursor.moveToFirst();

        Log.d("CALENDAR", "Calendar query. Number of results: " + cursor.getCount());

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            Calendar c = new Calendar();

            c.id = cursor.getLong(0);
            c.accountName = cursor.getString(1);
            c.displayName = cursor.getString(2);
            c.color = cursor.getInt(3);
            c.deleted = (cursor.getInt(4) == 1);
            c.visible = (cursor.getInt(5) == 1);

            calendars.add(c);

            Log.d("CALENDAR", c.toString());
        }

        return calendars;
    }
}
