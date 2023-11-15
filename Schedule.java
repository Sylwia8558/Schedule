package Schedule;


public class Schedule implements ScheduleInterface {
    private int number;
    private String name;
    private String leader;
    private int credit;
    private String weekday;
    private String hour;
    private String hall;

    public Schedule(int number, String name, String leader, int credit, String weekday, String hour, String hall)
    {
        this.number = number;
        this.name = name;
        this.leader = leader;
        this.credit = credit;
        this.weekday = weekday;
        this.hour = hour;
        this.hall = hall;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLeader()
    {
        return leader;
    }
    public void setLeader(String leader)
    {
        this.leader = leader;
    }
    public int getCredit()
    {
        return credit;
    }
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    public String getWeekday()
    {
        return weekday;
    }
    public void setWeekday(String weekday)
    {
        this.weekday = weekday;
    }
    public String getHour()
    {
        return hour;
    }
    public void setHour(String hour)
    {
        this.hour = hour;
    }
    public String getHall()
    {
        return hall;
    }
    public void setHall(String hall)
    {
        this.hall = hall;
    }
    @Override
    public String toString()
    {
        return number + ". Przedmiot{" +
                "nazwa='" + name + '\'' +
                ", prowadzący='" + leader + '\'' +
                ", punkty ECTS='" + credit + '\'' +
                ", dzień tygodnia='" + weekday + '\'' +
                ", godzina='" + hour + '\'' +
                ", sala='" + hall +'\'' +
                '}';
    }
    @Override
    public int point()
    {
        return credit;
    }
    @Override
    public String hour()
    {
        return hour;
    }
    @Override
    public String weekday()
    {
        return weekday;
    }
    @Override
    public String name()
    {
        return name;
    }
    @Override
    public String zapis_do_pliku()
    {
        return "• " + name + ", " + leader + ", " + credit + " ECTS" + ", " +"godz. " + hour + ", " + hall ;
    }
}

