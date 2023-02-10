package com.wp.system.config.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FirebaseBeans {

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException  {
        FileWriter writer = new FileWriter("conf.json");
        writer.write("{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"wp-system-828af\",\n" +
                "  \"private_key_id\": \"5a62d45be2d8c6a940db50887879c62e190e58f7\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCQasSYWlwBrT2f\\njULH1yC7dov9pgJPAwFljB0kJqw3bo908XttxXLpM3St9suRT3HUaxpeho1rGGJP\\nC35Zw8jWNaSXkNETed2oZK8PLwX4bEv4iyIlX2A0Eq9x+UtCgbDfHzERis8fsquN\\nNqkspym1wso7W3SUPOhGuWfHW/odIsPjHlJKaFA21sVZ1QuBkqnaPk8nx9ri+hDM\\ncLDhTKRm+9fjrgoFVph/WUA7AJWZ7jSqOATrrHWRqoowH3zbMFgsUTFAfjFZEdPC\\nyBoZ/6ENzqbrBDmo+Vw46On2Z1O5cLq2KgltA0eURxK9p13ivIJtCc7/biO+UmsG\\nZvpOOz+PAgMBAAECggEALjyoxdiERZsoNCmffGkBl1NsnaClc5OUQmVaPSVOlQ7G\\nSlw4Ntx1Hnm1fS8bXOIxIR/LWQE+TNAJRaJ56RZ4ejDBii846UHmuE/IBpX5FODj\\nb+dn3sxK+lETL+vvbxMjxEPxy1qEVvM23qbmAiBhB8seQWPWDtHzUhVxRxBJI0Nv\\naKn6u4PACBvPgqfFAVN5Wnt9c19jneoTHCmrWo6zoaeUUavncObY4kEtho9gZDeA\\nqsJgfajMvoXwmGnvieAYg85BhlQwUbrldo0DT3GreFd12rDWuyxsgVrJ9z3n7PNS\\nXtXwERuxOUTd9BAgxmLczA4ikGJKcPBUu4cMBbhTAQKBgQDKWWBORM3z53wiuoH1\\n9ZQ0sZ+EqSbatevVCpVUdKY05dZAD/Vxl6HUmHCbTge6fMjn/lWYvwWUcz2e2F4j\\nY0AtwWIZ/cLioE00OQGRbN4U5Wg203NUhsuaPxSZ7vF+PiCTG37EtbNJU9M+4EYW\\nZMf6difBzjCbvcb4GamdsDB4jwKBgQC2tTPKL0+jHj4F9d3MI/i3DgyXbKc5H/lj\\naZzA06v0PK4samVz6IU3QgEN5zh+vExcfIJCmByRZVoGcTSXW8u0lckQQzeTSlTQ\\na7ODyMvWyfx/Te4BVcw6zTOv7pKSC1zzAunlQGbfFfAuEKJHuUE3TQOoIMogpD5Y\\nSVCUirZJAQKBgQC/9zaUSlYQ1EVCNSpiCw8FRpWNJ2RDDV+khxvQObIMcRdnQzyY\\n/T98DvqVe9t9IjD/VpwiAubqRMHq1l3IuLoELnhBLCsdEPLtXj+MlXnC3TiW+tdp\\nE1BJDxseRj84gvwoU2daev6RzEKWXfJgAFBv3nQtOs2Gku4WJVJy1NnHJQKBgQCn\\nRMdQP/YZsRM5Y7mWLgyCkkMm0ltZ6hLoV4Uh5+fSJ0eR9CpDbkmfqDbM4rWPGZaT\\nSY37p8Tnu7EqmrN6KpkZD9ROpisYFoIFecSUTt2HG86lQdQ2trTN1JWQaMsZF3wW\\nIsG9lzNW43/KvIHFRi4VkdVaNAK41YUaUKyMAV4XAQKBgQC8lpqbDhkajjnZOh14\\nN8H8iCUTi9G9KyY/SRmNC/BR2wkAGcEVdhry4qEvUkVbZBGktBC69LlHZubhYQgB\\nN4cwdo0zlj9HFsttDeOwE5npjq34UQwkToeEqUxMj1Wmn7uoJbBqC5BfkJtnXaFP\\nPBabdgowvykPCuc/pKcua4qb0Q==\\n-----END PRIVATE KEY-----\\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-k2wjw@wp-system-828af.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"109506068360028799487\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-k2wjw%40wp-system-828af.iam.gserviceaccount.com\"\n" +
                "}");

        writer.close();

        FileInputStream configStream = new FileInputStream("conf.json");

        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(configStream)).build();

        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions);

        return FirebaseMessaging.getInstance(app);
    }
}
