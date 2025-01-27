package com.arcbueno.credit.application.services.impl

import com.arcbueno.credit.application.models.Customer
import com.arcbueno.credit.application.repositories.CustomerRepository
import com.arcbueno.credit.application.services.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository):ICustomerService {
    override fun save(customer: Customer): Customer =  this.customerRepository.save(customer)

    override fun findById(id: Long): Customer? = this.customerRepository.findById(id).orElse(null)

    override fun deleteById(id: Long) = this.customerRepository.deleteById(id)
}