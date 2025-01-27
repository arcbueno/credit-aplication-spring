package com.arcbueno.credit.application.models

import jakarta.persistence.*

@Entity
@Table(name = "Customer")
data class Customer(
    @Column(nullable = false) var firstName: String = "",
    @Column(nullable = false) var lastName: String = "",
    @Column(nullable = false) var email: String = "",
    @Column(nullable = false) val cpf: String,
    @Column(nullable = false) var password: String,
    @Column(nullable = false) @Embedded var address: Address = Address(),
    @Column(nullable = false) @OneToMany(
        fetch = FetchType.LAZY,
        cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
        mappedBy = "customer",
        targetEntity = Credit ::class
    )
    var credits: List<Credit> = mutableListOf(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
)
