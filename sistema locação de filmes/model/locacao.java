package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Locacao {
    private Date data;
    private double valorTotal;
    private List<Filme> listaFilmes;

    public Locacao() {
        this.data = new Date();
        this.listaFilmes = new ArrayList<>();
        this.valorTotal = 0;
    }

    public void addFilme(Filme filme) {
        this.listaFilmes.add(filme);
        this.valorTotal += filme.getValorLocacao();
    }
    
    public Date getData() { return data; }
    public double getValorTotalAPagar() { return valorTotal; }
    public List<Filme> getListaFilmes() { return listaFilmes; }
}