module com.visaapp.connectfour {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.visaapp.connectfour to javafx.fxml;
	exports com.visaapp.connectfour;
}