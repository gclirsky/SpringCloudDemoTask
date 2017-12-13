package com.codelab.springcloud.demo.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public PayProcessingTask payProcessingTask() {
		return new PayProcessingTask();
	}

	public class PayProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... parameters) throws Exception {
			if (null != parameters)
				// patermeters: storeAccountId, consumerAccountId, price,
				System.out.println("parameters length: " + parameters.length);

			System.out.println("storeAccountId: " + parameters[0] + ", consumerAccountId: " + parameters[1]
					+ ", price: " + parameters[2]);
		}

	}
}
