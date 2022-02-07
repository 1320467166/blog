package com.example.blog.utils;

import org.springframework.stereotype.Component;

/**
 * author yjs
 */
@Component
public class CodeUtil {
    public String codeGenerate() {
        String finalCode = "";
        for (int i = 0; i<6; i++){
            int code = (int)(Math.random() * 10);
            finalCode += code;
        }
        return finalCode;
    }
}
