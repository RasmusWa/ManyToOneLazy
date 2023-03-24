package com.example.manytoonelazy

import jakarta.persistence.*

@Entity
@Table(name= "CHILD")
class Child(
    @Id
    @Column(name = "ID")
    val id: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    val parent: Parent
)
