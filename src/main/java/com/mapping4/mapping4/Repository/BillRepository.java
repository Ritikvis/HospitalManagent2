package com.mapping4.mapping4.Repository;

import com.mapping4.mapping4.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
