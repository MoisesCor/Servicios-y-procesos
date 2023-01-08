package com.example.correoappmoises.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class CorreoEnviadosRepository {
    public ArrayList<CorreoEnviados> CorreosEnviados;

    public CorreoEnviadosRepository() {
        this.CorreosEnviados = new ArrayList<>();
        this.CorreosEnviados.add(new CorreoEnviados("mjimenezgarcia3@educa.madrid.org","aaaaa","sdsdsd","asasasa"));
        this.CorreosEnviados.add(new CorreoEnviados("mjimenezgarcia3@educa.madrid.org","bbbba","sdsdsd","asasasa"));
    }

    public List<CorreoEnviados> getCorreos(){
        return CorreosEnviados;
    }

    public void insert (CorreoEnviados correo){
        CorreosEnviados.add(correo);
    }

    public void update (CorreoEnviados correo){

    }

    public void delete (int uid){
        for(CorreoEnviados x: getCorreos()){
            if(x.getUid()==uid){
                CorreosEnviados.remove(x);
            }
        }

    }
}


