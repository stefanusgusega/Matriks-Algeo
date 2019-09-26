import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class matriks
{
        Scanner sc = new Scanner(System.in); 
        
        public int NBrsEff;
        public int NKolEff;
        float[][]mem= new float[50][50];

        public static final int barmax = 50;
        public static final int kolmax = 50;

        void MakeMATRIKS (int NB, int NK)
        /* Membentuk sebuah MATRIKS "kosong" yang siap diisi berukuran NB x NK di "ujung kiri" memori */
        /* I.S. NB dan NK adalah valid untuk memori matriks yang dibuat */
        /* F.S. Matriks M sesuai dengan definisi di atas terbentuk */
        {
        this.NBrsEff= NB;
        this.NKolEff = NK;
        }


        boolean IsIdxValid (int i, int j)
        /* Mengirimkan true jika i, j adalah indeks yang valid untuk matriks apa pun */
        {
        return ((i>=1 && i<=barmax)&&(j>=1 && j<=kolmax));
        }

       
        boolean IsIdxEff (int i, int j)
        /* Mengirimkan true jika i, j adalah indeks efektif bagi M */
        {
        return ((i>=1)&&(i<=NBrsEff)&&(j>=1)&&(j<=NKolEff));
        }
      

        void BacaMATRIKS (int NB, int NK)
        /* I.S. IsIdxValid(NB,NK) */
        /* F.S. M terdefinisi nilai elemen efektifnya, berukuran NB x NK */
        /* Proses: Melakukan MakeMATRIKS(M,NB,NK) dan mengisi nilai efektifnya */
        /* Selanjutnya membaca nilai elemen per baris dan kolom */
        /* Contoh: Jika NB = 3 dan NK = 3, maka contoh cara membaca isi matriks :
        1 2 3
        4 5 6
        8 9 10
        */
        {
        MakeMATRIKS(NB,NK);
        int i,j;
        for (i=1;i<=NBrsEff;i++)
        {
                for (j=1;j<=NKolEff;j++)
                {
                mem[i][j]=sc.nextFloat();
                }
        }
        
        }

        void BacaMATRIKSAug (int NBAug, int NKAug)
        /* I.S. IsIdxValid(NB,NK) */
        /* F.S. M terdefinisi nilai elemen efektifnya, berukuran NB x NK */
        /* Proses: Melakukan MakeMATRIKS(M,NB,NK) dan mengisi nilai efektifnya */
        /* Selanjutnya membaca nilai elemen per baris dan kolom */
        /* Contoh: Jika NB = 3 dan NK = 3, maka contoh cara membaca isi matriks :
        1 2 3
        4 5 6
        8 9 10
        */
        {
        MakeMATRIKS(NBAug,NKAug-1);
        int i,j;
        for (i=1;i<=NBAug;i++)
        {
                for (j=1;j<=NKAug;j++)
                {
                mem[i][j]=sc.nextFloat();
                }
        }
        
        }

        void TulisMATRIKS() {
                MakeMATRIKS(NBrsEff,NKolEff);
		System.out.println("\nMatriksnya adalah :");
		for(int i=1; i <=NBrsEff; i++) {
			for(int j=1; j <=NKolEff; j++) {
                                if (mem[i][j]==-0)
                                {
                                        mem[i][j]=mem[i][j]+0;
                                }
				System.out.print("\t" + mem[i][j]);
			}
			System.out.println();
		}
        }
        
        void TulisMATRIKSAug() {
		System.out.println("\nMatriksnya adalah :");
		for(int i=1; i <=NBrsEff; i++) {
			for(int j=1; j <=NKolEff+1; j++) {
                                if (mem[i][j]==-0)
                                {
                                        mem[i][j]=mem[i][j]+0;
                                }
				System.out.print("\t" + mem[i][j]);
			}
			System.out.println();
		}
        }

        boolean AdaBukanSolSPL (matriks m)
        {
                int i;
                for (i=m.NBrsEff;i>=1;i--)
                {
                        if ((IsKirinya0semua (m, i, m.NKolEff+1))&&m.mem[i][m.NKolEff+1]!=0)
                        {
                                return true;
                        }
                }
                return false;
        }
        int IdxBrsSebelum0semua(matriks m)
        {
                int i,j;
                for (i=m.NBrsEff;i>=1;i--)
                {
                        for (j=1;j<=m.NKolEff+1;j++)
                        {
                                if (m.mem[i][j]!=0)
                                {
                                        return i;
                                }
                        }
                }
                System.out.println("MATRIKS KOSONG!!!\n");
                return i;

        }


        void SolSPLAkhir(matriks m)
        {
                int i,j,w,ha;
                ha=0;
                w=1;
                matriks koef = new matriks();
                char[] alph = new char[]{'w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
                koef.MakeMATRIKS(m.NBrsEff,m.NKolEff);
                int a= IdxBrsSebelum0semua(m);
                if (AdaBukanSolSPL(m))
                {
                        System.out.println("Tidak ada solusi SPL\n");
                }
                else {
                for (i=a-1; i>=1; i--)
                {   
                        for (j=m.NKolEff;j>=1;j--)
                        {
                                if ((m.mem[IdXPalingBawah(m,j)][j]==1)&&(!(IsSatuUtama(m,i,j)))&&(i<IdXPalingBawah(m,j)))
                                {
                                        DiRekursifin(m,i,j);
                                }
                        }
                }

                int k;
                k=1;
                float simp;
                String str1,str2;
                for (j=m.NKolEff;j>=1;j--)
                {
                        ha=1;
                        if (IsSatuUtama(m,IdXPalingBawah(m,j),j))
                        {
                                System.out.print("x"+j+" = ");
                                
                                if (((j+1)!=m.NKolEff+1) && (m.mem[IdXPalingBawah(m,j)][j+1]!=0))
                                {        simp = m.mem[IdXPalingBawah(m,j)][j+1]*(-1);
                                        str1=String.valueOf(simp);
                                        str2 = String.valueOf(alph[j+1]);
                                        System.out.print(str1+str2);
                                        ha++;
                                }
                                else if(((j+1)==m.NKolEff+1) && (m.mem[IdXPalingBawah(m,j)][j+1]!=0))
                                {
                                        simp = m.mem[IdXPalingBawah(m,j)][j+1];
                                        str1=String.valueOf(simp);
                                        System.out.print(str1);
                                        ha++;
                                }
                                        
                                k=j+2;
                                while (k<=m.NKolEff+1)
                                {
                                        
                                        
                                        if((m.mem[IdXPalingBawah(m,j)][k]*(-1))>0)
                                        {
                                                if ((k)!=m.NKolEff+1) 
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k]*(-1);
                                                        str1=String.valueOf(simp);
                                                        str2 = String.valueOf(alph[k]);
                                                        if (ha!=1)
                                                        {
                                                                System.out.print("+"+str1+str2);
                                                                ha++;
                                                        }
                                                        else
                                                        {
                                                                System.out.print(str1+str2);
                                                                ha++;
                                                        }
                                                        
                                                }
                                                else
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k];
                                                        str1=String.valueOf(simp);
                                                        if (m.mem[IdXPalingBawah(m,j)][k]>0)
                                                        {
                                                                if (ha!=1)
                                                                {
                                                                        System.out.print("+"+str1);
                                                                        ha++;
                                                                }
                                                                else
                                                                {
                                                                        System.out.print(str1);
                                                                        ha++;
                                                                }
                                                        }
                                                        else
                                                        {
                                                                System.out.print(str1);
                                                        }
                                                }
                                        }
                                        else if((m.mem[IdXPalingBawah(m,j)][k]*(-1))<0)
                                        {
                                                if ((k)!=m.NKolEff+1) 
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k]*(-1);
                                                        str1=String.valueOf(simp);
                                                        str2 = String.valueOf(alph[k]);
                        
                                                        System.out.print(str1+str2);
                                                        ha++;
                                                }
                                                else
                                                {
                                                        simp = m.mem[IdXPalingBawah(m,j)][k];
                                                        str1=String.valueOf(simp);
                                                        if (m.mem[IdXPalingBawah(m,j)][k]>0)
                                                        {
                                                                if (ha!=1)
                                                                {
                                                                        System.out.print("+"+str1);
                                                                        ha++;
                                                                }
                                                                else
                                                                {
                                                                        System.out.print(str1);
                                                                        ha++;
                                                                }
                                                        }
                                                        else
                                                        {
                                                                System.out.print(str1);
                                                                ha++;
                                                        }
                                                }
                                        }
                                        else
                                        {
                                                simp = m.mem[IdXPalingBawah(m,j)][k];
                                                str1=String.valueOf(simp);
                                                if (m.mem[IdXPalingBawah(m,j)][k]==0)
                                                {
                                                        if (ha==1)
                                                        {
                                                                System.out.print(0);
                                                                ha++;
                                                        }
                                                        
                                                }
                                        }
                                                
                                        
                                k++;
                                 
                                }
                                
                                
                                System.out.println();
                        }
                        else if ((!IsSatuUtama(m,IdXPalingBawah(m,j),j)))
                        {

                                System.out.print("x"+j+" = "+alph[j]);
                                System.out.println();
                        }

                        m.TulisMATRIKSAug();
                }
                
        }
        }
        void DiRekursifin (matriks m, int acbar, int ackol)
        {
                int i,j;
                float ac;
                ac=m.mem[acbar][ackol];
                i=IdXPalingBawah(m,ackol);
                if (acbar!=m.NBrsEff)
                {
                        for (j=ackol+1;j<=m.NKolEff+1;j++)
                        {
                                m.mem[acbar][j]=m.mem[acbar][j]-(m.mem[i][j]*ac);
                        }
                        m.mem[acbar][ackol]=0;
                }
        }

   

        int IdXPalingBawah (matriks m, int kol)
        {
                int i;
                for (i=1;i<=m.NBrsEff;i++)
                {
                        if ((m.mem[i][kol]==0)&&(IsBawahnya0semua(m,i,kol))&&(IsKirinya0semua(m,i,kol)))
                        {
                                return i-1;
                        }
                }
                return i-1;
        }
        boolean IsSatuUtama (matriks m, int bar, int kol)
        {
                return ((m.mem[bar][kol]==1)&&(IsBawahnya0semua(m,bar,kol)&&IsKirinya0semua(m,bar,kol)));
        }

        boolean IsBawahnya0semua(matriks m, int bar, int kol)
        {
                int i;
                if (bar!=m.NBrsEff)
                {
                        for (i=bar+1;i<=m.NBrsEff;i++)
                        {
                                if (m.mem[i][kol]!=0)
                                {
                                        return false;
                                }
                        }
                        return true;
                }
                else
                {
                        return true;
                }
        }

        boolean IsKirinya0semua (matriks m, int bar, int kol)
        {
                int j;
                if (kol!=1)
                {
                        for (j=1;j<kol;j++)
                        {
                                if (m.mem[bar][j]!=0)
                                {
                                        return false;
                                }
                        }
                        return true;
                }
                else
                {
                        return true;
                }
        }
 
        int SumIdxFoundNonZero (int acbar)
        {
                
                int j;
                int sum;
                sum=0;
                for (j=1;j<=NKolEff;j++)
                {
                        if (mem[acbar][j]!=0)
                        {
                                sum=sum+1;
                        }
                }
                return sum;
                
        }

        boolean IsFound1Kolom (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan true jika ditemukannya angka 1 di kol acuan */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==1)
                        {
                                return true;
                        }
                }
                return false;
        }

        int IdxKolom1 (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan indeks baris pertama kali ditemukannya angka 1 di kol acuan, jika tidak ketemu kembaliaannya 0 */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==1)
                        {
                                return i;
                        }
                }
                return 0;
        }

        boolean IsFound0Kolom (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan true jika  ditemukannya angka 0 di kol acuan */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==0)
                        {
                                return true;
                        }
                }
                return false;
        }

        int IdxKolom0 (int acbar,int ackol)
        /* I.S Kolom Valid*/
        /* F.S Menghasilkan indeks baris pertama kali ditemukannya angka 0 di kol acuan, jika tidak ketemu kembaliaannya 0 */
        {
                int i;
                for (i=acbar;i<=NBrsEff;i++)
                {
                        if (mem[i][ackol]==0)
                        {
                                return i;
                        }
                }
                return 0;
        }

        void OBEtukar (int bartukar, int acbar)
        {
                int j;
                for (j=1;j<=NKolEff+1;j++)
                {
                        float temp;
                        temp=mem[(acbar)][(j)];
                        mem[(acbar)][(j)]=mem[(bartukar)][(j)];
                        mem[(bartukar)][(j)]=temp;
                }
        }

        void OBEkurang (int barkurang, int kolkurang, int acbar, int ackol)
        {
                int j;
                float ac;
                ac = (float)mem[(barkurang)][(kolkurang)]/mem[(acbar)][(ackol)];
    
                        for (j=1;j<=NKolEff+1;j++)
                        {
                        mem[(barkurang)][(j)]=mem[(barkurang)][(j)]-mem[(acbar)][(j)]*ac; 
                        }
                
        }

        void OBEUtama (int barkurang, int ackol)
        {
                int j,ac1,ac2;
                ac1=barkurang;
                ac2=ackol;
                float ac;
                ac=mem[ac1][ac2];
                for (j=1;j<=NKolEff+1;j++)
                {
                       mem[barkurang][j]=(float)mem[barkurang][j]/ac;
                }
        }

        void GaussSPL ()
        /* Berlaku matriks lebih dari 2*2 */
        {
                int i,j,k,w,utama;
                boolean keluar;
                k=0;
                keluar=false;
                for (j=1;j<=NKolEff;j++)
                {
                        if (IsIdxEff(k+1,j))
                        {
                                for (i=1+k;i<=NBrsEff;i++)
                                {
                                        utama=1+k;
                                        if (i==utama)
                                        //saat baris ke i mula2
                                        {
                                                keluar=false;
                                                w=0;
                                                if (IsFound1Kolom(utama,j))
                                                //Kalau dalam baris ke i terdapat 1 maka ditukar dengan baris ke 1+k
                                                {
                                                        OBEtukar(IdxKolom1(i+k,j),i+k);
                                                        
                                                }  
                                                
                                                else
                                                //saat tidak ada 1
                                                {
                                                        if (mem[utama][j]==0 )
                                                        //kalau di baris ke 1+k terdapat 0, maka ditukar sampai bukan 0
                                                        //kalau ternyata 0 semua, maka next langsung ke step berikutnya(tidk dilakukan aksi appun)
                                                        {
                                                                while ((mem[utama][j]==0 )&& (!(keluar)))
                                                                {
                                                                        w=w+1;
                                                                        if ((utama+w)!=NBrsEff)
                                                                        {
                                                                                keluar=true;
                                                                                
                                                                        }
                                                                        else
                                                                        {
                                                                                OBEtukar(utama+w,i+k);
                                                                                if(mem[i+k][j]==0)
                                                                                {
                                                                                        OBEtukar(utama+w,i+k);
                                                                                }
                                                                                else
                                                                                {
                                                                                        OBEUtama(utama,j);
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                        else
                                                        {

                                                                OBEUtama(utama,j);


                                                        }
                                                      
                                                 }

                                        }
                                        else
                                        //saat tidak mencari 1 utama
                                        {

                                                if ((mem[i][j]!=0 ))
                                                {
                                                        OBEkurang(i,j,utama,j);
                                                }
                                              
                                        }    
                                }
                        }

                        if (keluar==false)
                        {
                         k=k+1;
                        }
                        
                }

        }

        
        void GaussJordan ()
        /* Berlaku matriks lebih dari 2*2 */
        {
                int i,j,k,w,utama;
                boolean keluar;
                k=0;
                keluar=false;
                for (j=1;j<=NKolEff;j++)
                {
                        if (IsIdxEff(k+1,j))
                        {
                                utama=1+k;
                                for (i=1+k;i<=NBrsEff;i++)
                                {
                                        if (i==utama)
                                        //saat baris ke i mula2
                                        {
                                                keluar=false;
                                                w=0;
                                                if (IsFound1Kolom(utama,j))
                                                //Kalau dalam baris ke i terdapat 1 maka ditukar dengan baris ke 1+k
                                                {
                                                        OBEtukar(IdxKolom1(i+k,j),i+k);
                                                        
                                                }  
                                                
                                                else
                                                //saat tidak ada 1
                                                {
                                                        if (mem[utama][j]==0 )
                                                        //kalau di baris ke 1+k terdapat 0, maka ditukar sampai bukan 0
                                                        //kalau ternyata 0 semua, maka next langsung ke step berikutnya(tidk dilakukan aksi appun)
                                                        {
                                                                while ((mem[utama][j]==0 )&& (!(keluar)))
                                                                {
                                                                        w=w+1;
                                                                        if ((utama+w)!=NBrsEff)
                                                                        {
                                                                                keluar=true;
                                                                                
                                                                        }
                                                                        else
                                                                        {
                                                                                OBEtukar(utama+w,i+k);
                                                                                if(mem[i+k][j]==0)
                                                                                {
                                                                                        OBEtukar(utama+w,i+k);
                                                                                }
                                                                                else
                                                                                {
                                                                                        OBEUtama(utama,j);
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                        else
                                                        {

                                                                OBEUtama(utama,j);
                                                        }
                                                      
                                                 }

                                        }
                                        else
                                        //saat tidak mencari 1 utama
                                        {

                                                if ((mem[i][j]!=0 ))
                                                {
                                                        OBEkurang(i,j,utama,j);
                                                }
                                                                        
                                        }
                                }

                                if (IsFound1Kolom(utama,j))
                                {
                                        i=1;
                                        while (i<utama)
                                        {
                                                if ((mem[i][j]!=0 ))
                                                        {
                                                                OBEkurang(i,j,utama,j);
                                                        }  
                                                i=i+1;
                                        }
                                }   
                                
                        }

                        if (keluar==false)
                        {
                         k=k+1;
                        }
                        
                }

        }

        void CramerSPL(matriks M)
        //MATRIKS Harus SINGULAR (n x n)
        //Matriks Augmentednya harus ( n x n+1 )
        {
                
                int j,i;
                float det;
                float[] solSPL= new float[NKolEff+1];
                det= DeterminanKofaktor(M);
                System.out.println(det);
                for (j=1;j<=NKolEff;j++)
                {
                       for (i=1;i<=NBrsEff;i++)
                       {
                                float temp;
                                temp=M.mem[(i)][(j)];
                                M.mem[(i)][(j)]=M.mem[(i)][(NKolEff+1)];
                                M.mem[(i)][(NKolEff+1)]=temp;
                       }
                       M.TulisMATRIKSAug();
                        solSPL[j]=(float)DeterminanKofaktor(M)/det;
                        System.out.println(DeterminanKofaktor(M));
                        for (i=1;i<=NBrsEff;i++)
                       {
                                float temp;
                                temp=M.mem[(i)][(j)];
                                M.mem[(i)][(j)]=M.mem[(i)][(NKolEff+1)];
                                M.mem[(i)][(NKolEff+1)]=temp;
                       }
                       
                }
                
                System.out.println("Ini hasil SPL Cramer");
                for (j=1;j<=NKolEff;j++)
                {
                        System.out.println("x"+j+"= "+solSPL[j]);
                }

        }


        void InverseSPL (matriks a)
        //MASUKKAN MATRIKS AUGMENTED ((YANG SUDAH DIINVERS))) NAMUN NEFF+1 MASI BERISIKAN SOLUSI SPLNYA
        {
                if (a.NBrsEff!=a.NKolEff)
                {
                        System.out.println("Matriks augmented masukkan harus berisi n x n+1 ya ~~");
                }
                else if (DeterminanKofaktor(a)==0)
                {
                        System.out.println("Maaf ya.. Matriks augmented tidak ada solusi SPLnya karena ngga ada inversnya ~");
                }
                else{
                matriks M = InversMatriks(a);
                M.TulisMATRIKS();
                int i,j,k;
                float elmt;
                float [] solInvers = new float[NBrsEff+1];
                for (i=1;i<=NBrsEff;i++)
                {
                        j=NKolEff+1;
                        {
                        elmt=0;
                        for (k=1;k<=NKolEff;k++)
                        {
                                elmt=elmt+M.mem[i][k]*a.mem[k][j];
                        }
                        solInvers[i] = elmt;
                        }
                }
                
                System.out.println("Ini hasil SPL Invers");
                for (j=1;j<=NKolEff;j++)
                {
                        System.out.println("x"+j+"= "+solInvers[j]);
                }
        }
        }
        
        void Interpolasi ()
        {
                float input1, input2,x,sum;
                sum=0;
                System.out.println("Masukkan banyaknya titik : ");
                NKolEff=sc.nextInt();
                MakeMATRIKS(NKolEff,NKolEff);
                int i,j;
                for (i=1;i<=NBrsEff;i++)
                {
                        input1 = sc.nextFloat();
                        for (j=1;j<=NKolEff;j++)
                        {
                                mem[i][j]=(float)Math.pow(input1,j-1);
                        }
                        input2 = sc.nextFloat();
                        mem[i][NKolEff+1]=input2;
                       
                }
                TulisMATRIKSAug();
                GaussJordan();
                System.out.println("Masukkan x : ");
                x=sc.nextFloat();

                for(i=1;i<=NBrsEff;i++)
                {
                        sum=sum+mem[i][NKolEff+1]*(float)Math.pow(x,i-1);
                }
                System.out.println("Hasil interpolasinya : "+sum);
        }

        float DeterminanKofaktor (matriks M) {
<<<<<<< HEAD
                int j;
                float det = 0;
                // ALGORITMA //
                if (M.NBrsEff == 1) {
                        det = (M.mem[1][1]);
                }
                else if (M.NBrsEff == 2) {
                        det = (M.mem[1][1]*M.mem[2][2]-M.mem[1][2]*M.mem[2][1]);
                }
                else {
                        matriks MKof = new matriks();
                        MKof.MakeMATRIKS(NBrsEff-1, NKolEff-1);
                        int tanda = 1;
                        for (j=1; j<=NKolEff; j++) {
                                for (int k=2; k<=NBrsEff; k++) {
                                        for (int l=1; l<=NKolEff; l++) {
                                                if (j!=l) {
                                                        if (l<j) {
                                                                MKof.mem[k-1][l] = M.mem[k][l];                
                                                        }
                                                        else {
                                                                MKof.mem[k-1][l-1] = M.mem[k][l];
                                                        }
=======
                 // kalo ga persegi menghasilkan det undef = -9999 
                int j;
                float det = 0;
                // ALGORITMA //
                        if (M.NBrsEff == 1) {
                                det = (M.mem[1][1]);
                        }
                        else if (M.NBrsEff == 2) {
                                det = (M.mem[1][1]*M.mem[2][2]-M.mem[1][2]*M.mem[2][1]);
                        }
                        else {
                                matriks MKof = new matriks();
                                MKof.MakeMATRIKS(NBrsEff-1, NKolEff-1);
                                int tanda = 1;
                                for (j=1; j<=NKolEff; j++) {
                                        for (int k=2; k<=NBrsEff; k++) {
                                                for (int l=1; l<=NKolEff; l++) {
                                                        if (j!=l) {
                                                                if (l<j) {
                                                                        MKof.mem[k-1][l] = M.mem[k][l];                
                                                                }
                                                                else {
                                                                        MKof.mem[k-1][l-1] = M.mem[k][l];
                                                                }
                                                        }
                                                        
>>>>>>> c75b78d26ea8f393d25039cf3e9ad537f892943f
                                                }

                                        }
                                }
<<<<<<< HEAD
                        }
                        det += tanda*M.mem[1][j]*DeterminanKofaktor(MKof);
                        tanda *= -1;
=======
                                det += tanda*M.mem[1][j]*DeterminanKofaktor(MKof);
                                tanda *= -1;
>>>>>>> c75b78d26ea8f393d25039cf3e9ad537f892943f
                }
                return det;
        }

        void DeterminanGauss (matriks M) {
                // KAMUS LOKAL //
                boolean IsFoundNot0;
                int i;
                float temp,sign,det; 
                sign = 1;
                i = 1;
                // membuat Elmt(1,1),(2,2),(3,3) dst ngga 0
                for (int j = 1; j<=M.NKolEff; j++) {
                        IsFoundNot0 = false;
                        while (IsFoundNot0 == false && i<=M.NBrsEff) {
                                if (M.mem[i][j]!=0) {
                                        IsFoundNot0 = true;
                                }
                                i += 1;
                        }
                        i-=1;
                        // tukar baris
                        if (IsFoundNot0) {
                                if (i>j) {
                                         for (int k=1;k<=M.NKolEff;k++) {
                                                 temp = M.mem[i][k];
                                                 M.mem[i][k]=M.mem[j][k];
                                                 M.mem[j][k] = temp;
                                         }
                                         sign*=-1;
                                }
                                 }
                         // untuk kolom ke-1 dibuat setelah baris j jd 0 semua
                         for (int l=j+1;l<=M.NBrsEff;l++) {
                                 for (int m=M.NKolEff;m>=1;m--) {
                                         M.mem[l][m] -= (M.mem[l][j]/M.mem[j][j])*M.mem[j][m];
                                 }

                         }
                         i = j+1;
                }
                det = 1*sign;
                for (int n=1;n<=M.NBrsEff;n++) {
                        det*=M.mem[n][n];
                }
                if (det==-0.0) {
                        det*=-1;
                }
                M.TulisMATRIKS();
                System.out.println(det);
               }
<<<<<<< HEAD
               
        void DeterminanGaussJordan (matriks M) {

=======
               void DeterminanGaussJordan (matriks M) {
>>>>>>> c75b78d26ea8f393d25039cf3e9ad537f892943f
                boolean IsFoundNot0;
                int i;
                float temp,sign,det; 
                sign = 1;
                i = 1;
                // membuat Elmt(1,1),(2,2),(3,3) dst ngga 0
                for (int j = 1; j<=M.NKolEff; j++) {
                        IsFoundNot0 = false;
                        while (IsFoundNot0 == false && i<=M.NBrsEff) {
                                if (M.mem[i][j]!=0) {
                                        IsFoundNot0 = true;
                                }
                                i += 1;
                        }
                        i-=1;
                        // tukar baris
                        if (IsFoundNot0) {
                                if (i>j) {
                                         for (int k=1;k<=M.NKolEff;k++) {
                                                 temp = M.mem[i][k];
                                                 M.mem[i][k]=M.mem[j][k];
                                                 M.mem[j][k] = temp;
                                         }
                                         sign*=-1;
                                }
                                 }
                         // untuk kolom ke-1 dibuat setelah baris j jd 0 semua (Gauss)
<<<<<<< HEAD
                         for (int l=1;l<=M.NBrsEff;l++) {
                                        for (int m=M.NKolEff;m>=1;m--) {
                                                M.mem[l][m] -= (M.mem[l][j]/M.mem[j][j])*M.mem[j][m];
                                        }


                         }
                         // dibuat segitiga 0 di atas

=======
                         for (int l=j+1;l<=M.NBrsEff;l++) {
                                        for (int m=M.NKolEff;m>=1;m--) {
                                                M.mem[l][m] -= (M.mem[l][j]/M.mem[j][j])*M.mem[j][m];
                                        }
                                 

                         }
                         // dibuat segitiga 0 di atas
                         for (int n=j-1;n>=1;n--) {
                                 for (int m=M.NKolEff;m>=1;m--) {
                                         M.mem[n][m] -= (M.mem[n][j]/M.mem[j][j])*M.mem[j][m];
                                 }
                         }
>>>>>>> c75b78d26ea8f393d25039cf3e9ad537f892943f
                         i = j+1;
                }
                det = 1*sign;
                for (int n=1;n<=M.NBrsEff;n++) {
                        det*=M.mem[n][n];
                }
                if (det==-0.0) {
                        det*=-1;
                }
                M.TulisMATRIKS();
                System.out.println(det);
               }
<<<<<<< HEAD


        void DeterminanInvers (matriks M) {
=======
               void DeterminanInvers (matriks M) {
>>>>>>> c75b78d26ea8f393d25039cf3e9ad537f892943f
                float det;        
                det = 1/(M.DeterminanKofaktor(M));
                System.out.println("Determinan : "+det);
               }
<<<<<<< HEAD

=======
>>>>>>> c75b78d26ea8f393d25039cf3e9ad537f892943f
        matriks TransposeMatriks(matriks M) {
                int i, j;
                matriks hasil = new matriks();
                hasil.MakeMATRIKS(M.NKolEff, M.NBrsEff);
                for (i = 0; i < M.NBrsEff; i++) {
                    for (j = 0; j < M.NKolEff; j++) {
                        hasil.mem[j][i] = M.mem[i][j];
                    }
                }
                return hasil;
        }
        
        matriks InversMatriks(matriks M) {
                if (DeterminanKofaktor(M) != 0) {
                        return KaliKons(AdjointMatriks(M), (1 / DeterminanKofaktor(M)));
                }
                else {
                        System.out.println("Matriks tidak punya invers");
                        return M;
                }
        }

        matriks MakeKofaktor(matriks M) { // Menghasilkan matriks yang isinya determinan kofaktor
                int i, j, k, l, o, p, sign;
                matriks KofaktorBesar = new matriks();
                KofaktorBesar.MakeMATRIKS(M.NBrsEff, M.NKolEff);
                sign = 1;
                for (i = 0; i < M.NBrsEff; i++) {
                        for (j = 0; j < M.NKolEff; j++) {
                                matriks Kofaktor = new matriks();
                                Kofaktor.MakeMATRIKS(M.NBrsEff-1, M.NKolEff-1);
                                o = 0;
                                for (k = 0; k < M.NBrsEff; k++) {
                                        p = 0;
                                        for (l = 0; l < M.NKolEff; l++) {
                                                if (k != i && l != j) {
                                                        Kofaktor.mem[o][p] = M.mem[k][l];
                                                        p = p + 1;
                                                }
                                        }
                                        if (p == M.NBrsEff-1) {
                                                o = o + 1;
                                        }
                                }
                                KofaktorBesar.mem[i][j] = DeterminanKofaktor(Kofaktor) * sign;
                                sign = sign * -1;
                        }
                }
                return KofaktorBesar;
        }

        matriks AdjointMatriks(matriks M) { // Membuat matriks adjoint
                return TransposeMatriks(MakeKofaktor(M));
            }
        
        matriks KaliKons(matriks M, float x) { // Ngaliin matriks dengan konstanta
                int i, j;
                matriks hasil = new matriks();
                hasil.MakeMATRIKS(M.NBrsEff, M.NKolEff);
                for (i = 0; i < M.NBrsEff; i++) {
                    for (j = 0; j < M.NKolEff; j++) {
                        hasil.mem[i][j] = M.mem[i][j] * x;
                    }
                }
                return hasil;
            }
	
	matriks InversGaussJordan(matriks M) {
                int i, j, k;
                float faktor;
                if (DeterminanKofaktor(M) == 0.00) {
                        System.out.println("Matriks tidak punya balikan");
                        return M;
                }
                else {
                        matriks Campuran = new matriks();
                        Campuran.MakeMATRIKS(M.NBrsEff, M.NKolEff * 2);
                        for (i = 0; i < M.NBrsEff; i++) {
                                for (j = 0; j < M.NKolEff * 2; j++) {
                                        if (j < M.NKolEff) {
                                                Campuran.mem[i][j] = M.mem[i][j];
                                        }
                                        else { // j >= MKolEff
                                                if (i == j - M.NKolEff) {
                                                        Campuran.mem[i][j] = 1;
                                                }
                                                else {
                                                        Campuran.mem[i][j] = 0;
                                                }
                                        }
                                }
                        }
                        for (j = 0; j < M.NKolEff - 1; j++) {
                                for (i = j + 1; i < M.NBrsEff; i++) {
                                        if (Campuran.mem[i][j] != 0) {
                                                faktor = Campuran.mem[i][j] / Campuran.mem[j][j];
                                                matriks temp = new matriks();
                                                temp.MakeMATRIKS(1, Campuran.NKolEff);
                                                for (k = 0; k < Campuran.NKolEff; k++) {
                                                        temp.mem[0][k] = faktor * Campuran.mem[j][k];
                                                }
                                                for (k = 0; k < Campuran.NKolEff; k++) {
                                                        Campuran.mem[i][k] = Campuran.mem[i][k] - temp.mem[0][k];
                                                }
                                        }
                                }
                        }
                        for (j = Campuran.NKolEff - 1; j > 0; j--) {
                                for (i = j - 1; i >= 0; i--) {
                                        if (Campuran.mem[i][j] != 0) {
                                                faktor = Campuran.mem[i][j] / Campuran.mem[j][j];
                                                matriks temp = new matriks();
                                                temp.MakeMATRIKS(1, Campuran.NKolEff);
                                                for (k = 0; k < Campuran.NKolEff; k++) {
                                                        temp.mem[0][k] = faktor * Campuran.mem[j][k];
                                                }
                                                for (k = 0; k < Campuran.NKolEff; k++) {
                                                        Campuran.mem[i][k] = Campuran.mem[i][k] - temp.mem[0][k];
                                                }
                                        }
                                }
                        }
                        for (i = 0; i < Campuran.NBrsEff; i++) {
                                if (Campuran.mem[i][i] != 1) {
                                        faktor = 1 / Campuran.mem[i][i];
                                        for (j = 0; j < Campuran.NKolEff; j++) {
                                                Campuran.mem[i][j] = Campuran.mem[i][j] * faktor;
                                        }
                                }
                        }
                        matriks hasil = new matriks();
                        hasil.MakeMATRIKS(M.NBrsEff, M.NKolEff);
                        for (i = 0; i < M.NBrsEff; i++) {
                                for (j = 0; j < M.NKolEff; j++) {
                                        hasil.mem[i][j] = Campuran.mem[i][j+M.NBrsEff];
                                }
                        }
                        return hasil;
                }
        }
	
            void SolusiSPL (matriks MAug) {
                // I. S. : MAug adalah matriks augmented //
                // F. S. : Dihasilkan solusi2 SPL //
                matriks MHasil = new matriks();
                MHasil.MakeMATRIKS(MAug.NKolEff, 1);
                if (MAug.SumIdxFoundNonZero(MAug.NBrsEff)==0 && MAug.mem[MAug.NBrsEff][MAug.NKolEff+1]!=0) {
                        System.out.println("Solusi tidak ada.");
                }
                else if (MAug.SumIdxFoundNonZero(MAug.NBrsEff)==1) {
                        int j = MAug.NKolEff;
                        for (int i = MAug.NBrsEff; i>=1; i--) {
                                if (i == MAug.NBrsEff) {
                                        MHasil.mem[i][1] = (MAug.mem[i][MAug.NKolEff+1]);
                                        j-=1;
                                }
                                else {
                                        MHasil.mem[i][1] = MAug.mem[i][MAug.NKolEff+1]; 
                                        for (int k = j+1; k<=MAug.NKolEff; k++) {
                                                MHasil.mem[i][1] -= MAug.mem[i][k]*MHasil.mem[k][1];
                                        }
                                        j-=1;
                                }
                        }
                        System.out.println("Solusi :");
                        for (int IdxSol1 = 1; IdxSol1 <=MHasil.NBrsEff; IdxSol1++) {
                                System.out.println("x"+IdxSol1+" = "+MHasil.mem[IdxSol1][1]);
                        }
                }
                else {
                        char[]simpanchar = new char [100];
                        char[]par = new char[11];
                        par[1] = 'p';
                        par[2] = 'q';
                        par[3] = 'r';
                        par[4] = 's';
                        par[5] = 't';
                        par[6] = 'u';
                        par[7] = 'v';
                        par[8] = 'w';
                        par[9] = 'x';
                        par[10] = 'y';
                        for (int IdxHasil = 1; IdxHasil<=MAug.NKolEff; IdxHasil++) {
                                simpanchar[IdxHasil] = '0';
                        }
                                int n = 1;
                        for (int l = MAug.NBrsEff; l>=1; l--) {
                                int Idx1Bawah = 1;
                                int Idx1Atas = 1;
                                boolean found1Bawah = false;
                                boolean found1Atas = false;
                                while (found1Bawah == false && Idx1Bawah<=MAug.NKolEff) {
                                        if (MAug.mem[l][Idx1Bawah]==1) {
                                                found1Bawah = true;
                                        }
                                        Idx1Bawah+=1;
                                }
                                while (found1Atas == false && Idx1Atas<=MAug.NKolEff) {
                                        if (MAug.mem[l-1][Idx1Atas]==1) {
                                                found1Atas = true;
                                                Idx1Atas+=1;
                                        }
                                        else {
                                                Idx1Atas+=1;
                                        }
                                }
                                Idx1Atas-=1;
                                Idx1Bawah-=1;
                                if (found1Bawah && found1Atas) {
                                        if (Idx1Bawah==MAug.NKolEff) {
                                                System.out.println("x"+(Idx1Bawah)+" = "+MAug.mem[l][NKolEff+1]);
                                                for (int a = Idx1Atas+1;a<Idx1Bawah;a++) {
                                                        simpanchar[a] = par[n];
                                                        System.out.println("x"+a+" = "+simpanchar[a]);
                                                }
                                                n++;
                                        }
                                        else {
                                                for (int a = Idx1Atas+1;a<Idx1Bawah;a++) {
                                                        simpanchar[a] = par[n];
                                                        System.out.println("x"+a+" = "+simpanchar[a]);
                                                }
                                                n++;
                                                System.out.print("x"+(Idx1Bawah)+" = "+MAug.mem[l][NKolEff+1]);
                                                for (int m=Idx1Bawah+1;m<=MAug.NKolEff;m++) {
                                                        System.out.print("+("+(-1)*MAug.mem[l][m]+simpanchar[m]+")");
                                                }
                                                System.out.println();
                                        }
                                }
                                else if (found1Atas && !found1Bawah) {
                                        for (int b = Idx1Atas+1;b<MAug.NKolEff+1;b++) {
                                                simpanchar[b] = par[n];
                                                n++;
                                                System.out.println("x"+b+" = "+simpanchar[b]);
                                        }
                                        if (l==2) {
                                                System.out.print("x"+1+" = "+MAug.mem[l-1][NKolEff+1]);
                                                for (int c=Idx1Atas+1;c<=MAug.NKolEff;c++) {

                                                        
                                                        System.out.print("+("+(-1)*MAug.mem[l-1][c]+simpanchar[c]+")");
                                                }

                                                System.out.println();
                                        }
                                }
                        }
                }
                        }
        public static void main (String[] args)
        {
               //Baca file ekstern
                        //Membuat Statement Try-Catch untuk mengatasi error jika file tidak ditemuan
                        
                        int brs,kol;
                        Scanner sc = new Scanner(System.in); 
                        System.out.println("Baris :");
                        brs = sc.nextInt();
                        System.out.println("Kolom :");
                        kol = sc.nextInt();
                        matriks M = new matriks ();
                        /*
                        M.MakeMATRIKS(brs,kol-1);
                        /*int i,j;
                                                 
                        try
                        {
                        
                                //Inisialisasi Objek dan Mendefinisikan Path Lokasi File Yang akan Dibaca
                                File file = new File("contohfileeks.txt");
                                
                                //Inisialisasi Objek Scanner dan memasang objek file yang akan dibaca
                                Scanner scan = new Scanner(file);
                                
                                //Menggunakan perulangan untuk membaca semua data didalam objek Scanner
                                while(scan.hasNextFloat())
                                {
                                        for (i=1;i<=brs;i++)
                                        {
                                                for (j=1;j<=kol;j++)
                                                {
                                                        float getData = scan.nextFloat();
                                                        M.mem[i][j]=getData;
                                                }
                                        }
                                }
                        
                                scan.close();
                        }
                        
                        catch(FileNotFoundException ex)
                        {
                                System.out.println("File Tidak Ditemukan\n"); 
                        }
                        */
        
                M.TulisMATRIKSAug();
                System.out.println("--------------------------------------------");*/
                              
<<<<<<< HEAD
                M.BacaMATRIKSAug(brs,kol);
                M.CramerSPL(M);
                
                M.InverseSPL(M);
=======
                M.BacaMATRIKS(brs,kol);
                
               /* M.InverseSPL(M);
                M.InversMatriks(M); */
                /*M.GaussSPL();
                M.TulisMATRIKSAug();*/
                M.DeterminanGaussJordan(M);
                M.SolusiSPL(M);
>>>>>>> c75b78d26ea8f393d25039cf3e9ad537f892943f
                sc.close();
    }
}
