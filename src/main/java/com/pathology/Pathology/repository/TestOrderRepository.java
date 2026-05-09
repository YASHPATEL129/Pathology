package com.pathology.Pathology.repository;

import com.pathology.Pathology.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {

    @Query(value = """
            SELECT *
            FROM test_order
            WHERE order_date
            BETWEEN :startDate AND :endDate
            ORDER BY id DESC
            """, nativeQuery = true)
    List<TestOrder> getTodayOrders(
            LocalDateTime startDate,
            LocalDateTime endDate);
}
