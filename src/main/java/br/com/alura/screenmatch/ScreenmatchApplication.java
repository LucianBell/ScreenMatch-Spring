package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.SeriesData;
import br.com.alura.screenmatch.service.APIConsumption;
import br.com.alura.screenmatch.service.DataConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		APIConsumption apiConsumption = new APIConsumption();
		var json = apiConsumption.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=7ef332a9");
		System.out.println(json);

		DataConverter converter = new DataConverter();
		SeriesData data = converter.getData(json, SeriesData.class);
		System.out.println(data);
	}
}
