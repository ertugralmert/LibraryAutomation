package com.mert.Utility;

import com.mert.Utility.Database;
import com.mert.controller.MemberController;
import com.mert.entity.Library;
import com.mert.service.book.MemberService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GUI {


private final Scanner scanner = new Scanner(System.in);
private final Library library;

public GUI(){
    this.library = new Library();
}

    public void run(){
        boolean runn = true;

        while(runn){
            mainGUI();
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1 : {
                        System.out.println("Ailemize Hoş Geldiniz");
                        library.memberController.addMember(); break;
                    }
                    case 2: {
                        System.out.println("Uye İşlemlerine Hoş Geldiniz");
                        subGUIMemberUyeIslemleri(); break;
                    }
                    case 3: {
                        loginAdmin(); break;
                    }
                    case 0 : {
                        System.out.println("Çıkış Yapıldı");
                        runn = false; break;
                    }
                    default:
                        System.out.println("Geçersiz İşlem"); break;
            }

            }catch (InputMismatchException e){
                System.out.println("Lütfen Geçerli bir seçim yapınız");
                scanner.nextLine();
            }
        }
    }
























    public void mainGUI(){
        System.out.println(">>>Kütüphane Sistemine Hoş Geldiniz<<<");
        System.out.println("""
                Lütfen Yapmak İstediğiniz İşlemi Seçiniz
                
                1-> Uye Ol
                
                2-> Uye İşlemleri
                   
                3-> Kütüphane İşlemleri
                
                0-> Ç I K I Ş
                  
                 
                """);
        System.out.print("Secim: ");
    }


    public void subGUIMemberUyeIslemleri() {
        boolean kontrol = true;
    while(kontrol) {
        System.out.println("""
                Buradaki İşlemler İçin Giriş Yapmanız Gerekiyor
                1- Giriş
                0- Ç I K I Ş
                                  
                """);
        System.out.print("secim: ");
        int secim = scanner.nextInt();
        scanner.nextLine();
        switch (secim) {
            case 1: {
                boolean IsLoginMember = false;
                int sayac = 3;
                while (sayac > 0 && !IsLoginMember) {
                    IsLoginMember = library.memberController.login();
                    if (!IsLoginMember) {
                        sayac--;
                        System.out.println("Kalan deneme hakkınız: " + sayac);
                    }
                }

                if (IsLoginMember) {
                    boolean check = true;

                    while (check) {
                        System.out.println("""
                                1- Kiralama
                                2- Iade
                                3- Kiralanan Kitap Listesi
                                4- Tüm Kitap Listesi

                                           
                                0- Ç I K I Ş""");
                        System.out.print("Seçim: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1: {
                                System.out.println("Kiralama İşlemi Başladı");
                                library.memberController.rentBook();
                                break;
                            }
                            case 2: {
                                System.out.println("İade İşlemi Başladı");
                                library.memberController.returnBook();
                                break;
                            }
                            case 3: {
                                System.out.println("Kiraladığınız Kitapların Listesi");
                                System.out.println(library.memberController.listRantedBooks());
                                break;
                            }
                            case 4: {
                                System.out.println("Tüm Kitap Listesi");
                                library.printAllBooks();
                            }

                            case 0: {
                                System.out.println("Çıkış yapılıyor");
                                check = false;
                                break;
                            }
                            default:
                                System.out.println("Geçersiz İşlem");
                                break;
                        }

                    }

                } else {
                    System.out.println("Giriş Başarısız. Programdan Çıkılıyor");
                }


                break;
            }
            case 0: {
                kontrol = false;
            }
            default:
                System.out.println("Geçersiz İşlem");
        }


    }
    }




    public void loginAdmin() {
        int sayac = 0;
        boolean isAdminLogged = false;

        while (sayac < 3 && !isAdminLogged) {
            System.out.println("Kütüphane Yönetimine Hoş Geldiniz");
            System.out.println("Lütfen Giriş Yapınız");
            System.out.print("user: ");
            String user = scanner.nextLine();
            System.out.print("password: ");
            String password = scanner.nextLine();
            if (library.loginAsAdmin(user, password)) {
                isAdminLogged = true;
                System.out.println("Giriş başarılı,Yapmak istediğiniz işlemi seçiniz");
                manageAdminMenu();
            } else {
                sayac++;
                System.out.println("Giriş Başarısız, lütfen tekrar deneyin. Kalan deneme Hakkı: "
                        + (3 - sayac));
            }
        }
        if (!isAdminLogged) {
            System.out.println("Giriş hakkınız doldu. Programdan çıkılıyor.");
        }
    }

    private void manageAdminMenu(){
    boolean mainRun = true;

            while(mainRun){
                subGUILibrary();
                System.out.print("Seçim: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1 : manageHistoryBooks(); break;
                    case 2 : manageRoman(); break;
                     // case 3
                    case 3: manageScienceHistory(); break;
                    case 4 : {
                        System.out.println("Üye Listesi");
                        memberList();
                       break;
                    }
                    case 5: {
                        System.out.println("Kiralanan Kitap Listesi");
                        library.printRentedBooks();
                        break;
                    }
                    case 6: {
                        System.out.println("Tüm Kitap Listesi");
                        library.printAllBooks();
                        break;
                    }
                    case 0 : {
                        System.out.println("Çıkış yapıldı");
                        mainRun = false;
                        break;
                    }
                    default:
                        System.out.println("Geçersiz seçim");
                }

            }


        }

        private void manageHistoryBooks(){
    boolean runHistory = true;
    while (runHistory){
        bookSout();
        System.out.print("Seçim: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){

                    case 1: {
                        System.out.println("Kitap Ekleme");
                        library.historyController.addBook();
                        break;
                    }
                    case 2: {
                        System.out.println("Isme göre Arama");
                        library.historyController.listByName();
                        break;
                    }
                    case 3: {
                        System.out.println("Yazar ismine göre ara");
                        library.historyController.listByAuthor();
                        break;
                    }

                    case 4: {
                        System.out.println("ISBN göre arama");
                        library.historyController.listByISBN();
                        break;
                    }
                    case 5: {
                        System.out.println("Kitapları Listele");
                        library.historyController.listAll();
                        break;
                    }
                    case 0: {
                        System.out.println("Çıkış yapıldı");
                        runHistory = false;
                        break;
                    }
                    default: {
                        System.out.println("Geçersiz Seçim");
                        break;
                    }
                    }
                }
            }

    private void manageRoman(){
        boolean runHistory = true;
        while (runHistory){
            bookSout();
            System.out.print("Seçim: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){

                case 1: {
                    System.out.println("Kitap Ekleme");
                    library.romanController.addBook();
                    break;
                }
                case 2: {
                    System.out.println("Isme göre Arama");
                    library.romanController.listByName();
                    break;
                }
                case 3: {
                    System.out.println("Yazar ismine göre ara");
                    library.romanController.listByAuthor();
                    break;
                }

                case 4: {
                    System.out.println("ISBN göre arama");
                    library.romanController.listByISBN();
                    break;
                }
                case 5: {
                    System.out.println("Kitapları Listele");
                    library.romanController.listAll();
                    break;
                }
                case 0: {
                    System.out.println("Çıkış yapıldı");
                    runHistory = false;
                    break;
                }
                default: {
                    System.out.println("Geçersiz Seçim");
                    break;
                }
            }
        }
    }

    private void manageScienceHistory(){
        boolean runHistory = true;
        while (runHistory){
            bookSout();
            System.out.print("Seçim: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){

                case 1: {
                    System.out.println("Kitap Ekleme");
                    library.scienceController.addBook();
                    break;
                }
                case 2: {
                    System.out.println("Isme göre Arama");
                    library.scienceController.listByName();
                    break;
                }
                case 3: {
                    System.out.println("Yazar ismine göre ara");
                    library.scienceController.listByAuthor();
                    break;
                }

                case 4: {
                    System.out.println("ISBN göre arama");
                    library.scienceController.listByISBN();
                    break;
                }
                case 5: {
                    System.out.println("Kitapları Listele");
                    library.scienceController.listAll();
                    break;
                }
                case 0: {
                    System.out.println("Çıkış yapıldı");
                    runHistory = false;
                    break;
                }
                default: {
                    System.out.println("Geçersiz Seçim");
                    break;
                }
            }
        }
    }








    private void subGUILibrary(){
        System.out.println("""
                    1- Tarih Kitabı İşlemleri
                    2- Roman Kitabı İşlemleri
                    3- Bilim Kitabı İşlemleri
                    4- Uye Listesi
                    5- Kiralanan Kitap Listesi
                    6- Tüm Kitap Listesi
                    
                    0- Çıkış
                """);
    }



    private void bookSout(){
        System.out.println("""
                1- Kitap Ekle
                2- Kitap Ismine göre ara
                3- Kitap yazarına göre ara
                4- Kitap ISBN göre ara
                5- Kitap Listele
                0- Ç I K I Ş
                """);
    }

    public void memberList(){
        Database.memberList.forEach(System.out::println);
    }

}

