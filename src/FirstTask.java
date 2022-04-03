import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FirstTask {
HttpClient client = HttpClient.newHttpClient();
String basicUrl = "https://jsonplaceholder.typicode.com";

public String createNewUser(String requestBody) throws IOException, InterruptedException {
    String uri = basicUrl + "/users";
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .header("Content-Type","application/json")
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build();
    final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
return String.valueOf(response.body());
}
public String updateUser (int ID, String requestBody) throws IOException, InterruptedException {
    String uri = basicUrl + "/users/" + ID;
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .header("Content-Type","application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
            .build();
    final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return String.valueOf(response.body());
}
    public String deleteUser (int ID) throws IOException, InterruptedException {
        String uri = basicUrl + "/users/" + ID;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .DELETE()
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return String.valueOf(response.statusCode());
    }
    public String getAllUsers() throws IOException, InterruptedException {
        String uri = basicUrl + "/users";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return String.valueOf(response.body());
    }
    public String getUserById(int ID) throws IOException, InterruptedException {
        String uri = basicUrl + "/users/" + ID;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return String.valueOf(response.body());
    }
    public String getUserByName(String name) throws IOException, InterruptedException {
        String uri = basicUrl + "/users?username=" + name;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return String.valueOf(response.body());
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        FirstTask firstTask = new FirstTask();
        String requestBody ="{\n" +
                "    \"id\": 56456465,\n" +
                "    \"name\": \"Clementina DuBuque\",\n" +
                "    \"username\": \"Moriah.Stanton\",\n" +
                "    \"email\": \"Rey.Padberg@karina.biz\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"Kattie Turnpike\",\n" +
                "      \"suite\": \"Suite 198\",\n" +
                "      \"city\": \"Lebsackbury\",\n" +
                "      \"zipcode\": \"31428-2261\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"-38.2386\",\n" +
                "        \"lng\": \"57.2232\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"phone\": \"024-648-3804\",\n" +
                "    \"website\": \"ambrose.net\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Hoeger LLC\",\n" +
                "      \"catchPhrase\": \"Centralized empowering task-force\",\n" +
                "      \"bs\": \"target end-to-end models\"\n" +
                "    }\n" +
                "  }"
                ;
        System.out.println(firstTask.getUserByName("Karianne"));
    }
}