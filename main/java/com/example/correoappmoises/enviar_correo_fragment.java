package com.example.correoappmoises;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.correoappmoises.databinding.FragmentEnviarCorreoFragmentBinding;
import com.example.correoappmoises.ui.Model.CorreoBorrador;
import com.example.correoappmoises.ui.Model.CorreoEnviados;
import com.example.correoappmoises.ui.gallery.GalleryViewModel;
import com.example.correoappmoises.ui.slideshow.SlideshowViewModel;


public class enviar_correo_fragment extends Fragment {

    private FragmentEnviarCorreoFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState


    ) {
        // creado e inflado ya
        binding = FragmentEnviarCorreoFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText emisor= binding.emisor;
        EditText destinatario= binding.destinatario;
        EditText asunto= binding.asunto;
        EditText mensaje= binding.cuerpoMensaje;

        binding.imgEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CorreoEnviados correo= new CorreoEnviados(emisor.getText().toString(),destinatario.getText().toString(),
                        asunto.getText().toString(),mensaje.getText().toString());
                SlideshowViewModel correosEnviadosModel = new ViewModelProvider(requireActivity()).get(SlideshowViewModel.class);
                correosEnviadosModel.onClickAlta(correo);
                NavHostFragment.findNavController(enviar_correo_fragment.this).navigate(R.id.action_enviar_correo_fragment_to_nav_slideshow);

            }
        });
        binding.imgBorrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CorreoBorrador borrador =new CorreoBorrador(emisor.getText().toString(),destinatario.getText().toString(),
                        asunto.getText().toString(),mensaje.getText().toString());
                GalleryViewModel correosBorradorModel = new ViewModelProvider(requireActivity()).get(GalleryViewModel.class);
                correosBorradorModel.onClickAlta(borrador);

                NavHostFragment.findNavController(enviar_correo_fragment.this).navigate(R.id.action_enviar_correo_fragment_to_nav_gallery);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}