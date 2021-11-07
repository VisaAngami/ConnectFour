package com.visaapp.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {

	private HelloController controller;

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		GridPane rootGridePane= fxmlLoader.load();

		controller=fxmlLoader.getController();
		controller.createPlayGround();

		MenuBar menuBar= createMenu();
		menuBar.prefWidthProperty().bind(stage.widthProperty());

		Pane menuPane= (Pane) rootGridePane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene = new Scene(rootGridePane);

		stage.setTitle("         Connect Four");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	private MenuBar createMenu(){
		//FileMenu
		Menu fileMenu=new Menu("File");

		MenuItem newGame=new MenuItem("New Game");

		newGame.setOnAction(actionEvent -> controller.resetGame());

		MenuItem resetGame=new MenuItem("Reset Game");

		resetGame.setOnAction(actionEvent -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
		MenuItem exitGame=new MenuItem("Exit Game");

		exitGame.setOnAction(actionEvent -> exitGame());

		fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame );

		//HelpMenu
		Menu helpMenu=new Menu("Help");

		MenuItem aboutGame=new MenuItem("About Connect4");

		aboutGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {

				aboutConnect4();
			}
		});

		SeparatorMenuItem separator= new SeparatorMenuItem();

		MenuItem aboutMe=new MenuItem("About Me");

		aboutMe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {

				aboutMe();
			}
		});

		helpMenu.getItems().addAll(aboutGame, separator, aboutMe);


		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;

	}

	private void aboutMe() {

		Alert alert= new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Senpai Visa");
		alert.setContentText(" Hello I am a great Anime Lover... this is just the steeping "
				+" stone for my new and upcoming creation of Anime World! Tssskkkk ");

		alert.show();
	}

	private void aboutConnect4() {

		Alert alert= new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play");
		alert.setContentText(" Connect Four is a two-player connection game in which the "
				+" players first choose a color and then take turns dropping colored discs "
				+" from the top into a seven-column, six-row vertically suspended grid. "
				+" The pieces fall straight down, occupying the next available space within the column."
				+"The objective of the game is to be the first to form a horizontal, vertical, "
				+ " or diagonal line of four of one's own discs. Connect Four is a solved game. "
				+ " The first player can always win by playing the right moves. "
		);


		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	private void resetGame() {
		//TODO
	}

	public static void main(String[] args) {
		launch();
	}
}
