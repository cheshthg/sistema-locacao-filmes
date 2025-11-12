package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Conta {
    private Cliente cliente;
    private int numero;
    private double saldoDevedor;
    private List<Locacao> historicoLocacao;

    public Conta(Cliente cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
        this.saldoDevedor = 0;
        this.historicoLocacao = new ArrayList<>();
    }

    public void locarFilmes(List<Filme> filmes) {
        Locacao novaLocacao = new Locacao();
        for (Filme filme : filmes) {
            novaLocacao.addFilme(filme);
        }
        this.historicoLocacao.add(novaLocacao);
        this.saldoDevedor += novaLocacao.getValorTotalAPagar();
    }

    public void pagarDebito(double valor) {
        if (valor > 0) { this.saldoDevedor -= valor; }
    }

    public String extratoHistorico() {
        StringBuilder extrato = new StringBuilder();
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

        extrato.append("\n.:: Histórico de Locações de ").append(this.cliente.getNome()).append(" ::.\n");
        extrato.append(String.format("%-40s | %-50s | %s\n", "Data da locação", "Lista de filmes", "Valor da locação"));
        extrato.append("-".repeat(110)).append("\n");

        for (Locacao locacao : this.historicoLocacao) {
            String titulos = locacao.getListaFilmes().stream()
                                  .map(Filme::getTitulo)
                                  .collect(Collectors.joining(", "));
            
            extrato.append(String.format("%-40s | %-50s | %s\n", 
                locacao.getData().toString(), titulos, formatadorMoeda.format(locacao.getValorTotal())));
        }
        
        extrato.append("\nSALDO DEVEDOR TOTAL: ").append(formatadorMoeda.format(this.saldoDevedor)).append("\n");
        extrato.append("=".repeat(110)).append("\n");
        
        return extrato.toString();
    }
}