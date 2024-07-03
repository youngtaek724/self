package com.example.app.swagger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/swagger-ui")
public class SwaggerController {

    @Value("classpath:/static/css/swagger/swagger-ui.css")
    private Resource resourceFile;

    @GetMapping(path = "/swagger-ui.css", produces = "text/css")
    public String getCss() throws IOException {
        try (InputStreamReader inputStreamReader = new InputStreamReader(resourceFile.getInputStream(), StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    static String toText(InputStream in) {
        return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
            .lines().collect(Collectors.joining("\n"));
          }
      }
