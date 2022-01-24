import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Calc {


    public static void main(String[] args) throws Exception {


        // ----------------------------------Блок ввода данных-------------------------------//
        System.out.println("Введите 2 целых числа римскими или арабскими цифрами, от 0 д 10 и математический знак действия (пример: 1+4 или I+IV): ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            String[] value1 = value.split("\\+|\\*|/|-", 0);                             // разделяем строку

            if (value1.length > 2)
                throw new Exception("Т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+,-,/,*)");
            if (value1.length == 1) throw new Exception("Т.к. строка не является математической операцией");


            String part1 = value1[0];                                                              // выделяем первую часть уравнения
            String part2 = value1[1];                                                              // выделяем вторую часть уравнения


            //--------------------------------Проверка данных-------------------------------------//

            if (!(part1.equals("I") || part1.equals("II") || part1.equals("III") || part1.equals("IV") || part1.equals("V")
                    || part1.equals("VI") || part1.equals("VII") || part1.equals("VIII") || part1.equals("IX")
                    || part1.equals("X") || part1.equals("0") || part1.equals("1") || part1.equals("2")
                    || part1.equals("3") || part1.equals("4") || part1.equals("5") || part1.equals("6") || part1.equals("7")
                    || part1.equals("8") || part1.equals("9") || part1.equals("10")))
                throw new Exception("Введите другие данные");

            if (!(part2.equals("I") || part2.equals("II") || part2.equals("III") || part2.equals("IV") || part2.equals("V")
                    || part2.equals("VI") || part2.equals("VII") || part2.equals("VIII") || part2.equals("IX")
                    || part2.equals("X") || part2.equals("0") || part2.equals("1") || part2.equals("2")
                    || part2.equals("3") || part2.equals("4") || part2.equals("5") || part2.equals("6") || part2.equals("7")
                    || part2.equals("8") || part2.equals("9") || part2.equals("10")))
                throw new Exception("Введите другие данные");



            // ---------------------------Перевод данных----------------------------//

            int A = toArabic(part1);                                                                // переводим первую римскую цифру в арабскую

            int B = toArabic(part2);                                                                // переводим вторую римскую цифру в арабскую


            if ((A != 0 & B == 0) | (A == 0 & B != 0))
                throw new Exception("Т.к. используются одновременно разные системы счисления");

            int C = 0;
            int D = 0;
            if (A == 0 & B == 0) {
                C = parseInt(part1);                                                                // переводим 1 строчную арабскую цифру в int число
                D = parseInt(part2);
            }                                                                                       // переводим 2 строчную арабскую цифру в int число

            // ----------------------------Блок вывода итоговых значений------------------------------//

            //-----Сумма-----//
            if (value.indexOf("+") > 0) {
                if (A != 0 & B != 0) {
                    int E = metodsumm(A, B);
                    System.out.println(convert(E));
                } else {
                    System.out.println(metodsumm(C, D));
                }
            }

            //-------Разность-------//
            if (value.indexOf("-") > 0) {
                if (A != 0 & B != 0) {
                    int E = metoddiff(A, B);
                    System.out.println(convert(E));
                } else {
                    System.out.println(metoddiff(C, D));
                }
            }

            //---------Умножение--------//
            if (value.indexOf("*") > 0) {
                if (A != 0 & B != 0) {
                    int E = metodmult(A, B);
                    System.out.println(convert(E));
                } else {
                    System.out.println(metodmult(C, D));
                }
            }

            //---------Деление----------//
            if (value.indexOf("/") > 0) {
                if (A != 0 & B != 0) {
                    int E = metoddivid(A, B);
                    System.out.println(convert(E));
                } else {
                    int E = metoddivid(C, D);
                    if (E!=0)
                    System.out.println(E);
                    else {
                        System.out.println("Введите другие данные");
                    }
                }
            }

        }
    }


    // -------------------Блок перевода римских в цифр в арабские-----------------------//

    public static int toArabic(String value) { // метод переводит римские цифры в арабские
        if (value.equals("I")) return 1;
        if (value.equals("II")) return 2;
        if (value.equals("III")) return 3;
        if (value.equals("IV")) return 4;
        if (value.equals("V")) return 5;
        if (value.equals("VI")) return 6;
        if (value.equals("VII")) return 7;
        if (value.equals("VIII")) return 8;
        if (value.equals("IX")) return 9;
        if (value.equals("X")) return 10;
        return 0;
    }


    // -----------------Блок математических вычислений-------------------//

    public static int metodsumm(int number1, int number2) {
        int number3 = number1 + number2;
        return number3;
    }

    public static int metoddiff(int number1, int number2) {
        int number3 = number1 - number2;
        return number3;
    }

    public static int metodmult(int number1, int number2) {
        int number3 = number1 * number2;
        return number3;
    }

    public static int metoddivid(int number1, int number2) {
        int number3 = 0;
        try {number3 = number1 / number2;
        } catch (Exception e) {
                    System.out.println("На ноль делить нельзя    " + e);
                }
            return number3;
        }


        //------------------Блок перевода арвбских цифр в римские-------------------//

        public static String romanDigit ( int n, String one, String five, String ten){

            if (n >= 1) {
                if (n == 1) {
                    return one;
                } else if (n == 2) {
                    return one + one;
                } else if (n == 3) {
                    return one + one + one;
                } else if (n == 4) {
                    return one + five;
                } else if (n == 5) {
                    return five;
                } else if (n == 6) {
                    return five + one;
                } else if (n == 7) {
                    return five + one + one;
                } else if (n == 8) {
                    return five + one + one + one;
                } else if (n == 9) {
                    return one + ten;
                }

            }
            return "";
        }

        public static String convert ( int number) throws Exception {
            if (number <= 0) {
                throw new Exception("Т.к. в римской системе нет отрицательных чисел и ноля");
            }

            String romanOnes = romanDigit(number % 10, "I", "V", "X");
            number /= 10;
            //System.out.println("romanOnes=" + romanOnes +"       "+ "number%10=" + number%10);
            String romanTens = romanDigit(number % 10, "X", "L", "C");
            number /= 10;
            //System.out.println("romanTens=" + romanTens);
            String romanHundreds = romanDigit(number % 10, "C", "D", "M");
            number /= 10;
            //System.out.println("romanHundreds=" + romanHundreds);
            String romanThousands = romanDigit(number % 10, "M", "", "");
            // number /= 10;
            // System.out.println("romanThousands=" + romanThousands);
            String result = romanThousands + romanHundreds + romanTens + romanOnes;
            return result;
        }

    }
