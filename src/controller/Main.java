package controller;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	private Stage primaryStage;
	
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
		
	}
	
	public void mainWindow(){
		
		
		FXMLLoader loader = new FXMLLoader(
				
				Main.class.getResource("/view/MainWindowView.fxml")
				
						);
		
		try {
			
			
			
			Connection polaczenie = DriverManager.getConnection(Conn.url,Conn.uzytkownik,Conn.haslo);
			
			System.out.println("AutoCommit: " + polaczenie.getAutoCommit());
			
			Statement utworzPrze = polaczenie.createStatement();
			Statement utworzNau = polaczenie.createStatement();
			Statement utworzUcz = polaczenie.createStatement();
			Statement utworzOce = polaczenie.createStatement();
			Statement utworz_ocenianie = polaczenie.createStatement();
			
			utworzPrze.execute(Tables.TabPrzedmiot);
			System.out.println("Dodano tabelê Przedmiot");
			utworzNau.execute(Tables.TabNauczyciel);
			System.out.println("Dodano tabelê Nauczyciel");
			utworzUcz.execute(Tables.TabUczen);
			System.out.println("Dodano tabelê Uczen");
			utworzOce.execute(Tables.TabOcena);
			System.out.println("Dodano tabelê Ocena");
			utworz_ocenianie.execute(Tables.TabOcenianie);
			System.out.println("Dodano tabelê Ocenianie");
			
			Statement insertPrze = polaczenie.createStatement();
			Statement insertNau = polaczenie.createStatement();
			Statement insertUcz = polaczenie.createStatement();
			Statement insertOce = polaczenie.createStatement();
			
			
			insertPrze.executeUpdate(Inserts.insPrzedmiot1);
			insertPrze.executeUpdate(Inserts.insPrzedmiot2);
			insertPrze.executeUpdate(Inserts.insPrzedmiot3);
			insertPrze.executeUpdate(Inserts.insPrzedmiot4);
			insertPrze.executeUpdate(Inserts.insPrzedmiot5);
			insertPrze.executeUpdate(Inserts.insPrzedmiot6);
			insertPrze.executeUpdate(Inserts.insPrzedmiot7);
			insertPrze.executeUpdate(Inserts.insPrzedmiot8);
			
			
			insertNau.executeUpdate(Inserts.insNauczyciel1);
			insertNau.executeUpdate(Inserts.insNauczyciel2);
			insertNau.executeUpdate(Inserts.insNauczyciel3);
			insertNau.executeUpdate(Inserts.insNauczyciel4);
			insertNau.executeUpdate(Inserts.insNauczyciel5);
			insertNau.executeUpdate(Inserts.insNauczyciel6);
			insertNau.executeUpdate(Inserts.insNauczyciel7);
			insertNau.executeUpdate(Inserts.insNauczyciel8);
			
			insertUcz.executeUpdate(Inserts.insUczen1);
			insertUcz.executeUpdate(Inserts.insUczen2);
			insertUcz.executeUpdate(Inserts.insUczen3);
			insertUcz.executeUpdate(Inserts.insUczen4);
			insertUcz.executeUpdate(Inserts.insUczen5);
			insertUcz.executeUpdate(Inserts.insUczen6);
			insertUcz.executeUpdate(Inserts.insUczen7);
			insertUcz.executeUpdate(Inserts.insUczen8);
			
			insertOce.executeUpdate(Inserts.insOcena1);
			insertOce.executeUpdate(Inserts.insOcena15);
			insertOce.executeUpdate(Inserts.insOcena2);
			insertOce.executeUpdate(Inserts.insOcena25);
			insertOce.executeUpdate(Inserts.insOcena3);
			insertOce.executeUpdate(Inserts.insOcena35);
			insertOce.executeUpdate(Inserts.insOcena4);
			insertOce.executeUpdate(Inserts.insOcena45);
			insertOce.executeUpdate(Inserts.insOcena5);
			insertOce.executeUpdate(Inserts.insOcena55);
			insertOce.executeUpdate(Inserts.insOcena6);
			
			System.out.println("Dane do tabel wstawione prawid³owo");
			
			AnchorPane pane = loader.load();
			primaryStage.setMinWidth(800.0);
			primaryStage.setMinHeight(600.0);
			Scene scene  = new Scene(pane);
			
			
			
			
			
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this,primaryStage);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Program Ocenianie");
			primaryStage.setResizable(false);
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		catch (SQLException e) {

			System.out.println("Error DB not connected!");
			e.printStackTrace();
			return;
		}

		System.out.println("DB Connected");
		
		
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

