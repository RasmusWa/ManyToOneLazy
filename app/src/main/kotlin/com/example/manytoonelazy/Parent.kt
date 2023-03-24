package com.example.manytoonelazy

import jakarta.persistence.*

@Entity
@Table(name= "PARENT")
class Parent(

    @Id
    @Column(name = "ID")
    val id: Int,

    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        mappedBy = "parent",
        fetch = FetchType.LAZY
    )
    var children: List<Child>,

)
