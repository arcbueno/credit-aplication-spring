package com.arcbueno.credit.application.services

import com.arcbueno.credit.application.models.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer?
    fun deleteById(id: Long): Unit

}