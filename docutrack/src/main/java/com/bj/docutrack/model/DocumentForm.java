package com.bj.docutrack.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DocumentForm {

    private String documentName;

    private MultipartFile documentFile;

    private DocumentType documentType;

    private Date documentYear;
}
