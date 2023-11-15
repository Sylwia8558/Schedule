package Schedule;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class ListSchedule {
    static final String STOP = "nie";
    public static void main(String[] args) throws IOException {

        List<Schedule> listschedule = Arrays.asList(
                new Schedule(1,"Analiza matematyczna", "dr Monika Okulska", 6, "poniedziałek", "12:00", "aula II"),
                new Schedule(2," Mikroekonomia", "mgr inż. Grzegorz Gardiasz", 3, "środa", "8:00", "aula I"),
                new Schedule(3,"Mikroekonomia", "dr Marta Nowak", 4, "poniedziałek", "8:00", "aula III"),
                new Schedule(4,"Informatyka ekonomiczna", " mgr Anna Tomczyk", 2, "czwartek", "14:00", "aula IV"),
                new Schedule(5,"Język angielski", "dr Paulina Komenda", 5, "czwartek", "12:00", "aula I"),
                new Schedule(6,"Język anielski", "dr Marczak Konrad", 5, "wtorek", "10:00", "aula I"),
                new Schedule(7,"Makroekonomia", "dr hab.Iwanowicz Sławomir", 3, "wtorek", "10:00", "aula IV"),
                new Schedule(8,"Rachunek prawdopodobieństwa", "dr hab. Mojsak Greta", 6, "poniedziałek", "8:00", "aula II"),
                new Schedule(9,"Rachunek prawdopodobieństwa", "dr hab. MOjsak Greta", 6, "środa", "12:00", "aula I"),
                new Schedule(10,"Algorytmy i struktura danych", "dr inż. Piotr Jan Papiernik", 2, "piątek", "8:00", "aula II"),
                new Schedule(11,"Programowanie w języku C#", "dr Paweł Szyszko", 4, "środa", "18:00", "aula V"),
                new Schedule(12,"Programowanie w języku C++", "dr hab. Ilona Siwkowska", 4, "czwartek", "16:00", "aula V"),
                new Schedule(13,"Programowanie w języku SQL", "dr Tomasz Smoliński", 5, "wtorek", "14:00", "aula VI"),
                new Schedule(14,"Programowanie w języku SQL", "dr Tomasz Smoliński", 5, "wtorek", "16:00", "aula VI"),
                new Schedule(15,"Programowanie w języku Java", "dr hab. Agnieszka Suchocka", 5, "czwartek", "14:00", "aula V"),
                new Schedule(16,"Programowanie w języku Java", "dr Karol Suchocki", 5, "czwartek", "8:00", "aula VI"),
                new Schedule(17,"Zarządzanie", "dr Agnieszka Stok", 2, "piątek", "10:00", "aula II"),
                new Schedule(18,"Matematyka finansowa", "mgr inż. Szymon Kittner", 3, "poniedziałek", "14:00", "aula III"),
                new Schedule(19,"Język hiszpański", "dr Miguel Servet", 4, "czwartek", "8:00", "aula I"),
                new Schedule(20,"Język francuski", "dr Vincent Cassel", 4, "wtorek", "12:00", "aula II"),
                new Schedule(21,"Język rosyjski", "dr Aleksandra Sobieraj", 4, "czwartek", "14:00", "aula III"),
                new Schedule(22,"Język niemiecki", "dr Nikola Rzeźnicka", 4, "piątek", "10:00", "aula IV"),
                new Schedule(23,"Systemy operacyjne", "dr hab. Jacek Karp", 5, "czwartek", "8:00", "aula III"),
                new Schedule(24,"Statystyka matematyczna", "dr hab. Wojciech Jagiełło", 6, "środa", "8:00", "aula II"),
                new Schedule(25,"Budowa stron WWW", "mgr inż. Mateusz Gołacki", 3, "piątek", "12:00", "aula V")
        );
        String decyzja;
        List<Schedule> newList = new ArrayList<Schedule>();

        do {
            System.out.println("Ułóż swój plan zajęć ");
            System.out.println("Chcesz filtrować za pomocą: ");
            System.out.println("a.nazwy przedmiotu");
            System.out.println("b.prowadzącego");
            System.out.println("c.dnia tygodnia");
            System.out.println("d.godziny rozpoczęcia zajęć");
            System.out.println("e.pokaż wszystkie dostępnt zajęcia");

            Scanner in = new Scanner(System.in);
            String wybor1 = in.nextLine();

            Stream<Schedule> actStram = listschedule.stream();

            if (wybor1.equalsIgnoreCase("a")) {
                System.out.println("Podaj nazwę przedmiotu");
                String name1 = in.nextLine();
                actStram = listschedule.stream()
                        .filter(schedule -> schedule.getName().equalsIgnoreCase(name1));

            } else if (wybor1.equalsIgnoreCase("b")) {
                System.out.println("Podaj dane prowadzącego");
                String leader1 = in.nextLine();
                actStram = listschedule.stream()
                        .filter(schedule -> schedule.getLeader().equalsIgnoreCase(leader1));

            } else if (wybor1.equalsIgnoreCase("c")) {
                System.out.println("Podaj dzień tygodnia");
                String weekday1 = in.nextLine();
                actStram = listschedule.stream()
                        .filter(schedule -> schedule.getWeekday().equalsIgnoreCase(weekday1));

            } else if (wybor1.equalsIgnoreCase("d")) {
                System.out.println("Podaj godzine rozpoczęcia zajęć");
                String time1 = in.nextLine();
                actStram = listschedule.stream()
                        .filter(schedule -> schedule.getHour().equalsIgnoreCase(time1));
            }
            Schedule[] SheduleArray = actStram.toArray(Schedule[]::new);
            Arrays.asList(SheduleArray).forEach(System.out::println);


            try{
                if (SheduleArray.length > 0) {
                System.out.println("Podaj numer przedmiotu, który wybierasz: ");
               int number1 = in.nextInt();
                if (number1 < listschedule.size() && number1 > 0) {
                    Schedule wybranyPrzedmiot = listschedule.get(number1 - 1);
                    if (Arrays.asList(SheduleArray).contains(wybranyPrzedmiot)) {

                        int sum = 0;
                        try {
                            for (Schedule i : newList) {
                                if (i.hour().equals(wybranyPrzedmiot.hour()) && i.weekday().equals(wybranyPrzedmiot.weekday()))
                                    sum++;
                                if (i.name().equals(wybranyPrzedmiot.name()))
                                    sum++;
                            }
                            if (sum == 0) {
                                newList.add(wybranyPrzedmiot);
                                System.out.println(wybranyPrzedmiot.toString());
                            }
                            else
                              System.out.println("Nie możesz dodać tych zajęć! ");
                        } catch (RuntimeException e) {
                            System.out.println("Nie możesz dodać tych zajęć! ");
                        }
                    } else {
                        System.out.println("Podano bledne dane");
                    }
                }
            }
        }catch (InputMismatchException e)
        {
            System.out.println("Udzielono błędnej odpowiedzi! ");
        }
            System.out.println("Chcesz dodać kolejny przedmiot?");
            System.out.println("tak");
            System.out.println("nie");
             decyzja = in.next();
             if(decyzja.equalsIgnoreCase("tak")) System.out.println("Dodawanie następnego przedmiotu ");

        }while (!decyzja.equalsIgnoreCase(STOP));

        String filePath ="D:\\Pulpit\\Case1\\plan_zajec.txt";
        FileWriter filewrite = null;
        List<Schedule> poniedzialek = new ArrayList<Schedule>();
        for (Schedule i: newList) {
            if(i.weekday().equals("poniedziałek") )
                poniedzialek.add(i);
        }
        List<Schedule> wtorek = new ArrayList<Schedule>();
        for (Schedule i: newList) {
            if(i.weekday().equals("wtorek") )
                wtorek.add(i);
        }
        List<Schedule> sroda = new ArrayList<Schedule>();
        for (Schedule i: newList) {
            if(i.weekday().equals("środa") )
                sroda.add(i);
        }
        List<Schedule> czwartek = new ArrayList<Schedule>();
        for (Schedule i: newList) {
            if(i.weekday().equals("czwartek") )
                czwartek.add(i);
        }
        List<Schedule> piatek = new ArrayList<Schedule>();
        for (Schedule i: newList) {
            if(i.weekday().equals("piątek") )
                piatek.add(i);
        }
        try{
            filewrite = new FileWriter(filePath);
            filewrite.write("PLAN ZAJĘC\r\n");
            if(!poniedzialek.isEmpty()) {
                filewrite.write("PONIEDZIAŁEK\r\n");
                filewrite.write(poniedzialek.get(0).zapis_do_pliku() + "\r\n");
            }
            if(!wtorek.isEmpty()) {
                filewrite.write("WTOREK\r\n");
                filewrite.write(wtorek.get(0).zapis_do_pliku() + "\r\n");
            }
            if(!sroda.isEmpty()) {
                filewrite.write("ŚRODA\r\n");
                filewrite.write(sroda.get(0).zapis_do_pliku() + "\r\n");
            }
            if(!czwartek.isEmpty()) {
                filewrite.write("CZWARTEK\r\n");
                filewrite.write(czwartek.get(0).zapis_do_pliku()+"\r\n");
            }
            if(!piatek.isEmpty()) {
                filewrite.write("PIĄTEK\r\n");
                filewrite.write(piatek.get(0).zapis_do_pliku()+ "\r\n");
            }
            int ects=0;
            for(Schedule i : newList)
            {
                ects = ects +i.point();
            }
            if(ects > 30 )
            {
                ects = (ects - 30);
                int cost = ects *150;
                filewrite.write("**DOPŁATA**\r\n");
                filewrite.write("Przekroczono " + ects + " ECTS, za co zostaje naliczona opłata " + cost + " zł. Jeżeli chcesz, aby opłata została\r\n " +
                        "potrącona ze stypendium Rektora, skontaktuj się z dziekanatem.");

            }
        }

        finally {
            if(filewrite!= null)
                filewrite.close();
        }
    }
}
