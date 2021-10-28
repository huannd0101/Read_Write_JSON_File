package com.example.json_file.controller;

import com.example.json_file.model.Address;
import com.example.json_file.model.User;
import com.example.json_file.utils.ConvertObject;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/read")
    public ResponseEntity<?> readJSONFile(@RequestParam(name = "file") MultipartFile file) throws IOException {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        InputStream inputStream = new FileInputStream(ConvertObject.convertMultipartToFile(file));

        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
        List<User> users = mapper.readValue(inputStream, typeReference);
//        List users = mapper.readValue(inputStream, List.class);  //cách 2

        users.forEach(System.out::println);

        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/write")
    public ResponseEntity<?> writeObjectToFile() throws IOException {
        User user = new User(1, "huannd0101", "huan123", new Address(1, "Điện Biên"));

        mapper.writeValue(new File("data.json"), user);
        mapper.writeValue(new File("data.json"), user);

        return ResponseEntity.status(200).body("Success");
    }

     @GetMapping("/writes")
     public ResponseEntity<?> writeListObjectToFile() throws IOException {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "huannd0101", "huan123", new Address(1, "Điện Biên")));
        users.add(new User(2, "huannd0103", "huan123", new Address(2, "Hà Nội")));

        return ResponseEntity.status(200).body(mapper.writeValueAsString(users));
     }



}
