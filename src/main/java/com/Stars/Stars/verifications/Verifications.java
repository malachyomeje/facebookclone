package com.Stars.Stars.verifications;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@Getter
public class Verifications {

    public static Set<String> blackListedTokens = new HashSet<>();
    public static boolean validEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }


    public static boolean validPhoneNumber(String phoneNumber){
        String regex = "^(\\+234|0)[789]\\d{9}$";
        return phoneNumber.matches(regex);
    }

    public static boolean isTokenBlacklisted(String token){
//        Object[] arr= blackListedTokens.toArray();
//        System.out.println(Arrays.toString(arr));
//
//        if (blackListedTokens.size()>3){
//            for(int i=0; i<=500;i++){
//                blackListedTokens.remove(arr[i]);
//            }
//        }
////            blackListedTokens.clear();

       // blackListedTokens.add(token);
        return blackListedTokens.contains(token);
    }


}




