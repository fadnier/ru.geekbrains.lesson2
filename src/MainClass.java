import java.util.Random;

public class MainClass {
    public static void main(String[] args) {

        //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < array.length; i++) {
            if(array[i]==1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println("Задание 1");
        printIntArr(array);
        System.out.println();

        //    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] array2 = new int[8];
        for (int i = 0,j = 0; i < array2.length; i++, j+=3) {
            array2[i] = j;
        }
        System.out.println("Задание 2");
        printIntArr(array2);
        System.out.println();

        //    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] array3 = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array3.length; i++) {
            if(array3[i] < 6) array3[i] *= 2;
        }
        System.out.println("Задание 3");
        printIntArr(array3);
        System.out.println();

        //    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] array4 = new int[5][5];
        for (int i = 0, j=0, a=array4.length-1; i < array4.length; i++,j++,a--) {
            array4[i][j] = 1;
            array4[a][j] = 1;
        }
        System.out.println("Задание 4");
        printIntArr(array4);
        System.out.println();

        //    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] array5 = getIntArr(10,100);
        int array5_max = array5[0];
        int array5_min = array5[0];
        for (int i = 0; i < array5.length; i++) {
            if(array5[i]>array5_max) array5_max = array5[i];
            if(array5[i]<array5_min) array5_min = array5[i];
        }
        System.out.println("Задание 5");
        printIntArr(array5);
        System.out.printf("Максимальный элемент - %s, минимальный элемент - %s \n",array5_max,array5_min);
        System.out.println();

        //    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        //    если в массиве есть место, в котором сумма левой и правой части массива равны.
        //    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        //    граница показана символами ||, эти символы в массив не входят.
        int[] array6 = getIntArr(10,10);
        System.out.println("Задание 6");
        printIntArr(array6);
        System.out.println(checkBalance(array6));
        System.out.println();

        //    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        //    при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[] array7 = new int[] {1,2,3,4,5,6,7,8,9,0};
        System.out.println("Задание 7");
        printIntArr(array7);
        array7 = arrayOffset(array7,-2);
        printIntArr(array7);
        System.out.println();
    }

    public static int[] arrayOffset(int[] a, int b) {
        //сохраняем кол-во оборотов
        int countOffset = b;
        //если значение отрицательное то приводим к положительному числу
        if(b < 0) countOffset=-b;
        //повторяем цикл в зависимости от того на сколько нам нужно сместить
        for (int j = 0; j < countOffset; j++) {
            //Переменая в которой хранится значение на которое будем менять
            int val1;
            //Переменая в которой будем сохранять предыдущее значение
            int val2;
            //смотрим в какую сторону крутить
            if(b < 0) {
                val1=a[0];
                for (int i = 0; i < a.length; i++) {
                    int position = i+1;
                    if(position >= a.length) position = 0; //если подошли к концу масива, переводим на начало
                    val2 = a[position];
                    a[position] = val1;
                    val1 = val2;
                }
            } else {
                val1=a[a.length-1];
                for (int i = a.length-1; i >= 0; i--) {
                    int position = i-1;
                    if(position < 0) position = a.length-1; //если подошли к началу масива, переводим на конец
                    val2 = a[position];
                    a[position] = val1;
                    val1 = val2;
                }
            }
        }
        return a;
    }

    public static boolean checkBalance(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if(a[i]==a[i-1]) return true;
        }
        return false;
    }


    public static void printIntArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void printIntArr(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] getIntArr(int n, int max) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }


}
