import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
class MenuUtama {
    public static void main (String[] args) {
        boolean exit,back;
        exit = false;
        back = false;
        Scanner input = new Scanner(System.in);
        while (exit == false) {
                clearScreen();
                System.out.println("MENU");
                System.out.println("1. Sistem Persamaan Linier");
                System.out.println("2. Determinan");
                System.out.println("3. Matriks balikan");
                System.out.println("4. Matriks kofaktor");
                System.out.println("5. Adjoin");
                System.out.println("6. Interpolasi Polinom");
                System.out.println("7. Keluar");
                while (back == false) {
                    int i = input.nextInt();
                    while (i<1 || i>7) {
                        System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                        i = input.nextInt();
                    clearScreen();
                    switch (i) {
                        case 1:
                        System.out.println("1. Metode eliminasi Gauss");
                        System.out.println("2. Metode eliminasi Gauss-Jordan");
                        System.out.println("3. Metode matriks balikan");
                        System.out.println("4. Kaidah Cramer");
                        System.out.println("5. Kembali ke menu sebelumnya");
                        break;
                        case 2:
                        System.out.println("1. Metode eliminasi Gauss");
                        System.out.println("2. Metode eliminasi Gauss-Jordan");
                        System.out.println("3. Metode matriks balikan");
                        System.out.println("4. Kaidah Cramer");
                        System.out.println("5. Kembali ke menu sebelumnya");
                        break;
                        case 3:
                        System.out.println("1. Metode eliminasi Gauss");
                        System.out.println("2. Metode eliminasi Gauss-Jordan");
                        System.out.println("3. Metode matriks balikan");
                        System.out.println("4. Kaidah Cramer");
                        System.out.println("5. Kembali ke menu sebelumnya");
                        break;
                        case 4:
                        break;
                        case 5:
                        break;
                        case 6:
                        break;
                        case 7:
                        exit = true;
                        break;
                    }
                }
            }
        }
    }

    public final static void clearScreen()
{
    try
    {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
    catch (Exception E)
    {
        System.out.println(E);
        //  Handle any exceptions.
    }
}
    /*public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();

    }*/
}