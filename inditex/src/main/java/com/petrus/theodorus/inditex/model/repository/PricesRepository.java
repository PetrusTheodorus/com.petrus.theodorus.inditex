package com.petrus.theodorus.inditex.model.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petrus.theodorus.inditex.model.entity.PricesEntity;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Long> {

	@Query("SELECT entity FROM PricesEntity entity "
			+ "WHERE entity.brandId = :brandId and entity.productId = :productId and "
			+ "entity.startDate <= :date AND entity.endDate > :date ORDER BY entity.priority DESC")
	List<PricesEntity> findByProductPriceByIdAndBrandAndDate(Long brandId, Long productId, Timestamp date);

}