package hust.software.garbage.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: 小栗旬
 * @Date: 2020/3/2 16:09
 *
 * 文件上传工具，HTTP请求构造工具
 */
@Component
public class UploadUtil {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 机器学习组的识别接口
     */
    private static final String API_URL = "http://liuchao.hb.cn:8080/check_garbage_api";

    /**
     * 上传图片并识别
     * @param file
     * @return 识别结果
     */
    public String uploadPicAndIdentify(MultipartFile file) {
        /*  上传文件代码 */

        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        String filePath = "D://GarbagesPic//";
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transferAPI(dest);
    }


    /**
     * 调用远程接口识别
     * @param file
     * @return
     */
    public String transferAPI(File file) {
        FileSystemResource resource = new FileSystemResource(file);

        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("file", resource);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }
}
