package com.example.manytoonelazy

import org.springframework.data.jpa.repository.JpaRepository


interface ChildRepository: JpaRepository<Child, Int>
