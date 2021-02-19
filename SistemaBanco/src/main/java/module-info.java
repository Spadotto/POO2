module poo2.SistemaBanco {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.base;

    opens poo2.SistemaBanco to javafx.fxml;
    exports poo2.SistemaBanco;
}