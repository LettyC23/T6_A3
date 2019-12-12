package com.e.proyecto1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Controlador.ClienteDAO;
import Modelo.Cliente;

public class ActivityConsultas extends Activity implements AdapterView.OnItemSelectedListener{

    private  EditText nc;
    private EditText filtro;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consultas);
        nc = (EditText) findViewById(R.id.et_nombre_buscar);
        filtro = (EditText) findViewById(R.id.et_nombre_buscar);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)



        String s = "2";
        ActivityBuscar ab = new ActivityBuscar();

            mAdapter = new MyAdapter(new ClienteDAO(this).obtenerTodosLosClientes("ana"));
            recyclerView.setAdapter(mAdapter);




    }



    public void ex (View v){

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
private ArrayList<Cliente> mDataset;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView textView;
    public MyViewHolder(TextView v) {
        super(v);
        textView = v;
    }
}

// Provide a suitable constructor (depends on the kind of dataset)
public MyAdapter(ArrayList<Cliente> myDataset) {
    mDataset = myDataset;
}

// Create new views (invoked by the layout manager)
@Override
public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // create a new view
   View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.textview_registros, parent, false);

   TextView tv = v.findViewById(R.id.textview_registros);
    MyViewHolder vh = new MyViewHolder(tv);
    return vh;
}

// Replace the contents of a view (invoked by the layout manager)
@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    holder.textView.setText(mDataset.get(position).toString());

}

// Return the size of your dataset (invoked by the layout manager)
@Override
public int getItemCount() {
    return mDataset.size();
}
}
