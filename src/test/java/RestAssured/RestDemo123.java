package RestAssured;
import static io.restassured.RestAssured.given;

public class RestDemo123 {
	public static void main(String[] args) {
		//RestAssured.BaseURI=http://216.10.245.166
		
		Books books = new Books();
		books.setAisle(123);
		books.setAuthor("Raghvendra Mann");
		books.setIsbn("abcd");
		books.setName("Testing APIs");
		
		given().log().all()
			.body(books)
				.when()
					.post("http://dummy.restapiexample.com/api/v1/create")
						.then()
							.log()
								.all();
	}

}
