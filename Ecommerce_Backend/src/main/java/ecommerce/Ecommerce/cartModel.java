package ecommerce.Ecommerce;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productCart")

public class cartModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private Float unitprice;
	
	private Integer quantity;
	
	private Float totalamount;
	
	private String description;
	
	@Column(name = "picByte", length = 1000)
	private byte[] picByte;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Float totalamount) {
		this.totalamount = totalamount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "cartModel [id=" + id + ", title=" + title + ", unitprice=" + unitprice + ", quantity=" + quantity
				+ ", totalamount=" + totalamount + ", description=" + description + ", picByte="
				+ Arrays.toString(picByte) + "]";
	}

	
	
	
	
}
