package com.example.finalprojectjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.finalprojectjava.room.AdapterRecycleView;
import com.example.finalprojectjava.room.AppDatabase;
import com.example.finalprojectjava.room.ItemModel;
import com.example.finalprojectjava.room.Mahasiswa;
import com.example.finalprojectjava.room.MyItem;
import com.example.finalprojectjava.util.PreferencesHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private Button btnTambah;
    private ImageButton BtnLogout;
    private Mahasiswa user;
    SearchView searchView;
    RecyclerView recyclerView;
    AdapterRecycleView recyclerViewAdapter;
    ArrayList<ItemModel> data;


    PreferencesHelper preferencesHelper;
    SharedPreferences.Editor editor;
    private LinearLayoutManager recyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());
        editor = preferencesHelper.preferences().edit();

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.item_search);
        recyclerView.setHasFixedSize(true);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        for (int i = 0; i < MyItem.Judul.length; i++) {
            data.add(new ItemModel(
                    MyItem.Judul[i],
                    MyItem.Pengarang[i],
                    MyItem.Tahun[i],
                    MyItem.cover[i],
                    MyItem.Isi[i]
            ));
        }

        recyclerViewAdapter = new AdapterRecycleView(this, data);
        recyclerView.setAdapter(recyclerViewAdapter);

        user = (Mahasiswa) getIntent().getSerializableExtra("Mahasiswa");
        BtnLogout = findViewById(R.id.btnLogout);

        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (!preferencesHelperOut.isLogOut()) {
                editor.clear();
                editor.commit();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<ItemModel> itemFilter = new ArrayList<>();
                for (ItemModel model : data) {
                    String judul = model.getJudul().toLowerCase();
                    String pengarang = model.getPengarang().toLowerCase();
                    String tahun = model.getTahun().toLowerCase();
                    if (judul.contains(newText)) {
                        itemFilter.add(model);
                    }
                    else if (pengarang.contains(newText)) {
                        itemFilter.add(model);
                    }
                    else if (tahun.contains(newText)) {
                        itemFilter.add(model);
                    }
                }
                recyclerViewAdapter.setFilter(itemFilter);
                return true;
            }



//            @Override
//            public boolean onQueryTextChange(String newText) {
//                newText = newText.toLowerCase();
//                ArrayList<ItemModel> itemFilter = new ArrayList<>();
//                for(ItemModel model : data){
//                    String judul = model.getJudul().toLowerCase();
//                    if (judul.contains(newText)){
//                        itemFilter.add(model);
//                    }
//                }
//                recyclerViewAdapter.setFilter(itemFilter);
//                return true;
//            }
        });
    }
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.item_search, menu);
//        SearchView searchView = (SearchView) menu.findItem(R.id.itemsearch).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                newText = newText.toLowerCase();
//                ArrayList<ItemModel> itemFilter = new ArrayList<>();
//                for(ItemModel model : data){
//                    String judul = model.getJudul().toLowerCase();
//                    if (judul.contains(newText)){
//                        itemFilter.add(model);
//                    }
//                }
//                recyclerViewAdapter.setFilter(itemFilter);
//                return true;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//
//    }