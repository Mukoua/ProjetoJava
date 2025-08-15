package dev.Anderson.My_First_Web_App.controllers;

import dev.Anderson.My_First_Web_App.data.dto.PersonDTO;
import dev.Anderson.My_First_Web_App.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
@Tag(name= "People" , description = "Endpoints for Managing People")
public class PersonController {

    @Autowired
    private PersonServices service;
    // private PersonServices service = new PersonServices();

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_YAML_VALUE})
    @Operation(summary = "Find All People",
       description = "Find All People",
       tags = {"People"},
       responses ={
               @ApiResponse (description = "Sucess",
                       responseCode = "200",
                       content = {
                               @Content(
                                       mediaType = MediaType.APPLICATION_JSON_VALUE,
                                       array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class))
                               )
                       }),
               @ApiResponse (description = "No Content", responseCode = "204", content = @Content),
               @ApiResponse (description = "Bad Request", responseCode = "204", content = @Content),
               @ApiResponse (description = "Unnauthorized", responseCode = "401", content = @Content),
               @ApiResponse (description = "Not found", responseCode = "404", content = @Content),
               @ApiResponse (description = "Internal Server Error", responseCode = "500", content = @Content)
       }
    )
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )
    @Operation(summary = "Find a Person",
            description = "Find a especific person by your ID",
            tags = {"People"},
            responses ={
                    @ApiResponse (description = "Sucess",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))

                            ),
                    @ApiResponse (description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse (description = "Bad Request", responseCode = "204", content = @Content),
                    @ApiResponse (description = "Unnauthorized", responseCode = "401", content = @Content),
                    @ApiResponse (description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse (description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )
    @Operation(summary = "Adds a new Person",
            description = "Adds a new person by passing in a JSON, XML or YML representation of the person.",
            tags = {"People"},
            responses ={
                    @ApiResponse (description = "Sucess",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))

                    ),
                    @ApiResponse (description = "Bad Request", responseCode = "204", content = @Content),
                    @ApiResponse (description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse (description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PutMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )
    @Operation(summary = "Updates a person's information",
            description = "Updates a person's information by passing in a JSON, XML or YML representation of the updated person.",
            tags = {"People"},
            responses ={
                    @ApiResponse (description = "Sucess",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))

                    ),
                    @ApiResponse (description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse (description = "Bad Request", responseCode = "204", content = @Content),
                    @ApiResponse (description = "Unnauthorized", responseCode = "401", content = @Content),
                    @ApiResponse (description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse (description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }



    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletes a Person",
            description = "Deletes a especific person by ID.",
            tags = {"People"},
            responses ={
                    @ApiResponse (description = "No Content",
                            responseCode = "204",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))

                    ),
                    @ApiResponse (description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse (description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse (description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse (description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
