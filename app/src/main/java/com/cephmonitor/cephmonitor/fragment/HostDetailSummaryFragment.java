package com.cephmonitor.cephmonitor.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cephmonitor.cephmonitor.InitFragment;
import com.cephmonitor.cephmonitor.layout.fragment.HostDetailSummaryLayout;
import com.cephmonitor.cephmonitor.layout.listitem.HostDetailItem;

import java.util.ArrayList;

public class HostDetailSummaryFragment extends Fragment {
    private HostDetailSummaryLayout layout;
    private ArrayList<String> targetGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (layout == null) {
            layout = new HostDetailSummaryLayout(getActivity());
            init();
        }
        InitFragment.choiceActivity(getActivity(), this);
        return layout;
    }

    public void init() {
        targetGroup = new ArrayList<>();

        Bundle arg = getArguments();
        String hostName = arg.getString("0");

        targetGroup.add("servers." + hostName + ".cpu.total.system");
        targetGroup.add("servers." + hostName + ".cpu.total.user");
        targetGroup.add("servers." + hostName + ".cpu.total.idle");

        layout.list.setAdapter(adapter);
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return targetGroup.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            HostDetailItem item;
            if (view == null) {
                item = new HostDetailItem(getActivity());
            } else {
                item = (HostDetailItem) view;
            }

            item.setName(layout.titleGroup[i]);
            item.setLineText(layout.lineTextGroup[i], layout.colorGroup[i]);
            return item;
        }
    };
}
