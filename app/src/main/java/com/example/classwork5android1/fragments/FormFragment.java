package com.example.classwork5android1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classwork5android1.MainActivity;
import com.example.classwork5android1.R;
import com.example.classwork5android1.databinding.FragmentFormBinding;

public class FormFragment extends Fragment {
    private MainActivity activity;
    private FragmentFormBinding binding;

    public FormFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) requireActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        activity.hideBottomNavigation();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSave.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("name",binding.etName.getText().toString());
            bundle.putString("number",binding.etNumber.getText().toString());
            FormFragment.this.getActivity().getSupportFragmentManager().setFragmentResult("form",bundle);
            FormFragment.this.getActivity().getSupportFragmentManager().popBackStack();
        });
    }

}