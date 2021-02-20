package com.dreamcashgroup.dcash.user.util;

import java.util.UUID;

import static com.dreamcashgroup.dcash.common.common.AppConstant.*;

public class Utils {
    // Générer une chaine aléatoire d'une taille donnée
    public static String generateRandomCode(int length) {
        String code = "";
        for (int i=0; i < length; i++){
            int index = (int)(RANDOM.nextDouble()*SMALL_LETTERS.length());
            code += SMALL_LETTERS.substring(index, index+1);
        }
        return code;
    }

    // Générer un code aléatoire ne contenant que des chiffres et possédant une certaine longueur
    public static String generateRandomDigitsCode(int length) {
        String code = "";
        for (int i=0; i < length; i++)
        {
            int index = (int)(RANDOM.nextDouble() * DIGITS.length());
            code += DIGITS.substring(index, index+1);
        }
        return code;
    }

    // Générer un code aléatoire contenant des chiffres et des lettres ayant une taille donnée
    public static String generateRandomDigitsLettersCode(int length) {
        String code = "";
        for (int i=0; i < length; i++)
        {
            int index = (int)(RANDOM.nextDouble()*DIGITS_LETTERS.length());
            code += DIGITS_LETTERS.substring(index, index+1);
        }
        return code;
    }

    // Génération d'un code UUID aléatoire
    public static String generateRandomUuid() {
        return UUID.randomUUID().toString();
    }

    // Normaliser un entier n sur une chaine de 4 caractères
    public static String formatToDigits(int n) {
        switch (String.valueOf(n).length()) {
            case 0:
                return "0000";
            case 1:
                return "000" + n;
            case 2:
                return "00" + n;
            case 3:
                return "0" + n;
            default:
                return String.valueOf(n);
        }
    }
}
