package com.group4.projectcodegeneration.util;

import java.util.Random;

public class IbanGenerator {

    private static final String BANK_CODE = "INHO";
    private static final String COUNTRY_CODE = "NL";
    private static final int ACCOUNT_NUMBER_LENGTH = 9;

    public static String generateIban() {
        String accountNumber = generateAccountNumber();
        String rawIban = COUNTRY_CODE + "00" + BANK_CODE + accountNumber;
        String checkDigits = calculateCheckDigits(rawIban);
        return COUNTRY_CODE + checkDigits + BANK_CODE + accountNumber;
    }

    private static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder(ACCOUNT_NUMBER_LENGTH);
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    private static String calculateCheckDigits(String rawIban) {
        String rearranged = rawIban.substring(4) + rawIban.substring(0, 4);
        StringBuilder numeric = new StringBuilder();
        for (int i = 0; i < rearranged.length(); i++) {
            numeric.append(Character.getNumericValue(rearranged.charAt(i)));
        }
        int modResult = Integer.parseInt(numeric.toString()) % 97;
        return String.format("%02d", 98 - modResult);
    }
}
