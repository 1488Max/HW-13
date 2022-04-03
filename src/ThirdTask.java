import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ThirdTask {
    HttpClient client = HttpClient.newHttpClient();
    String basicUrl = "https://jsonplaceholder.typicode.com";
    public String getAbleTasksForUserById(int ID) throws IOException, InterruptedException {
        String uri = basicUrl + "/users/" + ID + "/todos?completed=true";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ThirdTask thirdTask = new ThirdTask();
        System.out.println("thirdTask.getAbleTasksForUserById(1) = " + thirdTask.getAbleTasksForUserById(1));
    }
}
