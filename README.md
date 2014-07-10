#Paynova API PHP Client

This is an overview of the Paynova API Java Client using [Paynova REST API][] (Aero). More in-depth information can be found in the [Wiki][].
[Paynova REST API]: http://docs.paynova.com/display/API/Paynova+API+Home
[Wiki]: https://github.com/Paynova/paynova-api-java-client/wiki

##Dependencies
Java version >= 1.5 required.


##Get started
* Get started by downloading the zip-file

##Maven
With maven installed you can build this package by:
```
mvn install
```
The above statement creates a jar in a folder named "target".

To run the tests with maven:
```
mvn test
```

#As dependency
```
<dependency>
	<groupId>com.paynova.api.client</groupId>
	<artifactId>paynova-java</artifactId>
	<version>put version number here</version>
</dependency>
```

##Quick example
Below example creates an order at Paynova.
```

PaynovaClient client = new PaynovaClientImpl("endpoint","username","password");
CreateOrderResponse createOrderResponse = null;
try{
	createOrderResponse = client.createOrder("123-your-order-number", 
			new BigDecimal(100.00),CurrencyCode.SWEDISH_KRONA);
}catch(PaynovaHttpException phe){
	System.out.println(phe);
	//If Paynova API server is reached phe.getStatus() returns the Status object
}
```


##License
Read the LICENSE file
