package lesson2;

import java.util.ArrayList;
import java.util.List;

public class HomeWork2 {
    /**
     * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
     * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
     * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
     * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
     * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     * 3 В методе main() вызвать полученный метод, обработать возможные исключения
     * MyArraySizeException и MyArrayDataException и вывести результат расчета.
     */
    public static void main(String[]args) {
        String [][] normal = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"},
        };
        String [][] wrongData = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","x"},
        };
        List<String[][]> inputs = new ArrayList<>(List.of(normal, wrongData));
        for (String [][] input : inputs) {
            try {
                System.out.printf("Sum of array element = %s\n", sumArrayElements(input));
            } catch (MyArraySizeException e) {
                System.out.println("Wrong input array size. It must be 4*4");
            } catch (MyArrayDataException e) {
                System.out.printf("Can't parse element of input array, check the date at %d x %d", e.i, e.j);
            }
        }
    }
    public static int sumArrayElements(final String [][] inputArr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (inputArr.length != 4) {
            throw new MyArraySizeException ("input array size must be 4*4");
        }
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j< inputArr.length; j++) {
                try {
                    sum += Integer.parseInt(inputArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j, "can't parse element of input array");
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new MyArraySizeException("input array size must be 4*4");
                }
            }
        }
        return sum;
    }
}
