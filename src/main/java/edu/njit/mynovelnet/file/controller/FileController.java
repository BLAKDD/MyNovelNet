package edu.njit.mynovelnet.file.controller;

import edu.njit.mynovelnet.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping("getFile")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileId, int size)
            throws IOException {
        return fileService.downloadImage(fileId, size);
        //0963211c-60d0-4758-a835-30c7b4d6457c";
    }

    @RequestMapping("getCoverRecomImage")
    @ResponseBody
    public ResponseEntity<byte[]> getCoverRecomImage(Long startTime)
            throws IOException {
        return fileService.downloadCoverRecImage(startTime);
        //0963211c-60d0-4758-a835-30c7b4d6457c";
    }

    @RequestMapping("to90")
    @ResponseBody
    public String to90(String fileId)
            throws IOException {
        System.out.println("fileid=" + fileId);
        return fileService.to90(fileId);
        //0963211c-60d0-4758-a835-30c7b4d6457c";
    }

    @RequestMapping("getLogo")
    @ResponseBody
    public ResponseEntity<byte[]> getLogo() throws IOException {
        return fileService.downloadLogo();
        //0963211c-60d0-4758-a835-30c7b4d6457c";
    }
}
