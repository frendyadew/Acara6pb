package com.frendy.acara6pb;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Menghubungkan fragment ke layout fragment_welcome.xml
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        // Menambahkan tombol keluar
        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            // Kembali ke Login Fragment
            ((MainActivity) getActivity()).showLoginFragment();
        });

        return view;
    }
}
