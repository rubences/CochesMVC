package com.example.application.views.main;

import java.net.http.WebSocket.Listener;

import com.vaadin.flow.component.ClickEvent;

public class ControladorBotonAnuncioSiguiente extends   
    Controlador implements   
    Listener, Observador {   
  private static final long serialVersionUID = 1L;   
  protected int indiceAnuncioEnCurso;   
  protected int numAnuncios;   
   
  public ControladorBotonAnuncioSiguiente(   
      BaseVehiculos modelo, VistaPrincipal vistaPrincipal) {   
    super();   
    this.modelo = modelo;   
    this.vista = vistaPrincipal;   
    modelo.agrega(this);   
    actualiza();   
  }   
   
  public void buttonClick(ClickEvent event) {   
    indiceAnuncioEnCurso++;   
    if (indiceAnuncioEnCurso == numAnuncios)   
     indiceAnuncioEnCurso = 0;   
    vista.muestraAnuncio(indiceAnuncioEnCurso);   
  }   
   
  public void actualiza() {   
    numAnuncios = modelo.getNumAnuncios();   
    indiceAnuncioEnCurso = 0;   
    vista.muestraAnuncio(indiceAnuncioEnCurso);   
  }   
}
 