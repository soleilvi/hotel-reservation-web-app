package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.time.ConvertTimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args){

		SpringApplication.run(D387SampleCodeApplication.class, args);

		ConvertTimeZone mountainTime = new ConvertTimeZone("MT");
		ConvertTimeZone universalTime = new ConvertTimeZone("UTC");
		ConvertTimeZone easternTime = new ConvertTimeZone("ET");

		System.out.println(mountainTime.getTimeAtTimeZone());
		System.out.println(easternTime.getTimeAtTimeZone());
		System.out.println(universalTime.getTimeAtTimeZone());
	}

}
