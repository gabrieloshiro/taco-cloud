package tacos.web;

import lombok.Data;

@Data
public class Order {
	
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String creditCardNumber;
	private String creditCardExpiration;
	private String creditCardCvv;

}
