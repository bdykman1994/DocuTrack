package com.bj.docutrack.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "document_id")
    private long documentId;

    @Column(name = "document_name")
    private String documentName;

    @Lob
    @Column(name = "document_file")
    private byte[] documentFile;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "document_year")
    private Date documentYear;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date uploadDate;


}
