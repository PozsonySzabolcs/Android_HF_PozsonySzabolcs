package com.example.hf6;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment1Activity extends Fragment {

    protected static final String FRAG2 = "2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment1, container, false);

        ListView list = vw.findViewById(R.id.currencylist);
        CustomListViewAdapter adapter = new CustomListViewAdapter(c);
        list.setAdapter(adapter);

        final FragmentManager fragmentManager = getFragmentManager();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewCurrency = view.findViewById(R.id.name);
                TextView textViewBuyInfo = view.findViewById(R.id.buyView);

                if (fragmentManager.findFragmentByTag(FRAG2) != null) {
                    TextView selectedOpt = (TextView) getActivity().findViewById(R.id.selectedopt);
                    selectedOpt.setText("You have selected " + textViewCurrency.getText().toString() + " "
                            + textViewBuyInfo.getText().toString() + " " + "RON");
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);
                    intent.putExtra("item", textViewCurrency.getText().toString() + " "
                            + textViewBuyInfo.getText().toString() + " " + "RON");
                    startActivity(intent);
                }
            }
        });
        return vw;
    }
}