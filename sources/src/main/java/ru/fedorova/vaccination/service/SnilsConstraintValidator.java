package ru.fedorova.vaccination.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SnilsConstraintValidator implements ConstraintValidator<Snils, String> {
        /**
         *Класс содержит логику для валидатора СНИЛС с помощью аннтоации @Snils
         *
         *
         * СНИЛС имеет вид: «XXX-XXX-XXX YY», где XXX-XXX-XXX — собственно номер, а YY — контрольное число. Алгоритм формирования контрольного числа СНИЛС таков:
         * 1) Проверка контрольного числа Страхового номера проводится только для номеров больше номера 001-001-998
         * 2) Контрольное число СНИЛС рассчитывается следующим образом:
         * 2.1) Каждая цифра СНИЛС умножается на номер своей позиции (позиции отсчитываются с конца)
         * 2.2) Полученные произведения суммируются
         * 2.3) Если сумма меньше 100, то контрольное число равно самой сумме
         * 2.4) Если сумма равна 100 или 101, то контрольное число равно 00
         * 2.5) Если сумма больше 101, то сумма делится по остатку на 101 и контрольное число определяется остатком от деления аналогично пунктам 2.3*/
        @Override
        public void initialize(Snils snils) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

    /**
     * Принимает СНИЛС в виде строки, рассчитывает контрольную сумму? сравнивает и возвращает булево значение
     * @param snils
     * @param cxt
     * @return boolean
     */
    @Override
    public boolean isValid(String snils, ConstraintValidatorContext cxt) {
        boolean result;
        int checksum;
        String snilsNum;
        int resultSum = 0;

        checksum = Integer.parseInt(snils.substring(9));
        snilsNum = snils.substring(0, 9);
        int reversIndex = 9;
        char[] numArray = snilsNum.toCharArray();
        for (int i = 0; i < 9; i++) {
            String s = Character.toString(numArray[i]);
            int n = Integer.parseInt(s);
            resultSum = resultSum + n * reversIndex;
            reversIndex--;
        }
        result = SNILSchecksumCompare(checksum, resultSum);
        return result;

    }

    /**
     * Принамает номер и контрольную сумму, делает необходимые преобразования и возвращает булево значение
     * @param checksum
     * @param resultSum
     * @return boolean
     */
    public boolean SNILSchecksumCompare(int checksum, int resultSum) {
        boolean result;
        if (resultSum < 100) {
            result = resultSum == checksum;
        } else if ((resultSum == 100) || (resultSum == 101)) {
            return result = (00 == checksum);
        } else if (resultSum > 101) {
            return result = SNILSchecksumCompare(checksum, resultSum % 101);
        } else result = false;
        return result;
    }
}

