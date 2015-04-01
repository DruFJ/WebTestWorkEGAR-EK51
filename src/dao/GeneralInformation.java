package dao;

import java.util.Date;

public class GeneralInformation {
	private String name;
	private String imagePath;
	private long id;
	private String annotation;
	private Date date;
	private String adress;
	private int cost;

	public GeneralInformation(String name, String imagePath, long id,
			String annotation, Date date, String adress, int cost) {
		super();
		this.name = name;
		this.imagePath = imagePath;
		this.id = id;
		this.annotation = annotation;
		this.date = date;
		this.adress = adress;
		this.cost = cost;
	}

	public GeneralInformation() {
		super();
		this.name = "";
		this.imagePath = "";
		this.id = 1;
		this.annotation = "";
		this.date = new Date();
		this.adress = "";
		this.cost = 0;
	}

	public GeneralInformation(String name, String imagePath, long id) {
		super();
		this.name = name;
		this.imagePath = imagePath;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
