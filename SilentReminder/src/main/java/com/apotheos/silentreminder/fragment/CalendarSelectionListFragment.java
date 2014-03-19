package com.apotheos.silentreminder.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.apotheos.silentreminder.R;
import com.apotheos.silentreminder.adapter.CalendarListAdapter;
import com.apotheos.silentreminder.model.Calendar;
import com.apotheos.silentreminder.service.CalendarProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the Callbacks interface.
 */
public class CalendarSelectionListFragment extends ListFragment {

    private AbsListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("CALENDAR", "In CalendarSelectionListFragment.onCreateView");
        View view = inflater.inflate(R.layout.fragment_calendar_list, container, false);
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CALENDAR", "In CalendarSelectionListFragment.onActivityCreated");

        CalendarProvider calendarProvider = new CalendarProvider(getActivity());
        List<Calendar> calendars = new ArrayList<Calendar>(calendarProvider.getCalendars());
        CalendarListAdapter calendarListAdapter = new CalendarListAdapter(getActivity(), R.layout.fragment_calendar_item, calendars);

        Log.d("CALENDAR", "Calendars: " + calendars.size());

        Log.d("CALENDAR", "Setting calendar adapter.");
        mListView.setAdapter(calendarListAdapter);
    }
}
