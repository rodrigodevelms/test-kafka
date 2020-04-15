package com.example.flow

import org.apache.kafka.clients.producer.*
import org.apache.kafka.clients.producer.ProducerConfig.*
import org.apache.kafka.common.serialization.*
import java.util.*
import kotlin.collections.HashMap

fun producer(
    bootstrapServers: String

): KafkaProducer<String, String> {
    val prop: HashMap<String, Any> = HashMap()
    prop[BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
    prop[KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
    prop[VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name

    return KafkaProducer(prop)
}

fun createCommandSM(topicName: String, bootstrapServers: String) {
    val id = UUID.fromString("6a7a3a21-8790-43d7-9b7d-418d84570c8c")
    val producer = producer(bootstrapServers)
    for (i in 1..50) {
        val record = ProducerRecord(topicName, id.toString(), "Send number $i")
        producer.send(record)
    }
}

fun createCommandRR(topicName: String, bootstrapServers: String) {
    val producer = producer(bootstrapServers)
    for (i in 1..40) {
        val record = ProducerRecord(topicName, (UUID.randomUUID()).toString(), "Send number $i")
        producer.send(record)
    }
}

fun sendCommandSamePartition() {
    createCommandSM("samePartition", "localhost:9092")
}

fun sendCommandRR() {
    createCommandRR("rrPartition", "localhost:9092")
}