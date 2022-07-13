package com.bj.docutrack.controller;

import com.bj.docutrack.model.Document;
import com.bj.docutrack.model.DocumentForm;
import com.bj.docutrack.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class AppController {

    @Autowired
    DocumentService documentService;

    @GetMapping(value = "/")
    public String index(@ModelAttribute("documentForm") DocumentForm documentForm, BindingResult result, Model model) {

        model.addAttribute("documents", documentService.getAllDocuments());

        return "uploadForm";
    }

    @PostMapping(value = "/upload")
    public String upload(@Valid @ModelAttribute("documentForm") DocumentForm documentForm, BindingResult result, RedirectAttributes redirectAttributes) throws IOException {

        documentService.save(documentForm);
        redirectAttributes.addFlashAttribute("uploadSuccess", "You have successfully saved a file!");

        return "redirect:/";
    }

    @GetMapping(value = "/download/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> download(HttpServletResponse response, @PathVariable("id") Long id, Document document, RedirectAttributes redirectAttributes) throws IOException {

        String test1 = "IMAGE/JPEG";

        Document _document = documentService.getDocumentById(id);
        byte[] file = _document.getDocumentFile();
        HttpHeaders headers = new HttpHeaders();
        String fileName = _document.getDocumentName();
        headers.setContentType(MediaType.valueOf(_document.getMediaType()));
        return ResponseEntity.ok().headers(headers).body(file);
    }
}
