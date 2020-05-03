package edu.njit.mynovelnet.file.service.serviceimpl;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import edu.njit.mynovelnet.file.service.FileService;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;

@Service("fileService")
public class FileServiceImpl implements FileService {

    private String localPath = "d:/BYSJFileRep/";

    private void testResizeImage(String inPath, String outPath, int newWidth, int newHeight) throws IOException {
        InputStream inputStream = new FileInputStream(new File(inPath));
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
        Graphics garphics = image.createGraphics();
        garphics.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
        OutputStream outputStream = new FileOutputStream(new File(outPath));
        JPEGImageEncoder j = JPEGCodec.createJPEGEncoder(outputStream);
        j.encode(image);
        outputStream.close();
    }

    private ResponseEntity<byte[]> downloadImage(String filePath) {
        return null;
    }


    @Override
    public ResponseEntity<byte[]> download(String fileId) throws IOException {
        String fileName = "90.jpg";
        fileName = URLEncoder.encode(fileName, "UTF8");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);//告知浏览器以下载方式打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置MIME类型
        File file =
                new File(localPath + File.separator + "novelCover" + File.separator + fileId + File.separator + fileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @Override
    public String addFile(FileItem list) {
        return null;
    }

    @Override
    public String to90(String novelUuid) throws IOException {
        String fileName = "150.jpg";
        fileName = URLEncoder.encode(fileName, "UTF8");
        String fileName2 = "90.jpg";
        String filePath1 = localPath + File.separator + novelUuid + File.separator + fileName;
        String filePath2 = localPath + File.separator + novelUuid + File.separator + fileName2;
        testResizeImage(filePath1, filePath2, 90, 120);
        return "Success";
    }

    @Override
    public ResponseEntity<byte[]> downloadImage(String fileId, int size) throws IOException {
        String fileName = size + ".jpg";
        fileName = URLEncoder.encode(fileName, "UTF8");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);//告知浏览器以下载方式打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置MIME类型
        File file =
                new File(localPath + File.separator + "novelCover" + File.separator + fileId + File.separator + fileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<byte[]> downloadCoverRecImage(Long startTime) throws IOException {
        String fileName = startTime + ".jpg";
        fileName = URLEncoder.encode(fileName, "UTF8");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);//告知浏览器以下载方式打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置MIME类型
        File file =
                new File(localPath + File.separator + "recommendCover" + File.separator + fileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<byte[]> downloadLogo() throws IOException {
        String fileName = "logo.png";
        fileName = URLEncoder.encode(fileName, "UTF8");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);//告知浏览器以下载方式打开
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置MIME类型
        File file =
                new File(localPath + File.separator + "logo" + File.separator + fileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
