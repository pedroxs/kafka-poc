package com.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class KafkaPocApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocApplication.class, args);
	}

/*
	@Autowired
	private KafkaTemplate<String, String> template;

	private final CountDownLatch latch = new CountDownLatch(3);

	@Override
	public void run(String... args) throws Exception {
		log.info("Sending messages");
		template.send("myTopic", "foo1");
		template.send("myTopic", "foo2");
		template.send("myTopic", "foo3");
		latch.await(60, TimeUnit.SECONDS);
		log.info("All received");
	}

	@KafkaListener(topics = "myTopic")
	public void listen(ConsumerRecord cr) throws Exception {
		log.info(cr.toString());
		latch.countDown();
	}
*/
}
