package com.example.mytherapy.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mytherapy.R;
import com.example.mytherapy.databinding.FragmentMainBinding;
import com.example.mytherapy.db.MyDatabaseHelper;
import com.example.mytherapy.db.User;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.List;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    MyDatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<User> homeItems;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        binding.fabAddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItem addMedicineDialog = new AddItem(MainFragment.this);
                addMedicineDialog.show(getFragmentManager(), "Add_Dialog");
            }
        });
        return binding.getRoot();
    }

    public void loadMedicines() {
        databaseHelper = new MyDatabaseHelper(getContext());
        homeItems = databaseHelper.getMedicineList();
        adapter = new MainAdapter(homeItems, getActivity());
        recyclerView.setAdapter(adapter);
    }
}