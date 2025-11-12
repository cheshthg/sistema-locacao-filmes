package principal;

import model.Cliente;
import model.Conta;
import model.Filme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Silêncio. Um letreiro pisca. Uma fita gira. A cidade dorme. Só resta você e o próximo filme.");
        System.out.println("----------------------------------------------------------------------\n");

        List<Filme> catalogoFilmes = new ArrayList<>(Arrays.asList(
    List<Filme> catalogoFilmes = new ArrayList<>(Arrays.asList(
    new Filme("Pearl", 2022, "Terror/Slasher", 7.50),
    new Filme("X", 2022, "Terror/Slasher", 7.50),
    new Filme("MaXXXine", 2024, "Terror/Slasher", 9.00),
    new Filme("Lady Bird", 2017, "Drama/Comédia Dramática", 6.80),
    new Filme("Wicked: Parte 1", 2024, "Musical/Fantasia", 9.50),
    new Filme("Pânico 3", 2000, "Terror/Mistério", 5.50),
    new Filme("Chainsaw Man: Arco de Reze", 2023, "Ação/Horror/Anime", 8.00),
    new Filme("A Substância", 2024, "Ficção Científica/Terror", 9.20),
    new Filme("Anora", 2024, "Drama/Romance", 8.70),
    new Filme("Alien: Isolation", 2014, "Terror/Ficção Científica", 6.50),
    new Filme("Tudo em Todo Lugar ao Mesmo Tempo", 2022, "Ação/Comédia/Ficção Científica", 9.00),
    new Filme("Cisne Negro", 2010, "Drama/Thriller Psicológico", 7.80)
));



List<Cliente> clientes = Arrays.asList(
        new Cliente("Danilo Farias", "123.456.789-00", "Rua das Flores, 123", "81981234567"),
        new Cliente("Gustavo Ribeiro", "987.654.321-11", "Av. Paulista, 2001", "81992345678"),
        new Cliente("Larissa Moreira", "234.567.890-22", "Travessa do Sol, 45", "81993456789"),
        new Cliente("Irelia Santos", "345.678.901-33", "Rua do Mercado, 78", "81994567890"),
        new Cliente("Renata Glasc", "456.789.012-44", "Alameda das Acácias, 9", "81995678901"),
        new Cliente("Bruno Castro", "567.890.123-55", "Praça Central, 10", "81996789012"),
        new Cliente("Sofia Santino", "678.901.234-66", "Rua das Laranjeiras, 321", "81997890123"),
        new Cliente("Anny Deposy", "789.012.345-77", "Rua Nova Esperança, 7", "81998901234")
);


        List<Conta> contas = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            contas.add(new Conta(clientes.get(i), 2001 + i)); 
        }

        System.out.println("Confirmando seu pagamento...");
        for (Conta conta : contas) {
            int totalLocacoes = 4 + (int) (Math.random() * 3); 
            System.out.printf("- Cliente: %s, %d locações.\n", conta.getCliente().getNome(), totalLocacoes);

            for (int i = 0; i < totalLocacoes; i++) {
                Collections.shuffle(catalogoFilmes);
                int totalFilmesNaLocacao = 1 + (int) (Math.random() * 5); 
                
                List<Filme> filmesParaLocar = new ArrayList<>(catalogoFilmes.subList(0, totalFilmesNaLocacao));
                
                conta.locarFilmes(filmesParaLocar);
            }
            
            double saldoAtual = conta.getSaldoDevedor();
            if (saldoAtual > 10.0) {
                double valorPagamento = saldoAtual * 0.5;
                conta.pagarDebito(valorPagamento);
                System.out.printf("  -> Pagamento de R$ %.2f realizado. Saldo restante: R$ %.2f\n", 
                                  valorPagamento, conta.getSaldoDevedor());
            }
        }
        
        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("d) EXTRATO DE LOCAÇÃO DE CADA CLIENTE DO SISTEMA");
        System.out.println("----------------------------------------------------------------------");

        for (Conta conta : contas) {
            System.out.println(conta.extratoHistorico());
        }
    }
}