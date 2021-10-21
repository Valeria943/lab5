import java.io.*;
import java.util.Scanner;

public class Files_byteRW_my2 {
    private static DataInputStream rd;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Введите имя файла => ");
        String namef=sc.nextLine();
        try{
// Создается файл
            File f1=new File(namef);
            f1.createNewFile(); // файл создан
            System.out.println("Полный путь файла: "+ f1.getAbsolutePath());

            System.out.print("Введите количество строк для записи в файл => ");
            int n=sc.nextInt();
// Создается поток для записи с учетом типа данных – DataOutputStream,
// и ему в качестве параметра передается поток FileOutputStream
            DataOutputStream dOut=
                    new DataOutputStream( new FileOutputStream(f1));
            sc.nextLine(); //очистка буфера
            for (int i = 0; i < n; i++) {
                System.out.print("Введите строку для записи в файл => ");
                String s=sc.nextLine();
                dOut.writeUTF(s );
                //или dOut.writeUTF(s +"\n" ); – запись отдельных строк
            }
            dOut.flush(); // дописываем несохраненные данные на диск
            dOut.close(); // закрываем поток
// Чтение и вывод данных из созданного файла
            DataInputStream din=new DataInputStream(new FileInputStream(f1));
            while (true) {
                System.out.println(rd.readUTF());
            }
        }catch (Exception e) {
            System.out.println(""+e);
        }
    }
}
