package com.pathology.Pathology.repository;

import com.pathology.Pathology.entity.PathologyTest;
import com.pathology.Pathology.entity.TestOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PathologyTestRepository extends JpaRepository<PathologyTest, Long> {


    @Query(value = """
        SELECT *
        FROM pathology_test
        WHERE (:name IS NULL
        OR :name = ''
        OR LOWER(test_name)
        LIKE LOWER(CONCAT('%', :name, '%')))
        """, nativeQuery = true)
    List<PathologyTest> getTests(String name);

    @Query(value = """
        SELECT *
        FROM pathology_test
        WHERE active = true
        """, nativeQuery = true)
    List<PathologyTest> getActiveTests();


}
