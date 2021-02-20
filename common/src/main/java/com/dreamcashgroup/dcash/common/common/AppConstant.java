package com.dreamcashgroup.dcash.common.common;

import java.security.SecureRandom;
import java.util.Random;

public class AppConstant {

    // Constants for code generation
    public static final Random RANDOM = new SecureRandom();
    public static final String ALL_LETTERS = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
    public static final String SMALL_LETTERS = "abcdefghjkmnpqrstuvwxyz";
    public static final String CAPITAL_LETTERS = "ABCDEFGHJKMNPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    public static final String DIGITS_LETTERS = "abcdefghjkmnpqrstuvwxyz23456789";
    public static final String ALL_DIGITS_LETTERS = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";

}
