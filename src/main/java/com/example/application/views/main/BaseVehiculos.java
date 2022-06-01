package com.example.application.views.main;
import java.util.ArrayList;   
import java.util.List;   
   
public class BaseVehiculos extends Sujeto {   
  public class VehiculoDescripcion {   
    private int indice;   
    private String descripcion;   
   
    public VehiculoDescripcion(int indice,   
        String descripcion) {   
      super();   
      this.indice = indice;   
      this.descripcion = descripcion;   
    }   
   
    public int getIndice() {   
      return indice;   
    }   
   
    public String getDescripcion() {   
      return descripcion;   
    }   
   
    @Override   
    public String toString() {   
      return getDescripcion();   
    }   
  }   
   
  private class Vehiculo {   
    private String marca, modelo;   
    private int precio;   
    private String[] anuncios;   
   
    public Vehiculo(String marca, String modelo,   
        int precio, String[] anuncio) {   
      super();   
      this.marca = marca;   
      this.modelo = modelo;   
      this.precio = precio;   
      this.anuncios = anuncios;   
    }   
   
    public String getMarca() {   
      return marca;   
    }   
   
    public String getModelo() {   
      return modelo;   
    }   
   
    public int getPrecio() {   
      return precio;   
    }   
   
    public String[] getAnuncios() {   
      return anuncios;   
    }   
  }   
   
  protected Vehiculo[] vehiculos = new Vehiculo[] {   
      new Vehiculo("Auto", "KV12", 10000, new String[] {   
          "Buen coche",   
          "Lata de sardinas", "Desaconsejado" }),   
      new Vehiculo("Auto", "KV14", 12500,   
          new String[] {   
              "Muy buen vehículo", "Demasiado caro",   
              "Aceptable" }),   
      new Vehiculo("Auto++", "KDY1250", 2500,   
          new String[] {   
              "Excelente vehículo",   
              "Buena relación calidad/precio" }),   
      new Vehiculo("Desconocido", "XYZ", 15005,   
          new String[] {}) };   
  protected int indiceVehiculoEnCurso = 0;   
   
  public List<VehiculoDescripcion> getListaVehiculos() {   
    int indice = 0;   
    List<VehiculoDescripcion> result =   
        new ArrayList<VehiculoDescripcion>();   
    for (Vehiculo vehiculo : vehiculos) {   
      result.add(new VehiculoDescripcion(indice, vehiculo   
          .getMarca()   
          +   
          " : " + vehiculo.getModelo()));   
      indice++;   
    }   
    return result;   
  }   
   
  public void setIndiceVehiculoEnCurso(int indice) {   
    if ((indice >= 0) && (indice < vehiculos.length)   
        && (indiceVehiculoEnCurso != indice)) {   
      indiceVehiculoEnCurso = indice;   
      notifica();   
    }   
  }   
   
  public int getIndiceVehiculoEnCurso() {   
    return indiceVehiculoEnCurso;   
  }   
   
  String getMarcaEnCurso() {   
    return vehiculos[indiceVehiculoEnCurso].getMarca();   
  }   
  
  String getModeloEnCurso() {   
    return vehiculos[indiceVehiculoEnCurso].getModelo();   
  }   
   
  int getPrecioEnCurso() {   
    return vehiculos[indiceVehiculoEnCurso].getPrecio();   
  }   
   
  int getNumAnuncios() {   
    return vehiculos[indiceVehiculoEnCurso].getAnuncios().length; 
  }   
   
  String getAnuncio(int indiceAnuncio) {   
    if (indiceAnuncio >= vehiculos[indiceVehiculoEnCurso]   
        .getAnuncios().length)   
      return "";   
    else   
      return vehiculos[indiceVehiculoEnCurso].  
       getAnuncios()[indiceAnuncio];   
  }   
}
 
