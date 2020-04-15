package com.example.flow

import org.apache.kafka.clients.consumer.*
import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.apache.kafka.common.serialization.*

// NÃO PRECISA SER USADO POR AGORA.

//fun consumer(
//    bootstrapServers: String,
//    group: String,
//    autoCommit: Boolean?,
//    pollMax: Int
//): KafkaConsumer<String, String> {
//    val prop: HashMap<String, Any> = HashMap()
//    prop[BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
//    prop[KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
//    prop[VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
//    prop[GROUP_ID_CONFIG] = group
//    prop[ENABLE_AUTO_COMMIT_CONFIG] = autoCommit.toString()
//    prop[MAX_POLL_RECORDS_CONFIG] = pollMax.toString()
//
//    return KafkaConsumer(prop)
//}