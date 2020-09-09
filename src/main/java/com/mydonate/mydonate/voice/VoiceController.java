package com.mydonate.mydonate.voice;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.model.OutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class VoiceController {
    private static final Logger logger = LoggerFactory.getLogger(VoiceController.class);

    @GetMapping("/voice")
    public ResponseEntity greeting(@RequestParam(value = "text", defaultValue = "오승욱 화이팅!") String text) throws IOException {
        Polly helloWorld = new Polly(Region.getRegion(Regions.AP_NORTHEAST_2));
        InputStream speechStream = helloWorld.synthesize(text, OutputFormat.Mp3);
        InputStreamResource inputStreamResource = new InputStreamResource(speechStream);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setCacheControl(CacheControl.noCache().getHeaderValue());
        httpHeaders.setContentType(MediaType.valueOf("audio/mpeg"));

        return new ResponseEntity(inputStreamResource, httpHeaders, HttpStatus.OK);
    }
}
