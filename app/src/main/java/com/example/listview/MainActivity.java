package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvDatos;
    ArrayList<String> list;
    ArrayAdapter<String> adaptador;

    ListView lvSelect;
    ArrayList<String> listSelected;
    ArrayAdapter<String> adaptadorSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDatos = findViewById(R.id.lvDatos);
        list = new ArrayList<>();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list); // contexto, item, lista

        lvSelect = findViewById(R.id.lvDatosSeleccionados);
        listSelected = new ArrayList<>();
        adaptadorSelected = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listSelected); // contexto, item, lista


        cargarItems();
        lvDatos.setAdapter(adaptador);
        lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Elegido: " + list.get(position), Toast.LENGTH_SHORT).show();
                agregarSelected(list.get(position));
                lvSelect.setAdapter(adaptadorSelected);
                // wrap content en List View para que vaya creciendo
                // match parent en List View para que se divida en 50 - 50
            }
        });


    }

    void cargarItems(){
        for (int i = 0; i<100; i++){
            list.add("Item: " + (i+1));
        }
    }

    void agregarSelected(String selected){
        listSelected.add(selected);
    }
}