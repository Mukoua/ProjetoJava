package dev.Anderson.My_First_Web_App.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


//via EXTENSION. http://localhost:8080/api/person/v1/2.xml or http://localhost:8080/api/person/vi/v.json

    //via QUERY PARAM http://localhost:8080/api/person/v1/2?mediaType=xml

/**   @Override
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
