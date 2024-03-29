package com.example.massage_parlor.ui.home;

import static com.example.massage_parlor.RegistrationOrLogin.getUserData;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.massage_parlor.MainActivity;
import com.example.massage_parlor.RegistrationOrLogin;
import com.example.massage_parlor.databinding.FragmentHomeBinding;

import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        super.onCreate(savedInstanceState);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final TextView text_balance = binding.textBalance;


        // Получение данных пользователя из метода getUserData
        Map<String, String> userData = getUserData(this.requireContext());
        String name = userData.get("name");
        String surname = userData.get("surname");
        String balance = userData.get("balance");

        textView.setText("Привет - " + name + "," + surname + "!");
        text_balance.setText("Ваш баланс - " + balance);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}