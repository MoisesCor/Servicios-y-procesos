package com.example.correoappmoises.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.correoappmoises.ui.Model.CorreoEnviados;
import com.example.correoappmoises.ui.Model.CorreoEnviadosRepository;

import java.util.List;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<List<CorreoEnviados>> listaEnviados;
    private CorreoEnviadosRepository correoEnviadosRepository;

  public SlideshowViewModel(){
      listaEnviados= new MutableLiveData<>();
      correoEnviadosRepository= new CorreoEnviadosRepository();
  }

    public MutableLiveData<List<CorreoEnviados>> getListaEnviados() {
        return listaEnviados;
    }

    public void onClickAlta(CorreoEnviados correo){
        correoEnviadosRepository.insert(correo);
        //esto es que cada vez que se carga a la lista avise al repositorio para que se actualice
        listaEnviados.postValue(correoEnviadosRepository.getCorreos());
    }
    public void cargaInicial(){ listaEnviados.postValue(correoEnviadosRepository.getCorreos());}

    }