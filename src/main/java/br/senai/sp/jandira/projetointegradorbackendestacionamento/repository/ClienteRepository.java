package br.senai.sp.jandira.projetointegradorbackendestacionamento.repository;



import br.senai.sp.jandira.projetointegradorbackendestacionamento.model.DadosDoCliente;
import br.senai.sp.jandira.projetointegradorbackendestacionamento.ui.RegistrarEntrada;
import javafx.scene.control.TextField;


import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepository {

    public void gravarCliente(DadosDoCliente cliente) {

        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
        String dataEntrada = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horaEntrada = horaAtual.format(DateTimeFormatter.ofPattern("HH:mm"));

        Path arquivo= Paths.get("D:\\dadosDosClientes\\dados.csv");
        try{
            Files.writeString(arquivo, cliente.nome+ ";" + cliente.carro + ";" + cliente.placa + ";" + dataEntrada + ";" + horaEntrada + ";" + "\n", StandardOpenOption.APPEND);
        }catch (IOException e){

            System.out.println("Erro ao criar o arquivo");
            System.out.println(e.getMessage());

        }

    }

    private final Path arquivo = Paths.get("D:\\dadosDosClientes\\dados.csv");
    private final String separador = ";"; // O separador do seu CSV
    public List<DadosDoCliente> listarTodos() {
        List<DadosDoCliente> clientes = new ArrayList<>();

        try {
            // Ler todas as linhas do arquivo
            List<String> todasAsLinhas = Files.readAllLines(arquivo);

            // Pular a primeira linha (cabeçalho)
            for (int i = 1; i < todasAsLinhas.size(); i++) {
                String linha = todasAsLinhas.get(i);

                // Ignorar linhas vazias
                if (linha.trim().isEmpty()) {
                    continue;
                }

                // Dividir a linha usando o separador
                String[] dados = linha.split(separador);

                // Deve haver 5 campos (Nome, Modelo, Placa, Data_In, Hora_In)
                if (dados.length >= 5) {
                    // Remover espaços em branco ou o ';' extra no final
                    String nome = dados[0].trim();
                    String carro = dados[1].trim();
                    String placa = dados[2].trim();
                    String dataEntrada = dados[3].trim();
                    String horaEntrada = dados[4].trim().replace(";", ""); // Remove o ';' do final

                    DadosDoCliente cliente = new DadosDoCliente(
                            nome,
                            carro,
                            placa,
                            dataEntrada,
                            horaEntrada
                    );
                    clientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV.");
            e.printStackTrace();
        }

        return clientes;
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

