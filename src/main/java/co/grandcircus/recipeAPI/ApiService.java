package co.grandcircus.recipeAPI;

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
	private String apiId;
	@Value("${api-key}")
	private String apiKey;

	{
	ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring!");
			return execution.execute(request, body);
		};rt=new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}

	public RecipeResponse getRecipes(String text, String cals, String diet,String recordCount) {

		String url="https://api.edamam.com/search?q={text}&app_id={apiId}&app_key={apiKey}&from=0&to={recordCount}&";
		RecipeResponse response=null;
		
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
	
	public  List<Recipe> getRecipeById(String uri) { 
		
		//uri="http://www.edamam.com/ontologies/edamam.owl#recipe_1b6dfeaf0988f96b187c7c9bb69a14fa";
		
		
		//System.out.println("uri: "+uri);
		uri=URLEncoder.encode(uri, Charset.defaultCharset());
		//System.out.println("uri: "+uri);
		
		/*UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("https://api.edamam.com/search");
		b.queryParam("r", uri);
		b.queryParam("app_id", appId);
		b.queryParam("app_key", appKey);
		URI uri = b.build().toUri();*/
Recipe[] response = rt.getForObject(uri, Recipe[].class);


		
		String url="https://api.edamam.com/search?r={uri}&app_id={apiId}&app_key={apiKey}";
//		
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
//		//Add the Jackson Message converter
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//
//		// Note: here we are making this converter to process any kind of response, 
//		// not only application/*json, which is the default behaviour
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
//		messageConverters.add(converter);  
//		rt.setMessageConverters(messageConverters); 
		
		

		List<Recipe> recipeLst=new ArrayList<Recipe>();
		// Recipe[] recipe = new ArrayList<Recipe>();
		 // Recipe[] recipe= {};
		// Recipe[] recipe= new Recipe[];
		// Recipe recipe[]; 
		 
		  Recipe[] recipe = rt.getForObject(url, Recipe[].class,uri,apiId,apiKey) ;
		  System.out.println("responsddd"+recipe.length);
		  recipeLst= Arrays.asList(recipe);
		  
		    
		//recipe.add(r);
		return recipeLst;
		
		
//		 
//		HttpHeaders headers = new HttpHeaders();  
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//		ResponseEntity<List<Recipe>> r	=rt.exchange(url,HttpMethod.GET, entity, new ParameterizedTypeReference<List<Recipe>>(){},uri,apiId,apiKey);
//		 System.out.println("responsddd"+ r);		
//		return  r.getBody();
//		
		
	}

}
