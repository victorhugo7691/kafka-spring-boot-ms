📡 Apache Kafka com Spring Boot
Este projeto demonstra como configurar e utilizar o Apache Kafka com Spring Boot, incluindo uso do modo KRaft e comparação com RabbitMQ.

📘 Conceitos Fundamentais
- O Kafka é um sistema distribuído baseado em brokers, geralmente configurado em clusters de 3 ou mais instâncias.
- As mensagens são armazenadas em tópicos, que funcionam como categorias que organizam e caracterizam os dados.
- Cada tópico pode ser dividido em múltiplas partições, o que permite paralelismo e maior escalabilidade.
- O modo KRaft (Kafka Raft Metadata Mode) substitui o uso do Zookeeper, tornando o Kafka mais independente e fácil de operar.

🚀 Executando o Apache Kafka no modo KRaft (Windows)
Certifique-se de estar dentro da pasta raiz onde o Kafka foi extraído.

🧾 1. Gerar o ID do Cluster
.\bin\windows\kafka-storage.bat random-uuid


💽 2. Formatar o armazenamento com o cluster ID
.\bin\windows\kafka-storage.bat format --config .\config\server.properties --cluster-id SEU_CLUSTER_ID


Em caso de erro, adicione ao final do arquivo .\config\server.properties:

controller.quorum.voters=1@localhost:9093


Ou use esse comando alternativo:
.\bin\windows\kafka-storage.bat format --config .\config\server.properties --cluster-id SEU_CLUSTER_ID --initial-controllers 1@localhost:9093


▶️ 3. Iniciar o Kafka
.\bin\windows\kafka-server-start.bat .\config\server.properties



🧪 Comandos úteis no Kafka
📌 Criar um tópico
.\bin\windows\kafka-topics.bat --create --topic topic-example --bootstrap-server localhost:9092


✉️ Produzir mensagens
.\bin\windows\kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092


Para encerrar: pressione CTRL + C e confirme.
📥 Consumir mensagens
.\bin\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092

Endpoint da aplicação Spring Boot para gravar uma nova mensagem : http://localhost:8080/kafka/publish?message=



🎯 Kafka vs RabbitMQ: Quando usar cada um?
| Característica | RabbitMQ | Apache Kafka | 
| 🧱 Arquitetura | Broker tradicional | Plataforma de streaming distribuída | 
| 📦 Modelo de entrega | Fila de mensagens | Log distribuído e persistente | 
| 🧵 Protocolos suportados | AMQP, MQTT, STOMP, entre outros | Proprietário (Kafka Protocol) | 
| 💾 Durabilidade | Alta (com ACKs configuráveis) | Muito alta (persistência e replay nativo) | 
| ⚙️ Casos de uso | Aplicações transacionais, workflows | Big Data, IoT, streaming, processamento real-time | 
| 🚀 Performance | Boa para workloads moderados | Excelente para grandes volumes e escala horizontal | 


✨ Resumo:
- Use RabbitMQ se sua aplicação demanda simplicidade, alta confiabilidade e enfileiramento clássico.
- Prefira Kafka se você precisa de escalabilidade, event streaming e análise em tempo real.


📚 Material de apoio
- Curso: springboot-kafka-course

Se quiser, posso adicionar uma seção sobre integração com Spring Boot ou um diagrama de arquitetura simplificado também. Quer incluir isso no seu README? 💡📄
