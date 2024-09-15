package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<ProductDTO> selectAllProductList() {
        // 전체 제품 목록 조회
        return productDAO.selectAllProductList();
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {
        // 조건에 따른 제품 목록 조회
        switch (searchCondition.getOption()) {
            case "productName":
                return productDAO.selectProductByName(searchCondition.getValue());
            case "newProduct":
                return productDAO.selectNewProduct();
            case "nonProduction":
                return productDAO.selectProductByNotSale();
            default:
                throw new IllegalArgumentException("Invalid search condition");
        }
    }

    public boolean registNewProduct(ProductDTO product) {
        // 제품 정보 등록
        int result = productDAO.insertProduct(product);
        return result > 0;
    }

    public boolean modifyProductInfo(ProductDTO product) {
        // 제품 정보 수정
        int result = productDAO.updateProduct(product);
        return result > 0;
    }

    public boolean deleteProduct(Map<String, String> parameter) {
        // 제품 정보 삭제
        int result = productDAO.deleteProduct(Integer.parseInt(parameter.get("productCode")));
        return result > 0;
    }
}
