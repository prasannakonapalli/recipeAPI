package co.grandcircus.recipeAPI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class ApiService {
private RestTemplate rt;
@Value("${api-key}")
private String apiKey;
}
