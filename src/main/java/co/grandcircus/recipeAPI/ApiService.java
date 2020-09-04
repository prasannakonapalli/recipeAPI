package co.grandcircus.recipeAPI;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import Model.Diet;
import Model.Recipe;
import Model.RecipeResponse;
 

@Service
public class ApiService {
	private RestTemplate rt;
	@Value("${api-id}")
	public String apiId;
	@Value("${api-key}")
	public String apiKey;

	{
	ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring!");
			return execution.execute(request, body);
		};rt=new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}

	public RecipeResponse getRecipes(String text, String cals, String diet,String recordCount) {

		//insert url link to connect API
		String url="https://api.edamam.com/search?q={text}&app_id={apiId}&app_key={apiKey}&from=0&to={recordCount}&";
		RecipeResponse response=null;
		
		
		//create if/else state to produce response
		//search result should not be restricted to needing other filters 
		if( (cals !=null && !cals.isEmpty()) && (diet !=null && !diet.isEmpty()) ) {
			url=url+"calories={cals}&diet={diet}";
			 response = rt.getForObject(url, RecipeResponse.class, text,apiId,apiKey,recordCount, cals,diet);
		}
		else if(cals !=null && !cals.isEmpty()) {
			url=url+"calories={cals}";
			 response = rt.getForObject(url, RecipeResponse.class, text,apiId,apiKey, recordCount,cals);
		}
		else if(diet !=null && !diet.isEmpty()) {
			url=url+"&diet={diet}";
			 response = rt.getForObject(url, RecipeResponse.class, text,apiId,apiKey,recordCount, diet);
		}
		else { 
			 response = rt.getForObject(url, RecipeResponse.class, text,apiId,apiKey,recordCount);
		}
	

	

		return response;

	}
	
	//create method to return list of recipes 
	public  List<Recipe> getRecipeById(String uri) { 
		

//		uri=URLEncoder.encode(uri);
		System.out.println("uri: "+uri);

		
		List<Recipe> recipeLst=new ArrayList<Recipe>();

		
  	String url="https://api.edamam.com/search?r={uri}&app_id={apiId}&app_key={apiKey}";

		 
		  Recipe[] recipe = rt.getForObject(url, Recipe[].class,uri,apiId,apiKey) ;
		  System.out.println("responsddd"+recipe.length);
		  recipeLst= Arrays.asList(recipe);
		  
		     
		//recipe.add(r);
		return recipeLst;		
		
	}

}
