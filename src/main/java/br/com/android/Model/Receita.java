/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.android.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Rafael Delanhese
 */
@Entity
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceita;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idOrigem")
    private Origem origem;
    
    @Column(columnDefinition = "TEXT")
    private String ingredientes;
    @Column(columnDefinition = "TEXT")
    private String modoPreparo;
    private String porcao;
    private String valorEstimado;

    public Receita() {
    }

    public Receita(Long idReceita, String titulo, Categoria categoria, Origem origem, String ingredientes, String modoPreparo, String porcao, String valorEstimado) {
        this.idReceita = idReceita;
        this.titulo = titulo;
        this.categoria = categoria;
        this.origem = origem;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.porcao = porcao;
        this.valorEstimado = valorEstimado;
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getPorcao() {
        return porcao;
    }

    public void setPorcao(String porcao) {
        this.porcao = porcao;
    }

    public String getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(String valorEstimado) {
        this.valorEstimado = valorEstimado;
    }
}
