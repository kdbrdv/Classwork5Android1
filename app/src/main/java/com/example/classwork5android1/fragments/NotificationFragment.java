package com.example.classwork5android1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.classwork5android1.databinding.FragmentHomeBinding;
import com.example.classwork5android1.databinding.FragmentNotificationBinding;

public class NotificationFragment extends Fragment {
    FragmentNotificationBinding binding;

    public NotificationFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}