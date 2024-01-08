package com.nace.excercise.repository;

import com.nace.excercise.entity.NaceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NaceDataRepository extends JpaRepository<NaceData, Long> {

    Optional<NaceData> findByOrderNumber(Long otherNumber);
}
