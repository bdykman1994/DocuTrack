package com.bj.docutrack.service;

import com.bj.docutrack.model.Document;
import com.bj.docutrack.model.DocumentForm;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    public void save(DocumentForm documentForm) throws IOException;

    public List<Document> getAllDocuments();

    public Document getDocumentById(Long id);

}
