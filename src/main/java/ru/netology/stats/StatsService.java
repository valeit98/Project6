package ru.netology.stats;

public class StatsService {

    public int TotalSales(int[] sales) {
        int sum = 0;
        for (int value : sales) {
            sum += value;
        }
        return sum;
    }

    public double AverageSales(int[] sales) {
        return (double) TotalSales(sales) / sales.length;
    }

    public int maxSales(int[] sales) {
        int maxMonth = 0;//номер месяца с максимальными продажами среди просмотренных ранее
        for (int i = 0; i < 12; i++) {
            if (sales[i] >= sales[maxMonth]) {//в рассматриваемом i-м месяце продаж больше
                maxMonth = i;//запомним его как максимальный
            }
        }
        return maxMonth + 1;//месяца нумеруются с 1, а индексы массива с 0, поэтому нужно сдвинуть на 1
    }

    public int minSales(int[] sales) {
        int minMonth = 0;//номер месяца с минимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) {//значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i;//запомним его как минимальный
            }
        }
        return minMonth + 1;//месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    public int salesLessAverage(int[] sales) {
        int numberOfMonth = 0;
        double averageSales = AverageSales(sales);
        for (int i = 0; i < 12; i++) {
            if (sales[i] < averageSales) {
                numberOfMonth = numberOfMonth + 1;
            }
        }
        return numberOfMonth;
    }

    public int salesMoreAverage(int[] sales) {
        int numberOfMonth = 0;
        double averageSales = AverageSales(sales);
        for (int i = 0; i < 12; i++) {
            if (sales[i] > averageSales) {
                numberOfMonth = numberOfMonth + 1;
            }
        }
        return numberOfMonth;
    }
}