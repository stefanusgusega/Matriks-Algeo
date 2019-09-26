import java.util.Scanner;

class MenuUtama {
        public static void clearScreen() 
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


    public static void main (String[] args)
    {
        boolean exit,back;
        back =false;
        exit = false;
        Scanner input = new Scanner(System.in);
        while (exit == false) 
        {
        clearScreen();
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Matriks kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi Polinom");
        System.out.println("7. Keluar");
        int i = input.nextInt();
        while (i<1 || i>7) {
                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                i = input.nextInt();
        }
        clearScreen();
        switch (i) {
            case 1:
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Metode matriks balikan");
            System.out.println("4. Kaidah Cramer");
            System.out.println("5. Kembali ke menu sebelumnya");
            int j = input.nextInt();
            while (j<1 || j>5) {
                    System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
            }
            clearScreen();
            switch(j) {
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5 : keluar = true;
                break;
            }
            break;
            case 2:
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Metode matriks balikan");
            System.out.println("4. Kaidah Cramer");
            int k = input.nextInt();
            clearScreen();
            switch(k) {
                case 1:
                System.out.println("1. Masukkan dari file");
                System.out.println("2. Masukkan manual");
                int l = input.nextInt();
                switch (l) {
                        case 1:
                        break;
                        case 2:
                        break;
                }
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
            }
            break;
            case 3:
            System.out.println("1. Metode eliminasi Gauss");
            System.out.println("2. Metode eliminasi Gauss-Jordan");
            System.out.println("3. Metode matriks balikan");
            System.out.println("4. Kaidah Cramer");
            int l = input.nextInt();
            clearScreen();
            switch(l) {
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
            }
            break;
            case 4:
            break;
            case 5:
            break;
            case 6:
            break;
            case 7:
            // keluar program //
            exit = true;
            break;
        }
        }
        input.close();
    }