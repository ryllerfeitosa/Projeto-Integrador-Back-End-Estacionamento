package br.senai.sp.jandira.projetointegradorbackendestacionamento.model;
import br.senai.sp.jandira.projetointegradorbackendestacionamento.repository.ClienteRepository;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import br.senai.sp.jandira.projetointegradorbackendestacionamento.ui.RegistrarEntrada;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DadosDoCliente {

    public String placa;
    public String carro;
    public String nome;
    public String dataEntrada;
    public String horaEntrada;

    public DadosDoCliente() {
        // Construtor vazio necessário para 'new DadosDoCliente()'
    }

    // Necessário para a função de leitura do CSV
    public DadosDoCliente(String nome, String carro, String placa, String dataEntrada, String horaEntrada) {
        this.nome = nome;
        this.carro = carro;
        this.placa = placa;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
    }

    // O método toString() (crucial para o ListView)
    @Override
    public String toString() {
        return nome + " | " + carro + " | Placa: " + placa + " | Entrada: " + dataEntrada + " às " + horaEntrada;
    }
}


