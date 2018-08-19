package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.Nauczyciele;
import model.Oceny;
import model.Przedmioty;
import model.Uczniowie;

public class MainWindowController {

	private ObservableList<Uczniowie> listaUczniow = FXCollections.observableArrayList();
	private ObservableList<Nauczyciele> listaNauczycieli = FXCollections.observableArrayList();
	private ObservableList<Przedmioty> listaPrzedmiotow = FXCollections.observableArrayList();
	private ObservableList<Oceny> listaOcen = FXCollections.observableArrayList();

	private ObservableList<String> choiceBoxList = FXCollections.observableArrayList("C-Cz¹stkowa", "S-Semestralna");

	private Main main;
	private Stage primaryStage;

	@FXML
	private TableView<Uczniowie> tableViewUczen;

	@FXML
	private TableColumn<Uczniowie, Integer> idUczniaColumn;

	@FXML
	private TableColumn<Uczniowie, String> nazwiskoUczniaColumn;

	@FXML
	private TableColumn<Uczniowie, String> imieUczniaColumn;

	@FXML
	private TableView<Nauczyciele> tableViewNauczyciel;

	@FXML
	private TableColumn<Nauczyciele, Integer> idNauczycielaColumn;

	@FXML
	private TableColumn<Nauczyciele, String> nazwiskoNauczycielaColumn;

	@FXML
	private TableColumn<Nauczyciele, String> imieNauczycielaColumn;

	@FXML
	private TableView<Przedmioty> tableViewPrzedmiot;

	@FXML
	private TableColumn<Przedmioty, Integer> idPrzedmiotuColumn;

	@FXML
	private TableColumn<Przedmioty, String> nazwaPrzedmiotuColumn;

	@FXML
	private TableView<Oceny> tableViewOcena;

	@FXML
	private TableColumn<Oceny, Integer> idOcenyColumn;

	@FXML
	private TableColumn<Oceny, String> ocenaOpisColumn;

	@FXML
	private TableColumn<Oceny, Float> ocenaColumn;

	@FXML
	private void loadFromUczenTable() {

		int idu;
		String nazwisko_ucznia;
		String imie_ucznia;

		try {

			Connection polaczenie = DriverManager.getConnection(Conn.url, Conn.uzytkownik, Conn.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(Selects.selectUcz);
			ResultSet rs = polecenie.executeQuery();

			while (rs.next()) {

				idu = rs.getInt("IDU");
				nazwisko_ucznia = rs.getString("NAZWISKO_UCZNIA");
				imie_ucznia = rs.getString("IMIE_UCZNIA");

				listaUczniow.add(new Uczniowie(idu, nazwisko_ucznia, imie_ucznia));

			}

			rs.close();
			polaczenie.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	private void loadFromNauczycielTable() {

		int idn;
		String nazwisko_nauczyciela;
		String imie_nauczyciela;

		try {

			Connection polaczenie = DriverManager.getConnection(Conn.url, Conn.uzytkownik, Conn.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(Selects.selectNaucz);
			ResultSet rs = polecenie.executeQuery();

			while (rs.next()) {

				idn = rs.getInt("IDN");
				nazwisko_nauczyciela = rs.getString("NAZWISKO_NAUCZYCIELA");
				imie_nauczyciela = rs.getString("IMIE_NAUCZYCIELA");

				listaNauczycieli.add(new Nauczyciele(idn, nazwisko_nauczyciela, imie_nauczyciela));

			}

			rs.close();
			polaczenie.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML
	private void loadFromPrzedmiotTable() {

		int idp;
		String nazwa_przedmiotu;

		try {

			Connection polaczenie = DriverManager.getConnection(Conn.url, Conn.uzytkownik, Conn.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(Selects.selectPrzed);
			ResultSet rs = polecenie.executeQuery();

			while (rs.next()) {

				idp = rs.getInt("IDP");
				nazwa_przedmiotu = rs.getString("NAZWA_PRZEDMIOTU");

				listaPrzedmiotow.add(new Przedmioty(nazwa_przedmiotu, idp));

			}

			rs.close();
			polaczenie.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@FXML
	public void loadFromOcenaTable() {

		int ido;
		String wartosc_opisowa;
		float wartosc_numeryczna;

		try {

			Connection polaczenie = DriverManager.getConnection(Conn.url, Conn.uzytkownik, Conn.haslo);
			PreparedStatement polecenie = polaczenie.prepareStatement(Selects.selectOcena);
			ResultSet rs = polecenie.executeQuery();

			while (rs.next()) {

				ido = rs.getInt("IDO");
				wartosc_opisowa = rs.getString("WARTOSC_OPISOWA");
				wartosc_numeryczna = rs.getFloat("WARTOSC_NUMERYCZNA");

				listaOcen.add(new Oceny(ido, wartosc_opisowa, wartosc_numeryczna));

			}

			rs.close();
			polaczenie.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@FXML
	private ChoiceBox<String> rodzajOcenyBox;

	@FXML
	private TextField idnTF;

	@FXML
	private TextField iduTF;

	@FXML
	private TextField idpTF;

	@FXML
	private TextField idoTF;

	@FXML
	public void saveToTable() {

		try {

			Connection polaczenie = DriverManager.getConnection(Conn.url, Conn.uzytkownik, Conn.haslo);
			polaczenie.getAutoCommit();
			PreparedStatement polecenie = polaczenie.prepareStatement(Inserts.insOcenianie);
			polecenie.setInt(1, Integer.parseInt(idnTF.getText()));
			polecenie.setInt(2, Integer.parseInt(iduTF.getText()));
			polecenie.setInt(3, Integer.parseInt(idpTF.getText()));
			polecenie.setInt(4, Integer.parseInt(idoTF.getText()));
			polecenie.setString(5, rodzajOcenyBox.getValue());
			polecenie.executeUpdate();

			System.out.println("Ocena zosta³a dodana do tabeli OCENIANIE");

			polaczenie.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void setMain(Main main, Stage primaryStage) {

		this.main = main;
		this.primaryStage = primaryStage;

		tableViewUczen.setItems(listaUczniow);
		tableViewNauczyciel.setItems(listaNauczycieli);
		tableViewPrzedmiot.setItems(listaPrzedmiotow);
		tableViewOcena.setItems(listaOcen);
		rodzajOcenyBox.setItems(choiceBoxList);

	}

	public void initialize() {

		idUczniaColumn.setCellValueFactory(new PropertyValueFactory<Uczniowie, Integer>("idu"));
		nazwiskoUczniaColumn.setCellValueFactory(new PropertyValueFactory<Uczniowie, String>("nazwisko_ucznia"));
		imieUczniaColumn.setCellValueFactory(new PropertyValueFactory<Uczniowie, String>("imie_ucznia"));

		idNauczycielaColumn.setCellValueFactory(new PropertyValueFactory<Nauczyciele, Integer>("idn"));
		nazwiskoNauczycielaColumn
				.setCellValueFactory(new PropertyValueFactory<Nauczyciele, String>("nazwisko_nauczyciela"));
		imieNauczycielaColumn.setCellValueFactory(new PropertyValueFactory<Nauczyciele, String>("imie_nauczyciela"));

		nazwaPrzedmiotuColumn.setCellValueFactory(new PropertyValueFactory<Przedmioty, String>("nazwa_przedmiotu"));
		idPrzedmiotuColumn.setCellValueFactory(new PropertyValueFactory<Przedmioty, Integer>("idp"));

		idOcenyColumn.setCellValueFactory(new PropertyValueFactory<Oceny, Integer>("ido"));
		ocenaOpisColumn.setCellValueFactory(new PropertyValueFactory<Oceny, String>("wartosc_opisowa"));
		ocenaColumn.setCellValueFactory(new PropertyValueFactory<Oceny, Float>("wartosc_numeryczna"));

	}
}
