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

##Live integration tests
In the property file src/test/resources/paynova-test.properties there is a property that can be switch to do true which enables live integration testing against the Paynova API testservers. In the same file endpoint, username and password needs to be set with your Paynova credentials, received from Paynova support.

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
