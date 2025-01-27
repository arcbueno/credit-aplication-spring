package com.arcbueno.credit.application.repositories

import com.arcbueno.credit.application.models.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long>