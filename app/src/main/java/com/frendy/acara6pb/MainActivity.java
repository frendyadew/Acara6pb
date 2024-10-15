package com.frendy.acara6pb;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private TabLayoutMediator tabMediator;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengatur padding untuk aplikasi edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Menghubungkan TabLayout dan ViewPager2
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Menyinkronkan TabLayout dengan ViewPager2, tanpa Tab Welcome
        tabMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Register");
                    break;
                case 1:
                    tab.setText("Login");
                    break;
            }
        });
        tabMediator.attach();
    }

    // Method untuk menampilkan Login Fragment
    public void showLoginFragment() {
        viewPager.setCurrentItem(1); // Menampilkan LoginFragment
    }

    // Method untuk menambahkan Welcome tab setelah login
    public void showWelcomeFragment() {
        adapter.showWelcomeFragment(true);
        tabMediator.detach();
        tabMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 2) {
                tab.setText("Welcome");
            } else {
                tab.setText(position == 0 ? "Register" : "Login");
            }
        });
        tabMediator.attach();
    }

    private class ViewPagerAdapter extends FragmentStateAdapter {
        private boolean showWelcome = false;

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        public void showWelcomeFragment(boolean show) {
            showWelcome = show;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new RegisterFragment();
                case 1:
                    return new LoginFragment();
                default:
                    return new WelcomeFragment();
            }
        }

        @Override
        public int getItemCount() {
            return showWelcome ? 3 : 2; // Menambah tab Welcome jika diperlukan
        }
    }
}
