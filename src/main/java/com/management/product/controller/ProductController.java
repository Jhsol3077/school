package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import com.management.product.model.dao.ProductDAO;

import java.util.List;
import java.util.Map;

public class ProductController {

    private ProductService productService;
    private ProductPrint productPrint;

    // 기본 생성자를 통해 내부에서 ProductService와 ProductPrint 객체 생성
    public ProductController() {
//        this.productService = new ProductService();  // 서비스 객체 생성
        this.productPrint = new ProductPrint();      // 출력 객체 생성
    }

    public void selectAllProductList() {
        List<ProductDTO> productList = productService.selectAllProductList();
        if (!productList.isEmpty()) {
            // 전체 제품 목록을 출력
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("조회된 제품 목록이 없습니다.");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {
        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);
        if (!productList.isEmpty()) {
            // 조건에 따른 제품 목록과 검색 조건을 출력
            productPrint.printProductList(productList, searchCondition);
        } else {
            productPrint.printErrorMessage("조회된 제품 목록이 없습니다.");
        }
    }

    public void registNewProduct(ProductDTO product) {
        String releaseDate = product.getReleaseDate().replace("-", "");
        product.setReleaseDate(releaseDate);
        product.setIsSale("Y");  // 기본값 설정
        product.setPrice("0");   // 기본값 설정

        boolean isInserted = productService.registNewProduct(product);
        if (isInserted) {
            productPrint.printSuccessMessage("제품 등록 성공!");
        } else {
            productPrint.printErrorMessage("제품 등록 실패.");
        }
    }

    public void modifyProductInfo(ProductDTO product) {
        String releaseDate = product.getReleaseDate().replace("-", "");
        product.setReleaseDate(releaseDate);

        boolean isUpdated = productService.modifyProductInfo(product);
        if (isUpdated) {
            productPrint.printSuccessMessage("제품 정보 수정 성공!");
        } else {
            productPrint.printErrorMessage("제품 정보 수정 실패.");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {
        boolean isDeleted = productService.deleteProduct(parameter);
        if (isDeleted) {
            productPrint.printSuccessMessage("제품 삭제 성공!");
        } else {
            productPrint.printErrorMessage("제품 삭제 실패.");
        }
    }
}
