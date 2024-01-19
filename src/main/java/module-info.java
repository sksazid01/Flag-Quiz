module saki.sakisproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens saki.sakisproject to javafx.fxml;
    exports saki.sakisproject;
}