package sparkbug;

import spark.Spark;

public class Main implements spark.servlet.SparkApplication {

	public static final String APPLICATION_JSON = "application/json";

	public void init() {
		
		enableGZip();

		Spark.get("/", (req, res) -> {
			res.type("application/json");
			return "{\"message\":\"Hello\"}";
		});

		Spark.notFound((req, res) -> {
			res.type("application/json");
			return "{\"message\":\"Custom 404\"}";
		});
	}

	

	private void enableGZip() {
		Spark.after((request, response) -> {
			response.header("Content-Encoding", "gzip");
		});
	}
}
