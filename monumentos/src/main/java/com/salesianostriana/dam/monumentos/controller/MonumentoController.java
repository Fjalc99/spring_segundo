package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepository;
import com.salesianostriana.dam.monumentos.service.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
@Tag(name= "Monumento", description = "El controlador de los monumentos, para poder realizar todas las operaciones de gestión")
public class MonumentoController {

    private final MonumentoRepository monumentorepository;
    private final MonumentoService monumentoService;


/*
    @GetMapping("/monumento/")
    public ResponseEntity<List<Monumento>> obtenerMonumentos() {
        List<Monumento> monumentos = monumentorepository.findAll();

        if (monumentos.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(monumentos);

    }

    */


    @Operation(summary = "Obtiene todos los monumentos y los puedes ordenar por nombre de ciudad",
    parameters = {
            @Parameter(name = "sort", description = "Ordenar por nombre de ciudad por asc o desc", required = false),

    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Se han encontrado los monumentos",
            content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
            examples = {@ExampleObject(
                    value = """
                            [
                             {
                                 "id": 1,
                                 "codPais": "ES",
                                 "nombrePais": "España",
                                 "nombreCiudad": "Sevilla",
                                 "latitud": "37°23′10″N",
                                 "longitud": "5°59′33″O",
                                 "nombreMonumento": "Giralda",
                                 "descripcion": "La giralda es de los monumentos mas antiguo de sevilla",
                                 "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg"
                             },
                                {
                                    "id": 1,
                                    "codPais": "ES",
                                    "nombrePais": "España",
                                    "nombreCiudad": "Sevilla",
                                    "latitud": "37°23′10″N",
                                    "longitud": "5°59′33″O",
                                    "nombreMonumento": "Giralda",
                                    "descripcion": "La giralda es de los monumentos mas antiguo de sevilla",
                                    "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg"
                                }

                            ]
                            """
                )}
            )}),

            @ApiResponse(responseCode = "404", description = "No se han encontrado monumentos",
            content = @Content)
    })
    @GetMapping
    public List<Monumento> obtenerMonumentos(@RequestParam(required = false, value = "sort", defaultValue = "no") String sortDirection) {
     return monumentoService.query(sortDirection);
    }



    @Operation(summary = "Obtiene el monumento por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                            
                             {
                                 "id": 1,
                                 "codPais": "ES",
                                 "nombrePais": "España",
                                 "nombreCiudad": "Sevilla",
                                 "latitud": "37°23′10″N",
                                 "longitud": "5°59′33″O",
                                 "nombreMonumento": "Giralda",
                                 "descripcion": "La giralda es de los monumentos mas antiguo de sevilla",
                                 "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg"
                             }
                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "404", description = "No se ha el encontrado monumento",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public Monumento obtenerMonumentoPorId(@PathVariable Long id) {
       return monumentoService.obtenerMonumentoPorId(id);
    }


    @Operation(summary = "Crea un monumento",
            parameters = {
                    @Parameter(name = "monumento", description = "El monumento a crear", required = true),

            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha creado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                {
                                    
                                    "codPais": "IT",
                                    "nombrePais": "Italia",
                                    "nombreCiudad": "Roma",
                                    "latitud": "41°54′N",
                                    "longitud": "12°30′E",
                                    "nombreMonumento": "Coliseo",
                                    "descripcion": "El Coliseo es un anfiteatro de la época del Imperio romano, construido en el siglo I y ubicado en el centro de la ciudad de Roma.",
                                    "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Colosseum_in_Rome%2C_Italy_-_April_2007.jpg/240px-Colosseum_in_Rome%2C_Italy_-_April_2007.jpg"
                                }

                            
                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "405", description = "No se ha podido crear el monumento",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Monumento> crearMonumento(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentorepository.save(monumento));
    }


    @Operation(summary = "Edita un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado un momumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                {
                                    "id": 4,
                                    "codPais": "IT",
                                    "nombrePais": "Italia",
                                    "nombreCiudad": "Milan",
                                    "latitud": "41°54′N",
                                    "longitud": "12°30′E",
                                    "nombreMonumento": "Duomo",
                                    "descripcion": "El Duomo es una catedral de Milán, en Lombardía, norte de Italia.",
                                    "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/Colosseum_in_Rome%2C_Italy_-_April_2007.jpg/240px-Colosseum_in_Rome%2C_Italy_-_April_2007.jpg"
                                }

                            
                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "404", description = "No se ha podido editar el monumento",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public Monumento editarMonumento(@RequestBody Monumento monumento, @PathVariable Long id) {
        return monumentoService.editarMonumento(monumento, id);

    }

    @Operation(summary = "Elimina un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Se ha eliminado el monumento",
                    content = @Content),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMonumento(@PathVariable Long id) {
        monumentorepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}