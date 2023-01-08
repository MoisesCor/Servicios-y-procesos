package com.example.correoappmoises.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.correoappmoises.databinding.BorradorItemBinding;
import com.example.correoappmoises.databinding.EnviadoItemBinding;
import com.example.correoappmoises.ui.Model.CorreoBorrador;
import com.example.correoappmoises.ui.Model.CorreoEnviados;

import java.util.List;

public class GalleryAdapter extends ArrayAdapter {
    private Context ctx;
    private int layoutemplate;
    List<CorreoBorrador> borrador;
    BorradorItemBinding binding;

    public GalleryAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        ctx=context;
        layoutemplate= resource;
        borrador= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        binding= BorradorItemBinding.inflate(LayoutInflater.from(ctx),parent,false);
        TextView emisor= binding.emisorItem;
        TextView destino= binding.destinatarioItem;
        TextView asunto= binding.asuntoItem;
        TextView mensaje= binding.cuerpoItem;
        emisor.setText(borrador.get(position).getFrom());
        destino.setText(borrador.get(position).getTo());
        asunto.setText(borrador.get(position).getAsunto());
        mensaje.setText(borrador.get(position).getMensaje());

        //Boton borrar
        ImageView borrar=binding.papelera;
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        return binding.getRoot();
    }
}




