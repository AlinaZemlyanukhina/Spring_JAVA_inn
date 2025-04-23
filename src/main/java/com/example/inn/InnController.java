//package com.example.inn;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class InnController {
//
//    @PostMapping(value = "/validate")
//    public String validateInn(@RequestBody Inn request) {
//        return validate(request);
//    }
//
//    private String validate(Inn request) {
//        String inn = request.getInn();
//
//        // Проверяем, что ИНН не пустой и состоит из 10 или 12 цифр
//        if (inn == null || (inn.length() != 10 && inn.length() != 12)) {
//            return "ИНН должен содержать 10 или 12 цифр.";
//        }
//
//        // Проверяем, что все символы являются цифрами
//        for (char c : inn.toCharArray()) {
//            if (!Character.isDigit(c)) {
//                return "ИНН должен содержать только цифры.";
//            }
//        }
//
//        /*
//        1.Алгоритм проверки 10-го значного ИНН.
//        ИНН.10. 1)Находим произведения первых 9-ти цифр ИНН на спепиальные множители соотственно. 9 множителей ( 2 4 10 3 5 9 4 6 8 ).
//            ИНН.10. 2) Складываем все 9-ть получившихся произведений.
//        ИНН.10. 3) Получившуюся сумму делим на число 11 и извлекаем целую часть частного от деления.
//                ИНН.10. 4) Умножаем получившееся число на 11.
//        ИНН.10. 5) Сравниваем числа получившиеся на шаге 2 и шаге 4, их разница, и есть контрольное число, которое и должно равняться 10-й цифре в ИНН.
//        (Если контрольное число получилось равным 10-ти, в этом случае принимаем контрольное число равным 0.)
//        */
//
//        private String validate10(String inn)
//        if (inn.length() == 10) {
//            int n1 = Character.getNumericValue(inn.charAt(0)) * 2 +
//                    Character.getNumericValue(inn.charAt(1)) * 4 +
//                    Character.getNumericValue(inn.charAt(2)) * 10 +
//                    Character.getNumericValue(inn.charAt(3)) * 3 +
//                    Character.getNumericValue(inn.charAt(4)) * 5 +
//                    Character.getNumericValue(inn.charAt(5)) * 9 +
//                    Character.getNumericValue(inn.charAt(6)) * 4 +
//                    Character.getNumericValue(inn.charAt(7)) * 6 +
//                    Character.getNumericValue(inn.charAt(8)) * 8;
//            int n2 = n1 / 11;
//            int n3 = n2 *11;
//            int n4 = n1 - n3;
//            System.out.println(n4);
//
//            if (Character.getNumericValue(inn.charAt(9)) == n4){
//                return "ИНН подлинный";
//            }
//
//            else
//
//                /*
//                2.Алгоритм проверки 12-го значног ИНН.
//            ИНН.12. 1)Находим произведения первых 10-ти цифр ИНН на спепиальные множители соотственно (10-ю цифру принимаем за 0). 10 множителей ( 7 2 4 10 3 5 9 4 6 8 ).
//            ИНН.12. 2) Складываем все 10-ть получившихся произведений.
//            ИНН.12. 3) Получившуюся сумму делим на число 11 и извлекаем целую часть частного от деления.
//            ИНН.12. 4) Умножаем получившееся число на 11. ИНН.12. 5) Сравниваем числа получившиеся на шаге 2 и шаге 4, их разница,
//                     и есть первое контрольное число, которое и должно равняться 11-й цифре в ИНН.(Если контрольное число получилось равным 10-ти,
//                     в этом случае принимаем контрольное число равным 0.) Если получившееся число не не равно 11-ой цифре ИНН, значит ИНН не верный,
//                     если же совпадает, тогда высчитываем следующее контрольное число, которое должно быть равным 12-ой цифре ИНН
//            ИНН.12. 6)Находим произведения первых 11-ти цифр ИНН на спепиальные множители соотственно (10-ю цифру принимаем за 0).
//            11 множителей ( 3 7 2 4 10 3 5 9 4 6 8 ).
//            ИНН.12. 7) Складываем все 11-ть получившихся произведений.
//            ИНН.12. 8) Получившуюся сумму делим на число 11 и извлекаем целую часть частного от деления.
//            ИНН.12. 9) Умножаем получившееся число на 11.
//            ИНН.12. 10) Сравниваем числа получившиеся на шаге 7 и шаге 9, их разница, и есть контрольное число, которое и должно равняться 12-й цифре в ИНН.
//             (Если контрольное число получилось равным 10-ти, в этом случае принимаем контрольное число равным 0.)
//             Если высчитанное число равно 12-ой цифре ИНН, и на первом этапе все контрольное число совпало с 11-ой цифрой ИНН, следовательно ИНН считается верным.
//            */
//
//                if (inn.length() == 12) {
//                int m1 = Character.getNumericValue(inn.charAt(0)) * 7 +
//                        Character.getNumericValue(inn.charAt(1)) * 2 +
//                        Character.getNumericValue(inn.charAt(2)) * 4 +
//                        Character.getNumericValue(inn.charAt(3)) * 10 +
//                        Character.getNumericValue(inn.charAt(4)) * 3 +
//                        Character.getNumericValue(inn.charAt(5)) * 5 +
//                        Character.getNumericValue(inn.charAt(6)) * 9 +
//                        Character.getNumericValue(inn.charAt(7)) * 4 +
//                        Character.getNumericValue(inn.charAt(8)) * 6 +
//                        Character.getNumericValue(inn.charAt(9)) * 8;
//                    int m2 = m1 / 11;
//                    int m3 = m2 * 11;
//                    int m4 = m1 - m3;
//
//                    if (m4 == 10){
//                        m4 = 0;
//                    }
//
//                    if (Character.getNumericValue(inn.charAt(10)) != m4) {
//                        return "ИНН не подлинный";
//                    }
//
//                    int c1 = Character.getNumericValue(inn.charAt(0)) * 3 +
//                            Character.getNumericValue(inn.charAt(1)) * 7 +
//                            Character.getNumericValue(inn.charAt(2)) * 2 +
//                            Character.getNumericValue(inn.charAt(3)) * 4 +
//                            Character.getNumericValue(inn.charAt(4)) * 10 +
//                            Character.getNumericValue(inn.charAt(5)) * 3 +
//                            Character.getNumericValue(inn.charAt(6)) * 5 +
//                            Character.getNumericValue(inn.charAt(7)) * 9 +
//                            Character.getNumericValue(inn.charAt(8)) * 4 +
//                            Character.getNumericValue(inn.charAt(9)) * 6 +
//                            Character.getNumericValue(inn.charAt(10)) * 8;
//                    int c2 = c1 / 11;
//                    int c3 = c2 * 11;
//                    int c4 = c1 - c3;
//
//                    if (c4 == 10){
//                        c4 = 0;
//                    }
//
//                    if (Character.getNumericValue(inn.charAt(11)) != c4) {
//                        return "ИНН не подлинный";
//                    }
//
//                    if (Character.getNumericValue(inn.charAt(10)) == m4 && Character.getNumericValue(inn.charAt(11)) == c4) {
//                        return "ИНН подлинный";
//                    }
//
//            }
//
//
//        }
//
//        // Получаем первую цифру ИНН
//        int firstDigit;
//        try {
//            firstDigit = Character.getNumericValue(inn.charAt(0));
//        } catch (IndexOutOfBoundsException e) {
//            return "ИНН не корректен.";
//        }
//        // Проверка первой цифры ИНН и вывод названия организации
//        if (firstDigit < 5) {
//            return "ООО 'Рога и копыта'";
//        } else if (firstDigit >= 5 && firstDigit < 8) {
//            return "ООО 'Заглушка сервис'";
//        } else { // firstDigit >= 8
//            return "ООО 'Волга'";
//        }
//    }
//}
