package com.management.product.model.dto;

public class ProductDTO {

    private String productId;
    private String productName;
    private String productType;
    private String releaseDate;
    private String isSale;
    private String price;

    // Default constructor
    public ProductDTO() {
    }

    // Constructor with all fields
    public ProductDTO(String productId, String productName, String productType, String releaseDate, String isSale, String price) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.releaseDate = releaseDate;
        this.isSale = isSale;
        this.price = price;
    }

    // Getter and Setter methods
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getIsSale() {
        return isSale;
    }

    public void setIsSale(String isSale) {
        this.isSale = isSale;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // toString method for easy debugging and logging
    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", isSale='" + isSale + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
