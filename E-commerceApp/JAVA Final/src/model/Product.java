package model;

public class Product
{
	public Integer ProdID;
	public String ProdCategory;
	public String ProdBrand;
	public String site;
	public Double unitPrice;
	public Integer quantity;
	public String size;
	public static Product pobjs[]= new Product[600];

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getProdID() {
		return ProdID;
	}
	public void setProdID(Integer prodID) {
		ProdID = prodID;
	}
	public String getProdCategory() {
		return ProdCategory;
	}
	public void setProdCategory(String prodCategory) {
		ProdCategory = prodCategory;
	}
	public String getProdBrand() {
		return ProdBrand;
	}
	public void setProdBrand(String prodBrand) {
		ProdBrand = prodBrand;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Product()
	{
		
	}
	public Product(Integer ProdID, String ProdCategory, String ProdBrand, String site, Double unitPrice, Integer quantity, String size)
	{
		this.ProdID= ProdID;
		this.ProdCategory= ProdCategory;
		this.ProdBrand= ProdBrand;
		this.site= site;
		this.unitPrice= unitPrice;
		this.quantity= quantity;
		this.size = size;
	}
	
	
	

}
