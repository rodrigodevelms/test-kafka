PASSOS
no terminal digite: 
1 ) docker-compose up -d  
2 ) docker-compose exec broker-test bash    
3 ) kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic samePartition  
4 ) kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic rrPartition      
        
execute a aplicação quantas vezes quiser. Cada vez que é executada ele insere um número de mensagens no tópico de acordo com o loop for  
  
voltando ao terminal execute:  
1 ) kafka-console-consumer --bootstrap-server localhost:9092 --topic samePartition --group sp --from-beginning  
2 ) kafka-console-consumer --bootstrap-server localhost:9092 --topic samePartition --group rr --from-beginning  
3 ) kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group sp  
4 ) kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group rr



 
