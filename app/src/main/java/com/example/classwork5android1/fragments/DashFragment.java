package com.example.classwork5android1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.classwork5android1.databinding.FragmentDashBinding;
import com.example.classwork5android1.databinding.FragmentHomeBinding;

public class DashFragment extends Fragment {
    FragmentDashBinding binding;

    public DashFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}