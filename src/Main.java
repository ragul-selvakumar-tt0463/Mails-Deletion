import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("5 EXIT \n");

            System.out.print("What you want to do?");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    //System.out.println("Enter date, if_hold, No.of custom retention and what they are");
                    System.out.println("Mail ID in numbers");
                    int mailId = scanner.nextInt();
                    System.out.println("Enter date(YYYY/MM/DD) : ");
                    scanner.nextLine();
                    String s= scanner.nextLine();

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
                    scanner.nextLine(); // consume leftover newline
                    String s_hold = scanner.nextLine();
                    if(s_hold.equals("y")){
                        hold= true;
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
                    System.out.println("Which mails id to add retention");
                    int mail_Id = scanner.nextInt();
                    System.out.println("Number of months");
                    int months= scanner.nextInt();
                    r.setCustomRetention(mail_Id, months);
                    break;

                case 4:
                    r.testAndDelete();
                    break;

                case 5:
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
