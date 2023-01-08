package com.example.correoappmoises.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.correoappmoises.databinding.EnviadoItemBinding;
import com.example.correoappmoises.ui.Model.CorreoEnviados;
import com.example.correoappmoises.ui.Model.CorreoEnviadosRepository;

import java.util.List;

public class SlideShowAdapter extends ArrayAdapter {
    private Context ctx;
    private int layoutemplate;
    List<CorreoEnviados> enviados;
    EnviadoItemBinding binding;
   private  CorreoEnviadosRepository repository= new CorreoEnviadosRepository();
    public SlideShowAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        ctx=context;
        layoutemplate= resource;
        enviados= objects;
    }

    //Creamos el getView

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        binding= EnviadoItemBinding.inflate(LayoutInflater.from(ctx),parent,false);
        TextView emisor= binding.emisorItem;
        TextView destino= binding.destinatarioItem;
        TextView asunto= binding.asuntoItem;
        TextView mensaje= binding.cuerpoItem;
        emisor.setText(enviados.get(position).getFrom());
        destino.setText(enviados.get(position).getTo());
        asunto.setText(enviados.get(position).getAsunto());
        mensaje.setText(enviados.get(position).getMensaje());

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
