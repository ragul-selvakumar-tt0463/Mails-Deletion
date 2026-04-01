import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DEFAULT RETENTION TIME: ");
        int default_retention = scanner.nextInt();
        RetentionManager r = new RetentionManager(default_retention);


        while(true){
            System.out.println("1 ADD MAIL");
            System.out.println("2 DISPLAY MAIL");
            System.out.println("3 APPLY RETENTION");
            System.out.println("4 Check and clean");
            System.out.println("5 Change default retention");
            System.out.println("6 EXIT \n");

            System.out.print("What you want to do? (1-6)");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    //System.out.println("Enter date, if_hold, No.of custom retention and what they are");
                    System.out.println("Mail ID in numbers");
                    int mailId;
                    try {
                        mailId = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid number.");
                        scanner.nextLine(); // clear bad input
                        break;
                    }
                    System.out.println("Enter date(YYYY/MM/DD) : ");
                    scanner.nextLine();
                    String s= scanner.nextLine();
                    try {
                        LocalDate creationTime = LocalDate.parse(s,
                                DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date. Use YYYY/MM/DD format.");
                        break;
                    }

                    String[] parts = s.split("/");
                    int year = Integer.parseInt(parts[0]);
                    int month= Integer.parseInt(parts[1]);
                    int date = Integer.parseInt(parts[2]);

                    System.out.println("Number of custom retentions");
                    int cus_ret = scanner.nextInt();
                    List<Integer> list = new ArrayList<>();

                    if(cus_ret != 0){
                        System.out.println("Enter the retention months");
                        for(int i=0; i<cus_ret; i++ ){
                            list.add(scanner.nextInt());
                        }
                    }
                    boolean hold= false;
                    System.out.println("ON HOLD?(y/n)");
                    scanner.nextLine();
                    String s_hold;
                    try{
                        s_hold = scanner.nextLine();
                        if(s_hold.equals("y")){
                            hold= true;
                        }
                    }
                    catch(Exception e){
                        System.out.println("y/n... please");
                        break;
                    }


                    Mail m = new Mail(mailId, LocalDate.of(year, month, date), hold, list);
                    r.addMail(m);
                    System.out.println("Mail Added Successfully");
                    break;

                case 2:
                    r.viewMails();
                    break;

                case 3:
                    //apply retentions to specific mails, probably based on mail id, but since i have put mails like serial number ill do something
                    System.out.println("Which mail id to add retention");
                    int maillId = -1;
                    int months = -1;
                    try {
                        maillId = scanner.nextInt();
                        System.out.println("Number of months");
                        months = scanner.nextInt();
                        r.setCustomRetention(maillId, months);
                    } catch (InputMismatchException e) {
                        System.out.println("Enter numbers only.");
                        scanner.nextLine(); // clear bad input
                    }
                    break;

                case 4:
                    r.testAndDelete();
                    break;

                case 5:
                    System.out.println("Enter months");
                    int mon;
                    try{
                        mon= scanner.nextInt();
                        r.setDefaultRetention(mon);
                        System.out.println("Default retention set, try check and clean ");
                    }
                    catch(Exception e){
                        System.out.println("Months in numbers");
                    }

                case 6:
                    return;

                default:
                    System.out.println("Wrong options");
            }
        }

//        Mail m= new Mail(1, LocalDate.of(2002,02,12), true, Arrays.asList(1,2));
//
//        System.out.println(m);
        }
    }
