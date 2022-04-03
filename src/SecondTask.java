import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondTask {
    HttpClient client = HttpClient.newHttpClient();
    String basicUrl = "https://jsonplaceholder.typicode.com";
    public void createJsonWithAllCommentsFromLastPostByUserId(int userId) throws IOException, InterruptedException {
        String allPosts = getPostsByUserId(userId);
        List<String> postsIds = getAllMatches(allPosts);
        int lastPostId = 10*userId;
        String allComments = getAllCommentsByPostId(lastPostId);
        String jsonFilePath = "src/resources/" + "user-" + userId + "-post-" + lastPostId + "-comments.txt";
        createFileWithComments(allComments, jsonFilePath);
    }

    private String getPostsByUserId(int userId) throws IOException, InterruptedException {
        String uri = basicUrl + "/users/" + userId + "/posts";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private List<String> getAllMatches(String text) {
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\\"id\": \\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    private String getAllCommentsByPostId(int postId) throws IOException, InterruptedException {
        String uri = basicUrl+ "/posts/" + postId + "/comments";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private void createFileWithComments(String str, String jsonFilePath) throws IOException {
        FileWriter newFile = new FileWriter(jsonFilePath);
        newFile.write(str);
        newFile.close();
            }


    public static void main(String[] args) throws IOException, InterruptedException {
        SecondTask secondTask = new SecondTask();
        secondTask.createJsonWithAllCommentsFromLastPostByUserId(5);
    }
}