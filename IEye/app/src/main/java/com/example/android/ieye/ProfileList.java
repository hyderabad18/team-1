package com.example.android.ieye;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProfileList extends BaseAdapter
{

    private Context context;
    private List<Profile> profileList;

    public ProfileList(Context context, List<Profile> profileList) {
        this.context = context;
        this.profileList = profileList;
    }

    @Override
    public int getCount() {
        return profileList.size();
    }

    @Override
    public Object getItem(int i) {
        return profileList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(context,R.layout.profile_list,null);
        TextView first_name=(TextView) v.findViewById(R.id.First_name);
        TextView last_name=(TextView) v.findViewById(R.id.Last_name);
        TextView month=(TextView) v.findViewById(R.id.month);
        TextView year=(TextView) v.findViewById(R.id.year);
        TextView day=(TextView) v.findViewById(R.id.day);

        TextView email=(TextView) v.findViewById(R.id.email);
        TextView phone_no=(TextView) v.findViewById(R.id.mobile_no);
        TextView work_no=(TextView) v.findViewById(R.id.work_no);

        TextView add_lane_1=(TextView) v.findViewById(R.id.add_lane_1);
        TextView add_lane_2=(TextView) v.findViewById(R.id.add_lane_2);
        TextView country=(TextView) v.findViewById(R.id.country);
        TextView state=(TextView) v.findViewById(R.id.state);
        TextView pin_code=(TextView) v.findViewById(R.id.pin_code);




        first_name.setText(profileList.get(i).getFirst_name());
        last_name.setText(profileList.get(i).getLast_name());
        month.setText(profileList.get(i).getMonth());
        year.setText(profileList.get(i).getYear());
        day.setText(profileList.get(i).getDay());

        email.setText(profileList.get(i).getEmail());
        phone_no.setText(profileList.get(i).getPhone_no());
        work_no.setText(profileList.get(i).getWork_no());

        add_lane_1.setText(profileList.get(i).getAdd_lane_1());
        add_lane_2.setText(profileList.get(i).getAdd_lane_2());
        country.setText(profileList.get(i).getCountry());
        state.setText(profileList.get(i).getState());
        pin_code.setText(profileList.get(i).getPin_code());


        v.setTag(profileList.get(i).getId());

        return v;
    }
}

