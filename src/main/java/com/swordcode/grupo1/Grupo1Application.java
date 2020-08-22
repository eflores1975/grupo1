package com.swordcode.grupo1;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

@SpringBootApplication
public class Grupo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo1Application.class, args);
	}

	@Bean
	ApplicationRunner initTemperatureData(TemperatureRepository repository ) {
		String[][]	data = {
			{"32.00", "01/01/2020"},
			{"34.00", "01/02/2020"},
			{"34.00", "01/03/2020"},
			{"28.00", "01/04/2020"},
			{"21.00", "12/31/2019"},
			{"30.00", "12/30/2019"}
		};

		return args -> {
			Stream.of(data).forEach(array -> {
				try {
					Date date = new SimpleDateFormat("MM/dd/yyyy").parse(array[1]);
					Temperature t = new Temperature(new BigDecimal(array[0]), date);
					repository.save(t);
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			});

			repository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	ApplicationRunner initCandidatoData(CandidatoRepository repository) {
		String[][]	data = {
			{"1", "A", "194"},
			{"1", "B", "48"},
			{"1", "C", "206"},
			{"1", "D", "45"},
			{"2", "A", "180"},
			{"2", "B", "20"},
			{"2", "C", "320"},
			{"2", "D", "16"},
			{"3", "A", "221"},
			{"3", "B", "90"},
			{"3", "C", "140"},
			{"3", "D", "20"},
			{"4", "A", "432"},
			{"4", "B", "50"},
			{"4", "C", "821"},
			{"4", "D", "14"},
			{"5", "A", "820"},
			{"5", "B", "61"},
			{"5", "C", "946"},
			{"5", "D", "18"}
		};

		return args -> {
			Stream.of(data).forEach(array -> {
				Candidato c = new Candidato(
					Integer.parseInt(array[0]),
					array[1],
					Integer.parseInt(array[2])
				);
				repository.save(c);
			});

			repository.findAll().forEach(System.out::println);
		};
	}
	
}
