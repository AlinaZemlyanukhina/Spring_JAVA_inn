package com.example.inn;

import org.springframework.stereotype.Service;

@Service
public class InnService {

    public String validateInn(String inn) {
        if (inn == null || inn.isEmpty() || !inn.matches("\\d+")) {
            return "ИНН не должен быть пустым и должен содержать только цифры.";
        }

        if (inn.length() == 10) {
            return validateInn10(inn);
        } else if (inn.length() == 12) {
            return validateInn12(inn);
        } else {
            return "ИНН должен содержать 10 или 12 цифр.";
        }
    }

    private String validateInn10(String inn) {
        int[] multipliers = {2, 4, 10, 3, 5, 9, 4, 6, 8};
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(inn.charAt(i)) * multipliers[i];
        }

        int controlNumber1 = (sum / 11) * 11;
        int controlNumber2 = sum - controlNumber1;

        if (controlNumber2 == 10) {
            controlNumber2 = 0;
        }

        if (controlNumber2 != Character.getNumericValue(inn.charAt(9))) {
            return "ИНН не подлинный";
        }

        return "ИНН подлинный. Организация: " + getOrganizationName(Character.getNumericValue(inn.charAt(0)));
    }

    private String validateInn12(String inn) {
        int[] multipliers10 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int[] multipliers11 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

        // Проверка 11-й цифры
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(inn.charAt(i)) * multipliers10[i];
        }

        int controlNumber1 = (sum / 11) * 11;
        int controlNumber2 = sum - controlNumber1;
        if (controlNumber2 == 10) {
            controlNumber2 = 0;
        }

        if (controlNumber2 != Character.getNumericValue(inn.charAt(10))) {
            return "ИНН не подлинный";
        }

        // Проверка 12-й цифры
        sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += Character.getNumericValue(inn.charAt(i)) * multipliers11[i];
        }

        controlNumber2 = (sum / 11) * 11;
        int controlNumber3 = sum - controlNumber2;
        if (controlNumber3 == 10) {
            controlNumber3 = 0;
        }

        if (controlNumber3 != Character.getNumericValue(inn.charAt(11))) {
            return "Инн не подлинный. Не прошел проверку.";
        }

        return "ИНН подлинный. Организация: " + getOrganizationName(Character.getNumericValue(inn.charAt(0)));
    }

    private String getOrganizationName(int firstDigit) {
        if (firstDigit < 5) {
            return "ООО \"Рога и копыта\"";
        } else if (firstDigit >= 5 && firstDigit < 8) {
            return "ООО \"Заглушкасервис\"";
        } else {
            return "ООО \"Волга\"";
        }
    }


}
