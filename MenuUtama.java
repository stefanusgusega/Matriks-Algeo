import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
class MenuUtama {
    public static void main (String[] args) {
        boolean exit,back;
        int i,j,k;
        Scanner input = new Scanner(System.in);
        exit = false;
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
<<<<<<< HEAD
                
=======
                back = false;
>>>>>>> c7c5edba0a022d224436a2cff3d1b326e4f8c958
                while (back == false) {
                    i = input.nextInt();
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
<<<<<<< HEAD
                        i = input.nextInt();
                        clearScreen();
                        switch (i) 
                        {
                            case 1 :
                            System.out.println("1. Masukkan dari file");
                            System.out.println("2. Masukkan dari user");
                            i = input.nextInt();
                            clearScreen();
                            switch (i)
                            {
                                case 1 :

                                break;
                                case 2 :

                                break;
                            }
                            break;
                            case 2 :
                            System.out.println("1. Masukkan dari file");
                            System.out.println("2. Masukkan dari user");
                            break;
                            case 3 :

                        }

                
=======
                        j = input.nextInt();
                        while (j<1 || j>5) {
                            System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                            j = input.nextInt();
                        }
                        switch (j) {
                            case 1:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                break;
                                case 2:
                                int brs,kol;
                                matriks M = new matriks ()
                                System.out.println("Baris :");
                                brs = input.nextInt();
                                System.out.println("Kolom :");
                                kol = input.nextInt();
                                
                                break;
                            }
                            break;
                            case 2:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 3:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 4:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan dari user");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch (k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 5:
                            back = true;
                            break;
                            }
>>>>>>> c7c5edba0a022d224436a2cff3d1b326e4f8c958
                        break;
                        case 2:
                        System.out.println("1. Metode eliminasi Gauss");
                        System.out.println("2. Metode eliminasi Gauss-Jordan");
                        System.out.println("3. Metode matriks balikan");
                        System.out.println("4. Kaidah Cramer");
                        System.out.println("5. Kembali ke menu sebelumnya");
                        j = input.nextInt();
                        while (j<1 || j>5) {
                            System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                            j = input.nextInt();
                        }
                        switch (j) {
                            case 1:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 2:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 3:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 4:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 5:
                            back = true;
                            break;
                        }
                        break;
                        case 3:
                        System.out.println("1. Metode eliminasi Gauss");
                        System.out.println("2. Metode eliminasi Gauss-Jordan");
                        System.out.println("3. Metode matriks balikan");
                        System.out.println("4. Kaidah Cramer");
                        System.out.println("5. Kembali ke menu sebelumnya");
                        j = input.nextInt();
                        while (j<1 || j>5) {
                            System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                            j = input.nextInt();
                        }
                        switch (j) {
                            case 1:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 2:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 3:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 4:
                            System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                            break;
                            case 5:
                            back = true;
                            break;
                        }
                        break;
                        case 4:
                        System.out.println("1. Masukan dari file");
                        System.out.println("2. Masukan pengguna");
                        k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                        break;
                        case 5:
                        System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                        break;
                        case 6:
                        System.out.println("1. Masukan dari file");
                            System.out.println("2. Masukan pengguna");
                            k = input.nextInt();
                            while (k<1 || k>2) {
                                System.out.println("Pilihan menu tidak ada! Masukkan lagi!");
                                k = input.nextInt();
                            }
                            switch(k) {
                                case 1:
                                break;
                                case 2:
                                break;
                            }
                        break;
                        case 7:
                        exit = true;
                        back = true;
                        break;
                        }
                    }
                }
            }
            
        }
<<<<<<< HEAD
    
    }
=======
>>>>>>> c7c5edba0a022d224436a2cff3d1b326e4f8c958

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
