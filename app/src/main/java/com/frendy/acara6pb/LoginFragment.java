package com.frendy.acara6pb;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Menghubungkan fragment ke layout fragment_login.xml
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Mengambil referensi tombol login
        Button btnLogin = view.findViewById(R.id.btnLogin);

        // Menambahkan listener untuk tombol login
        btnLogin.setOnClickListener(v -> {
            // Menampilkan Toast saat tombol diklik
            Toast.makeText(getActivity(), "Login Berhasil", Toast.LENGTH_SHORT).show();

            // Memanggil showWelcomeFragment() di MainActivity
            ((MainActivity) getActivity()).showWelcomeFragment();
        });

        return view;
    }
}
