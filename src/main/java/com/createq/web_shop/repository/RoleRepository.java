package com.createq.web_shop.repository;

import com.createq.web_shop.model.RolesModel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RolesModel, Long> {
    RolesModel findByName(String name);
}
