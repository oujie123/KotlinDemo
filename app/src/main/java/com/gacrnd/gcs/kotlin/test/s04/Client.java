package com.gacrnd.gcs.kotlin.test.s04;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;

import java.io.File;

/**
 * java调kotlin
 * @author Jack_Ou  created on 2020/8/5.
 */
public class Client {

    public static void main(String[] args) {
        File file = new File("/a.txt");
        String s = FilesKt.readText(file, Charsets.UTF_8);
        System.out.println(s);
    }
}
