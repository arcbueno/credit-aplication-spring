package com.arcbueno.credit.application.services.impl

import com.arcbueno.credit.application.models.Credit
import com.arcbueno.credit.application.repositories.CreditRepository
import com.arcbueno.credit.application.services.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(private val creditRepository: CreditRepository, private val customerService: CustomerService) :
    ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomerId(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit? {
        val credit = this.creditRepository.findByCreditCode(creditCode).orElse(null) ?: return null
        return if (credit.customer?.id == customerId) credit else null
    }
}