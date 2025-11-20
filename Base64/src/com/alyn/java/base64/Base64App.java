package com.alyn.java.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64App {
	
	public static void main(String []args)
	{
		String originalString = "{\"accounts\":[{\"nameOnAccount\":\"CLJHE IICQDFB\",\"accountNumber\":\"2198166\",\"accountSubType\":\"Checking\",\"nickname\":\"Checking\"},{\"nameOnAccount\":\"CLJHE IICQDFB\",\"accountNumber\":\"12653954\",\"accountSubType\":\"Savings\",\"nickname\":\"Savings\"},{\"nameOnAccount\":\"CLJHE IICQDFB\",\"accountNumber\":\"12653962\",\"accountSubType\":\"Checking\",\"nickname\":\"CHECKING\"},{\"nameOnAccount\":\"CLJHE IICQDFB\",\"accountNumber\":\"219816501\",\"accountSubType\":\"Savings\",\"nickname\":\"Savings\"}]}\n"
				+ "";
		
		System.out.println("Original String: \n"+originalString);
		
		String encodedString = encoding(originalString);
		System.out.println("Encoded String: ");
		System.out.println(encodedString);
		
		String decodedString = decoding(encodedString);
		System.out.println("Decoded String: ");
		System.out.println(decodedString);
	}
	
	public static String encoding(String originalString){
		
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(originalString.getBytes());
		
		return encodedString;
	}
	
	public static String decoding(String encodedString){

		// Step-1: Get Standart Base64 Decoder
		Base64.Decoder decoder = Base64.getDecoder();
		// Step-2: Perform the decoding and get byte array
		byte[] decodedBytes = decoder.decode(encodedString);
		// Step-3: Convert Byte array to string
		String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
		
		return decodedString;
	}
}
