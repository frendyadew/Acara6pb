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


public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Menghubungkan fragment ke layout fragment_register.xml
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Mengambil referensi tombol daftar
        Button btnRegister = view.findViewById(R.id.btnRegister);

        // Menambahkan listener untuk tombol daftar
        btnRegister.setOnClickListener(v -> {
            // Menampilkan Toast saat tombol diklik
            Toast.makeText(getActivity(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();

            // Memanggil showWelcomeFragment() di MainActivity
            ((MainActivity) getActivity()).showWelcomeFragment();
        });

        return view;
    }
}
