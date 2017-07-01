package com.example.muhammadahsan.smartchat;

import java.util.Random;

public class GenerateKey {
    private int randomKey;

    public int getKey(){

        Random key = new Random();

        for (int i=0; i<=999999;i++){
            randomKey = key.nextInt(999999);
            if (String.valueOf(randomKey).length() == 6){
                break;
            }
        }
        return randomKey;
    }
}
