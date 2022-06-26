package fr.eni.coucheBO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Repas {

	private Integer id_repas;
	private LocalDate date;
	private LocalTime heureRepas;

	private List<Aliment> listAliment;

	public Repas() {

	}

	public Repas(Integer id_repas, LocalDate date, LocalTime heureRepas) {
		this.setId_repas(id_repas);
		this.date = date;
		this.heureRepas = heureRepas;
		listAliment = new ArrayList<>();

	}

	public Repas(LocalDate date, LocalTime heureRepas) {
		this(null, date, heureRepas);
	}

	public java.sql.Date conversionDate(LocalDate dateParam) {
		java.sql.Date sqlDate;
		sqlDate = java.sql.Date.valueOf(dateParam);
		return sqlDate;
	}

	public java.sql.Time conversionTime(LocalTime timeParam) {
		java.sql.Time sqlTime;
		sqlTime = java.sql.Time.valueOf(timeParam);
		return sqlTime;
	}

	public void AjoutAliment(Aliment alimentParam) {
		listAliment.add(alimentParam);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeureRepas() {
		return heureRepas;
	}

	public void setHeureRepas(LocalTime heureRepas) {
		this.heureRepas = heureRepas;
	}

	public Integer getId_repas() {
		return id_repas;
	}

	public void setId_repas(Integer id_repas) {
		this.id_repas = id_repas;
	}

	public List<Aliment> getListAliment() {
		return listAliment;
	}

	public void setListAliment(List<Aliment> listAliment) {
		this.listAliment = listAliment;
	}

	@Override
	public String toString() {
		return "Repas [id_repas=" + id_repas + ", date=" + date + ", heureRepas=" + heureRepas + ", listAliment="
				+ listAliment + "]";
	}

}
