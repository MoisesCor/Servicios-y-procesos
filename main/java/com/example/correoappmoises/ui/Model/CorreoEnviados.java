package com.example.correoappmoises.ui.Model;

public class CorreoEnviados {
    private int uid=0;
    private String from;
    private String to;
    private String asunto;
    private String mensaje;

    public CorreoEnviados( String from, String to, String asunto, String mensaje) {
        this.uid++;
        this.from = from;
        this.to = to;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
