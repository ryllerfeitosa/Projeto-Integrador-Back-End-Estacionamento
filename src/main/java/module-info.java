module br.senai.sp.jandira.projetointegradorbackendestacionamento {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens br.senai.sp.jandira.projetointegradorbackendestacionamento to javafx.fxml;
    exports br.senai.sp.jandira.projetointegradorbackendestacionamento;
}