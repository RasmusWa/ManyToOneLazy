package com.example.manytoonelazy

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class QueryOnStartup(
    val childRepository: ChildRepository
) {

    @EventListener(ApplicationReadyEvent::class)
    fun doQueryOnStartup() {
        println("##################################################################")
        println("############################### Query ############################")
        println("##################################################################")
        println("Result: " + childRepository.findAll().map { it.id }.joinToString(", "))
        println("##################################################################")
        println("##################################################################")

    }
}
