package com.sagarandcompany.linkSharing.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

@Service
public class CloudnaryService {
    @Value("${cloudnary.cloudname}")
    String mCloudName;

    @Value("${cloudnary.apikey}")
    String mApiKey;

    @Value("${cloudnary.apisecret}")
    String mApiSecret;

    public String upload(MultipartFile aFile) {
        Cloudinary c = new Cloudinary("cloudinary://" + mApiKey + ":" + mApiSecret + "@" + mCloudName);
        try {
            File f = Files.createTempFile("temp", aFile.getOriginalFilename()).toFile();
            aFile.transferTo(f);

            Map response = c.uploader().upload(f, ObjectUtils.emptyMap());
            JSONObject json = new JSONObject(response);
            return json.getString("url");
        } catch (Exception e) {
            return null;
        }
    }
}
