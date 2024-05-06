package com.spring.aulaNove.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
public class ControladorUploadArquivos {

    @PostMapping("/upload")
    public ResponseEntity<String> enviarUploadArquivo(@RequestParam("file") MultipartFile arquivo) {
        // Verifique se o arquivo não está vazio
        if (arquivo.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo vazio");
        }

        try {
            // Salve o arquivo no diretório de upload
            String nomeArquivo = arquivo.getOriginalFilename();
            File arquivoDestino = new File("C:\\eclipse-workspace\\aulaNove\\src\\main\\java\\download" + nomeArquivo);
            arquivo.transferTo(arquivoDestino);
            return ResponseEntity.ok("Arquivo enviado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Falha ao enviar o arquivo");
        }
    }
}
