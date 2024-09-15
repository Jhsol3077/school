package com.management.product.model.dao;

import com.management.product.model.dto.ProductDTO;
import java.util.List;

public interface ProductDAO {

    // 1. 전체 제품 목록 조회 메서드
    List<ProductDTO> selectAllProductList();
    // 2. 제품명을 기준으로 제품 목록 조회 메서드
    List<ProductDTO> selectProductByName(String name);

    // 3. 이달의 신제품 조회 메서드
    List<ProductDTO> selectNewProduct();

    // 4. 생산 중단된 제품 조회 메서드
    List<ProductDTO> selectProductByNotSale();

    // 5. 새로운 제품 등록 메서드
    int insertProduct(ProductDTO product);

    // 6. 제품 정보 수정 메서드
    int updateProduct(ProductDTO product);

    // 7. 제품 삭제 메서드
    int deleteProduct(int productId);
}
