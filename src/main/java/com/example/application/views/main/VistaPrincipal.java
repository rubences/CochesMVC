package com.example.application.views.main;

import java.lang.annotation.*;
import java.util.List;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.html.NativeButton;



public class VistaPrincipal extends AppLayout
    implements Observador {
  private static final long serialVersionUID = 1L;
  BaseVehiculos modelo;

  private AppLayout mainLayout;

  private Native menuSeleccion;

  private NativeButton botonAnuncioSiguiente;

  private Label campoPrecio;

  private Label campoModelo;

  private Label campoMarca;

  private Label campoAnuncio;

  private Label labelPrecio;

  private Label labelModelo;

  private Label labelMarca;

  public VistaPrincipal(BaseVehiculos modelo) {
    this.modelo = modelo;
    buildMainLayout();
    setCompositionRoot(mainLayout);
    modelo.agrega(this);
    menuSeleccion
        .addListener(new ControladorMenuSeleccion(modelo));
    botonAnuncioSiguiente
        .addListener(new ControladorBotonAnuncioSiguiente(
            modelo, this));
    actualiza();
  }


  private AppLayout buildMainLayout() {
    // common part: create layout
    mainLayout = new AppLayout();
    mainLayout.setImmediate(false);
    mainLayout.setWidth("540px");
    mainLayout.setHeight("520px");
    mainLayout.setMargin(false);
    // top-level component properties
    setWidth("540px");
    setHeight("520px");
    // labelMarca
    labelMarca = new Label();
    labelMarca.setImmediate(false);
    labelMarca.setWidth("-1px");
    labelMarca.setHeight("-1px");
    labelMarca.setValue("Marca");
    mainLayout.addComponent(
        labelMarca, "top:140.0px;left:49.0px;");
    // labelModelo
    labelModelo = new Label();
    labelModelo.setImmediate(false);
    labelModelo.setWidth("51px");
    labelModelo.setHeight("-1px");
    labelModelo.setValue("Modelo");
    mainLayout.addComponent(
        labelModelo, "top:180.0px;left:49.0px;");
    // labelPrecio
    labelPrecio = new Label();
    labelPrecio.setImmediate(false);
    labelPrecio.setWidth("-1px");
    labelPrecio.setHeight("-1px");
    labelPrecio.setValue("Precio");
    mainLayout.addComponent(
        labelPrecio, "top:220.0px;left:49.0px;");
    // campoAnuncio
    campoAnuncio = new Label();
    campoAnuncio.setWidth("331px");
    campoAnuncio.setHeight("140px");
    mainLayout.addComponent(
        campoAnuncio, "top:320.0px;left:49.0px;");
    // campoMarca
    campoMarca = new Label();
    campoMarca.setWidth("240px");
    campoMarca.setHeight("-1px");
    mainLayout.addComponent(
        campoMarca, "top:134.0px;left:140.0px;");
    // campoModelo
    campoModelo = new Label();
    campoModelo.setWidth("240px");
    campoModelo.setHeight("-1px");
    mainLayout.addComponent(
        campoModelo, "top:174.0px;left:140.0px;");
    // campoPrecio
    campoPrecio = new Label();
    campoPrecio.setWidth("240px");
    campoPrecio.setHeight("-1px");
    mainLayout.addComponent(
        campoPrecio, "top:216.0px;left:140.0px;");
    // botonAnuncioSiguiente
    botonAnuncioSiguiente = new NativeButton();
    botonAnuncioSiguiente.setCaption("Anuncio siguiente");
    botonAnuncioSiguiente.setImmediate(true);
    botonAnuncioSiguiente.setWidth("120px");
    botonAnuncioSiguiente.setHeight("-1px");
    mainLayout.addComponent(
        botonAnuncioSiguiente, "top:262.0px;left:140.0px;");
    // menuSeleccion
    menuSeleccion = new NativeSelect();
    menuSeleccion.setImmediate(true);
    menuSeleccion.setNullSelectionAllowed(false);
    menuSeleccion.setWidth("240px");
    menuSeleccion.setHeight("23px");
    mainLayout.addComponent(
        menuSeleccion, "top:60.0px;left:140.0px;");
    return mainLayout;
  }

  public void actualiza () {
    menuSeleccion.removeAllItems();
    List<BaseVehiculos.VehiculoDescripcion> listaVehiculos =
        modelo
            .getListaVehiculos();
    int indiceVehiculoEnCurso =
        modelo.getIndiceVehiculoEnCurso();
    for (BaseVehiculos.VehiculoDescripcion
     descripcion : listaVehiculos) {
      menuSeleccion.addItem(descripcion);
      if (descripcion.getIndice() == indiceVehiculoEnCurso)
        menuSeleccion.select(descripcion);
    }
    campoMarca.setValue(modelo.getMarcaEnCurso());
    campoModelo.setValue(modelo.getModeloEnCurso());
    campoPrecio.setValue(modelo.getPrecioEnCurso());
  }

  public void muestraAnuncio(int indiceAnuncio) {
    campoAnuncio.setValue(modelo.getAnuncio(indiceAnuncio));
  }
}
 