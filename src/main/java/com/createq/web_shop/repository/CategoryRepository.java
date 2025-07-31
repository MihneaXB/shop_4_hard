package com.createq.web_shop.repository;

import com.createq.web_shop.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
