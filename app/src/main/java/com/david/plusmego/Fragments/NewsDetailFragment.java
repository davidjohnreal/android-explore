package com.david.plusmego.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.david.plusmego.R;

public class NewsDetailFragment extends Fragment {
    private static final String ARG_NEWS_TITLE = "news_title";
    public static NewsDetailFragment newInstance(String newsTitle){
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NEWS_TITLE,newsTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_news_detail,container,false);
        TextView titleTextView = view.findViewById(R.id.text_view_news_title);
        TextView contentTextView = view.findViewById(R.id.text_view_news_content);
        if(getArguments() != null){
            String newsTitle = getArguments().getString(ARG_NEWS_TITLE);
            titleTextView.setText(newsTitle);
            contentTextView.setText("这里是新闻\""+newsTitle+"\"的完整详细内容。阅读更多。。。。");
        }
        return view;
    }
}
