package com.example.demo.Result;


public class Result {
	String image;
	String price;
	String name;
	String link;
	
	public Result(String image, String price, String name, String link) {
		this.image = image;
		this.price = price;
		this.name = name;
		this.link = "fr.shein.com" + link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
