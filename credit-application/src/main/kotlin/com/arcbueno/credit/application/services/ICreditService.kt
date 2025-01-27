package com.arcbueno.credit.application.services

import com.arcbueno.credit.application.models.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomerId(customerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long,  creditCode: UUID): Credit?
}