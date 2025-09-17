package com.david.plusmego.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.OnNewIntentProvider;
import androidx.fragment.app.Fragment;

import com.david.plusmego.R;

public class chooseDialog extends Fragment  {
    public interface onNewSelectListener{
        void onNewsSelected(String selectedButton);
    }
    private onNewSelectListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (onNewSelectListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity must implement OnNewIntentProvider interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }
}
