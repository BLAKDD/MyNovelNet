package edu.njit.mynovelnet.file.service;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FileService {
    ResponseEntity<byte[]> download(String fileId)
            throws IOException;

    String addFile(FileItem list);

    String to90(String novelUuid) throws IOException;

    ResponseEntity<byte[]> downloadImage(String fileId, int size) throws IOException;

    ResponseEntity<byte[]> downloadCoverRecImage(Long startTime) throws IOException;

    ResponseEntity<byte[]> downloadLogo() throws IOException;
}
