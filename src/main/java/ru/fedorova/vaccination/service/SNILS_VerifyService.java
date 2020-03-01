package ru.fedorova.vaccination.service;

public class SNILS_VerifyService {
        /*
    СНИЛС имеет вид: «XXX-XXX-XXX YY», где XXX-XXX-XXX — собственно номер, а YY — контрольное число. Алгоритм формирования контрольного числа СНИЛС таков:
    1) Проверка контрольного числа Страхового номера проводится только для номеров больше номера 001-001-998
    2) Контрольное число СНИЛС рассчитывается следующим образом:
    2.1) Каждая цифра СНИЛС умножается на номер своей позиции (позиции отсчитываются с конца)
    2.2) Полученные произведения суммируются
    2.3) Если сумма меньше 100, то контрольное число равно самой сумме
    2.4) Если сумма равна 100 или 101, то контрольное число равно 00
    2.5) Если сумма больше 101, то сумма делится по остатку на 101 и контрольное число определяется остатком от деления аналогично пунктам 2.3*/

    public boolean SNILSChecksumCalculation(Long SNILS_l) {
        String SNILS = Long.toString(SNILS_l);
        return SNILSChecksumCalculation(SNILS);
    }

    public boolean SNILSChecksumCalculation(String SNILS) {
        boolean result;
        int checksum;
        String SNILSnum;
        int resultSum = 0;

        checksum = Integer.parseInt(SNILS.substring(9));
        SNILSnum = SNILS.substring(0, 9);
        int reversIndex = 9;
        char[] numArray = SNILSnum.toCharArray();
        for (int i = 0; i < 9; i++) {
            String s = Character.toString(numArray[i]);
            int n = Integer.parseInt(s);
            resultSum = resultSum + n * reversIndex;
            reversIndex--;
        }
        result = SNILSchecksumCompare(checksum, resultSum);
        return result;


    }

    public boolean SNILSchecksumCompare(int checksum, int resultSum) {
        boolean result;
        if (resultSum < 100) {
            result = resultSum == checksum;
        } else if ((resultSum == 100) || (resultSum == 101)) {
            return result = 00 == checksum;
        } else if (resultSum > 101) {

            return result = SNILSchecksumCompare(checksum, resultSum % 101);
        } else result = false;
        return result;
    }
}

