 @Test
    public void validateAirportInformation() {
        RestAssured.baseURI = "https://airportgap.dev-
tester.com";
        RestAssured.basePath = "api/airports";
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .when().get()
                .then().log().body().statusCode(200).extract().response();

        JsonPath deserializedResponse = response.jsonPath();
        Assert.assertEquals(deserializedResponse.getString("data[0].id"),"GKA");
        Assert.assertEquals(deserializedResponse.getString("data[0].type"),"airport");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.name"),"Goroka Airport");
        Assert.assertEquals(deserializedResponse.getString("data[0].attributes.city"),"Goroka");
        Assert.assertEquals(deserializedResponse.getList("data.attributes.country").getFirst(),"Papua New Guinea");//this is also another way
    }
