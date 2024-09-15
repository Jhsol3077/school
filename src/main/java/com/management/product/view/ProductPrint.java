package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {
        // 1. 전체 조회한 목록을 출력하는 메소드
        if (allProductList == null || allProductList.isEmpty()) {
            System.out.println("제품 목록이 없습니다.");
        } else {
            System.out.println("전체 제품 목록:");
            for (ProductDTO product : allProductList) {
                System.out.println(product);
            }
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {
        // 2. 조건에 따라 조회한 목록을 출력하는 메소드
        if (searchCondition != null) {
            System.out.println("검색 조건: " + searchCondition.getOption() + " - 검색어: " + searchCondition.getValue());
        }
        if (productList == null || productList.isEmpty()) {
            System.out.println("조건에 맞는 제품이 없습니다.");
        } else {
            System.out.println("조회된 제품 목록:");
            for (ProductDTO product : productList) {
                System.out.println(product);
            }
        }
    }

    public void printSuccessMessage(String successCode) {
        // 3. 성공 메시지를 출력하는 메소드
        System.out.println("성공: " + successCode);
    }

    public void printErrorMessage(String errorCode) {
        // 4. 에러 메시지를 출력하는 메소드
        System.out.println("에러: " + errorCode);
    }
}
