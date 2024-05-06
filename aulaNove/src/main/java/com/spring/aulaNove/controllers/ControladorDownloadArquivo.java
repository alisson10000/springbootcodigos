package com.spring.aulaNove.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class ControladorDownloadArquivo {

    private static final String DIRETORIO_DOWNLOAD = "C:\\eclipse-workspace\\aulaNove\\src\\main\\java\\download\\";

    @GetMapping("/download/{nomeArquivo}")
    public ResponseEntity<Resource> baixarArquivo(@PathVariable String nomeArquivo) {
        try {
            File arquivo = new File(DIRETORIO_DOWNLOAD + nomeArquivo);
            Resource recurso = new InputStreamResource(new FileInputStream(arquivo));

            // Configura o cabeçalho da resposta
            HttpHeaders cabecalhos = new HttpHeaders();
            cabecalhos.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            cabecalhos.setContentDispositionFormData("attachment", nomeArquivo);
            cabecalhos.setContentLength(arquivo.length());

            return new ResponseEntity<>(recurso, cabecalhos, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
