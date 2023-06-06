// 12S22038 - Ade Yohana Azeka Siahaan
// 12S22012 - Reinhard Batubara
import java.util.*;
import java.lang.Math;

public class T04 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String isbn;
        double harga;
        int eksemplar;
        boolean exist;
        boolean indexFound;
        int y;
        double harga1;
        int nBuku;
        
        nBuku = 3;
        String[] arrayIsbn = new String[nBuku];
        double[] arrayharga = new double[nBuku];
        int[] arrayeksemplar = new int[nBuku];
        int x;
        
        for (x = 0; x <= nBuku - 1; x++) {
            arrayIsbn[x] = "0";
            arrayharga[x] = 0.0;
            arrayeksemplar[x] = 0;
        }
        double totalharga;
        
        totalharga = 0;
        boolean var_continue;
        
        var_continue = true;
        while (var_continue) {
            isbn = input.nextLine();
            if (!isbn.equals("---")) {
                harga = Double.parseDouble(input.nextLine());
                eksemplar = Integer.parseInt(input.nextLine());
                exist = false;
                x = 0;
                do {
                    if (arrayIsbn[x].equals(isbn)) {
                        arrayeksemplar[x] = arrayeksemplar[x] + eksemplar;
                        exist = true;
                    } else {
                        x = x + 1;
                    }
                } while (!exist && x < nBuku);
                if (!exist) {
                    indexFound = false;
                    y = 0;
                    do {
                        if (arrayeksemplar[y] == 0) {
                            indexFound = true;
                        } else {
                            y = y + 1;
                        }
                    } while (!indexFound && y < nBuku);
                    arrayIsbn[y] = isbn;
                    arrayharga[y] = harga;
                    arrayeksemplar[y] = eksemplar;
                    y = y + 1;
                }
            } else {
                var_continue = false;
            }
        }
        for (x = 0; x <= nBuku - 1; x++) {
            harga1 = arrayharga[x];
            if (arrayeksemplar[x] >= 20) {
                harga1 = arrayharga[x] - arrayharga[x] * 0.12;
            } else {
                if (arrayeksemplar[x] >= 10) {
                    harga1 = arrayharga[x] - arrayharga[x] * 0.05;
                } else {
                    if (arrayeksemplar[x] >= 5) {
                        harga1 = arrayharga[x] - arrayharga[x] * 0.02;
                    }
                }
            }
            totalharga = totalharga + harga1 * arrayeksemplar[x];
        }
        System.out.println(toFixed(totalharga,2));
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}
