package com.base.stockservice.repository;

import com.base.stockservice.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Request, Long> {
}
