package com.example.greetingapps.repository;

import com.example.greetingapps.model.GreetingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingData,Long> {
}
