package ru.geekbrains;

import java.util.Arrays;
import static java.lang.Math.abs;

    public class Lesson2  {

        public static void main(String[] args) {
            task01(randomArray(8, 0 , 1));
            task02(8);
            task03();
            task04(5);
            task05(randomArray(15, 0 , 100));
            task06(randomArray(10, 1 , 4));
            task07(randomArray(10, 1 , 20), 38);
        }

        /**
         * Создает случайное значение между min и max
         */
        public static int random(int min, int max) {
            return (int) (Math.random() * (max - min + 1)) + min;
        }

        /**
         * Создает массив со случайными значениями и
         * желаемый размер массива.
         * минимальное случайное значение
         * максимальное случайное значение
         * и возвращает сгенерированный массив
         */
        public static int[] randomArray(int arraySize, int min, int max) {
            int[] array = new int[arraySize];
            for (int i = 0; i < array.length; i++) {
                array[i] = random(min, max);
            }
            return array;
        }

        /**
         * Задать целочисленный массив, состоящий из элементов 0 и 1.
         * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
         * С помощью цикла и условия заменить 0 на 1, 1 на 0
         */
        public static void task01(int[] array) {
            int[] modifiedArray = new int[array.length];
            System.out.println("Task 01:");
            System.out.println(Arrays.toString(array));
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    modifiedArray[i] = 1;
                } else {
                    modifiedArray[i] = 0;
                }
            }
            System.out.println(Arrays.toString(modifiedArray));
        }

        /**
         * Задать пустой целочисленный массив размером 8.
         * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        public static void task02(int arraySize) {
            int[] array = new int[arraySize];
            int initialValue = 0;
            for (int i = 0; i < array.length; i++) {
                array[i] = initialValue;
                initialValue += 3;
            }
            System.out.println("\nTask 02:");
            System.out.println(Arrays.toString(array));
        }

        /**
         * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
         * пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        public static void task03() {
            int[] initialArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            int[] modifiedArray = new int[initialArray.length];
            for(int i = 0; i < initialArray.length; i++) {
                if (initialArray[i] < 6) {
                    modifiedArray[i] = initialArray[i] * 2;
                } else {
                    modifiedArray[i] = initialArray[i];
                }
            }
            System.out.println("\nTask 03:");
            System.out.println(Arrays.toString(initialArray));
            System.out.println(Arrays.toString(modifiedArray));
        }

        /**
         * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        public static void task04(int arraySize) {
            int[][] array = new int[arraySize][arraySize];
            System.out.println("\nTask 04:");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (i == j || i + j == array.length - 1) {
                        array[i][j] = 1;
                    }
                    System.out.print(array[i][j] + "\t");
                }
                System.out.println();
            }
        }

        /**
         * Задать одномерный массив и найти в нем минимальный и максимальный элементы
         */
        public static void task05(int[] array) {
            int minValue = array[0];
            int maxValue = array[0];
            System.out.println("\nTask 05:");
            System.out.println(Arrays.toString(array));
            for (int i = 1; i < array.length; i++) {
                if (array[i] < minValue) {
                    minValue = array[i];
                }
                if (array[i] > maxValue) {
                    maxValue = array[i];
                }
            }
            System.out.println("Min: " + minValue);
            System.out.println("Max: " + maxValue);
        }

        /**
         * Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
         * если в массиве есть место, в котором сумма левой и правой части массива равны.
         * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
         * checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят
         */
        public static boolean task06(int[] array) {
            int sumLeft = 0;
            int sumRight = 0;
            System.out.println("\nTask 06:");
            System.out.println(Arrays.toString(array));
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j <= i; j++) {
                    sumLeft += array[j];
                }
                for (int k = i + 1; k < array.length; k++) {
                    sumRight += array[k];
                }
                if (sumLeft == sumRight) {
                    System.out.println(sumLeft + " = " + sumRight);
                    System.out.println("Левая часть массива равна правой части");
                    return true;
                } else {
                    sumLeft = 0;
                    sumRight = 0;
                }
            }
            System.out.println("Левая часть массива не равна правой части");
            return false;
        }

        /**
         * Написать метод, которому на вход подается одномерный массив
         * и число n (может быть положительным, или отрицательным), при этом метод должен сместить
         * все элементы массива на n позиций. Элементы смещаются циклично.
         * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
         * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
         * при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
         * При каком n в какую сторону сдвиг можете выбирать сами.
         */
        public static void task07(int[] array, int n) {
            int[] modifiedArray = new int[array.length];

            int newIndex;
            if (n < 0) {
                newIndex = abs(n) % array.length;
            } else if (n % array.length == 0) {
                newIndex = 0;
            } else {
                newIndex = array.length - n % array.length;
            }

            for (int i = 0; i < array.length; i++) {
                modifiedArray[i] = array[newIndex];
                newIndex = (newIndex + 1) % array.length;
            }
            System.out.println("\nTask 07:");
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(modifiedArray) + " вращение с шагом " + n);
        }


    }

