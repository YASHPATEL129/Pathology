package com.pathology.Pathology.repository;

import com.pathology.Pathology.entity.TestOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestOrderItemRepository extends JpaRepository<TestOrderItem, Long> {

    List<TestOrderItem> findByOrderIdAndCompletedTrue(Long orderId);

    List<TestOrderItem> findByOrderId(Long orderId);
}
