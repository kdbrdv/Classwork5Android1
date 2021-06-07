package com.example.classwork5android1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classwork5android1.Adapter;
import com.example.classwork5android1.MainActivity;
import com.example.classwork5android1.Model;
import com.example.classwork5android1.R;
import com.example.classwork5android1.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private MainActivity activity;
    private Adapter adapter;
    private Model model;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new Adapter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = (MainActivity) requireActivity();
        activity.showBottomNavigation();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireActivity().getSupportFragmentManager().setFragmentResultListener("form", this, (requestKey, result) -> {
            model = new Model(result.getString("name"), result.getString("number"));
            binding.recycler.setAdapter(adapter);
            adapter.addItems(model);
        });
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null).replace(R.id.fm_container, new FormFragment()).commit();
            }
        });
    }
}