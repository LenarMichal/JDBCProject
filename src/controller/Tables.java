package controller;

public class Tables {
	
	static String TabPrzedmiot = "CREATE TABLE PRZEDMIOT (IDP INT NOT NULL, NAZWA_PRZEDMIOTU CHAR(15))";
	static String TabNauczyciel = "CREATE TABLE NAUCZYCIEL (IDN INT NOT NULL, NAZWISKO_NAUCZYCIELA CHAR(30), IMIE_NAUCZYCIELA CHAR(20))";
	static String TabUczen = "CREATE TABLE UCZEN (IDU INT NOT NULL, NAZWISKO_UCZNIA CHAR(30), IMIE_UCZNIA CHAR(20))";
	static String TabOcena = "CREATE TABLE OCENA (IDO INT NOT NULL, WARTOSC_OPISOWA CHAR(20), WARTOSC_NUMERYCZNA FLOAT)";
	static String TabOcenianie = "CREATE TABLE OCENIANIE (IDN INT NOT NULL, IDU INT NOT NULL, IDP INT NOT NULL, IDO INT NOT NULL, RODZAJ_OCENY CHAR(20))";
	

}
