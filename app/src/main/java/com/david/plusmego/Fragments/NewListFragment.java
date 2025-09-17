package com.david.plusmego.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.david.plusmego.R;

import java.util.ArrayList;

public class NewListFragment extends Fragment {
    public interface OnNewsSelectedListener{
        void onNewsSelected(String selectedButton);
    }
    private OnNewsSelectedListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnNewsSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity must implement OnNewsSelectedListener interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ListView listView = view.findViewById(R.id.news_list_view);

        final ArrayList<String> newsTitle = new ArrayList<>();
        newsTitle.add("人工智能取得重大进展");
        newsTitle.add("区块链技术突破");
        newsTitle.add("5G网络普及");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, newsTitle);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedNews = newsTitle.get(position);
                listener.onNewsSelected(selectedNews);
            }
        });
        return view;
    }
}

