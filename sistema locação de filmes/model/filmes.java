package model;

public class Filme {
    private String titulo;
    private int ano;
    private String genero;
    private double valorLocacao;

    public Filme(String titulo, int ano, String genero, double valorLocacao) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.valorLocacao = valorLocacao;
    }
    
    public String getTitulo() { return titulo; }
    public double getValorLocacao() { return valorLocacao; }
}