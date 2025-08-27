package dev.Anderson.My_First_Web_App.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.originPatterns:default}")
    private String corsOriginPatterns = "";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        var allowedOrigins = corsOriginPatterns.split(",");
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                //.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedMethods("*")
                .allowCredentials(true);
    }

//via EXTENSION. http://localhost:8080/api/person/v1/2.xml or http://localhost:8080/api/person/vi/v.json

    //via QUERY PARAM http://localhost:8080/api/person/v1/2?mediaType=xml

  /**@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                    .mediaType("jason",MediaType.APPLICATION_JSON)
                    .mediaType("xml",MediaType.APPLICATION_XML); */



//via HEADER PARAM http://localhost:8080/api/person/v1/2?mediaType=xml

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(false)
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("jason",MediaType.APPLICATION_JSON)
            .mediaType("xml",MediaType.APPLICATION_XML)
            .mediaType("yaml",MediaType.APPLICATION_YAML);






    }
}
