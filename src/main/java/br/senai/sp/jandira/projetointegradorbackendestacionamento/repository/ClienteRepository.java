package br.senai.sp.jandira.projetointegradorbackendestacionamento.repository;



import br.senai.sp.jandira.projetointegradorbackendestacionamento.model.DadosDoCliente;
import br.senai.sp.jandira.projetointegradorbackendestacionamento.ui.RegistrarEntrada;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepository {

    public void gravarCliente(DadosDoCliente cliente) {

        LocalDateTime horaAtual = LocalDateTime.now();
        DateTimeFormatter formator = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String horaEntrada = horaAtual.format(formator);

        Path arquivo= Paths.get("C:\\Users\\rylle\\Downloads\\dadosDosClientes\\dados.csv");
        try{
            Files.writeString(arquivo, cliente.nome+ ";" + cliente.carro + ";" + cliente.placa + ";" + horaEntrada + ";" + "\n", StandardOpenOption.APPEND);
        }catch (IOException e){

            System.out.println("Erro ao criar o arquivo");
            System.out.println(e.getMessage());

        }

    }

    public void receberDados (TextField nomeUser, TextField placaCliente, TextField veiculoCliente) {

        RegistrarEntrada registrarEntrada =  new RegistrarEntrada();
        DadosDoCliente cliente = new DadosDoCliente();

        cliente.nome = nomeUser.getText();
        cliente.placa = placaCliente.getText();
        cliente.carro = veiculoCliente.getText();


        gravarCliente(cliente);
    }
}

