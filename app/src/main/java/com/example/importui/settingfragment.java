package com.example.importui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class settingfragment extends Fragment {
    View view;
    ListView menu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view=inflater.inflate(R.layout.fragment_setting,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menu=(ListView)view.findViewById(R.id.lvSet);
        String [] item=new String[]{"Profile","Acoount","About us","Help"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,android.R.id.text1,item);
        menu.setAdapter(adapter);
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent i=new Intent(view.getContext(),user_profile.class);
                    startActivity(i);
                }
                if(position==1){
                    Intent i=new Intent(view.getContext(),user_account.class);
                    startActivity(i);
                }
                if(position==2){
                    Intent i=new Intent(view.getContext(),user_profile.class);
                    startActivity(i);
                }
                if(position==3){
                    Intent i=new Intent(view.getContext(),user_profile.class);
                    startActivity(i);
                }
            }
        });
    }
}
