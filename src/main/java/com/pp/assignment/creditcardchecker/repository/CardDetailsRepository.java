package com.pp.assignment.creditcardchecker.repository;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
}
