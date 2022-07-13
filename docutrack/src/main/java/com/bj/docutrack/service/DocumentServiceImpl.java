package com.bj.docutrack.service;

import com.bj.docutrack.model.Document;
import com.bj.docutrack.model.DocumentForm;
import com.bj.docutrack.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void save(DocumentForm documentForm) throws IOException {

        Document _document = new Document();
        _document.setDocumentName(documentForm.getDocumentName());
        _document.setDocumentFile(documentForm.getDocumentFile().getBytes());
        _document.setContentType(documentForm.getDocumentFile().getContentType());

        documentRepository.save(_document);

    }

    @Override
    public List<Document> getAllDocuments() {

        List<Document> _documents = documentRepository.findAll();
        return _documents;

    }

    @Override
    public Document getDocumentById(Long id) {

        Document _document = documentRepository.findById(id).orElseThrow();
        return _document;

    }

}
