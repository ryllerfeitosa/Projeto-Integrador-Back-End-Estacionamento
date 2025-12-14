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
}



