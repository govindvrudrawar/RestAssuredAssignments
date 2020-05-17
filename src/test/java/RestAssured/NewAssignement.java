package RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class NewAssignement {
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://216.10.245.166";
		String postURL="Library/Addbook.php.";
		String apibody="{\"name\":\"Learn Appium Automation with Java\",\"isbn\":\"bcd\",\"aisle\":\"227\",\"author\":\"John Foe\"}";
		String deleteURL="/Library/DeleteBook.php";
		String getbookbyAuthorname="/Library/GetBook.php?AuthorName=somename";
		String getbookbyId="Library/Getbook.php?ID=3389";
		
		
		
		
		JsonPath jsonpath=new JsonPath(Jsonpayloadnew.addData());
		String isbn = jsonpath.get("isbn");
		String aisle=jsonpath.get("aisle");
		String actualID=isbn+aisle;
		System.out.println(actualID);
		
		//Post Method
		String response=given().log().all().header("Content-Type", "application/json").body(apibody).when().post(postURL).then().log().all().assertThat()
				.statusCode(200).extract().body().asString();
		System.out.println(response);
		JsonPath jsonpath1=new JsonPath(response);
		String expectedID=jsonpath1.get("ID");
		System.out.println(expectedID);
		//Assert.assertEquals(actualID, expectedID);
	}

}
