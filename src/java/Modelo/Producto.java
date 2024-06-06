/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Producto {
    private int id;
    private String nom;
    private String pre;
    private String sto;
    private String estado;

    public Producto() {
    }

    public Producto(int id, String nom, String pre, String sto, String estado) {
        this.id = id;
        this.nom = nom;
        this.pre = pre;
        this.sto = sto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getSto() {
        return sto;
    }

    public void setSto(String sto) {
        this.sto = sto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
