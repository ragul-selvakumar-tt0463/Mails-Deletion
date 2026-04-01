import java.time.LocalDate;
import java.util.*;

public class RetentionManager {

    private int defaultRetention;
    private final TreeMap<LocalDate, List<Mail>> mailStore;
    private final HashMap<Integer, List<Mail>> mailById;

    public RetentionManager(int defaultRetention) {
        this.defaultRetention = defaultRetention;
        this.mailStore = new TreeMap<>();
        this.mailById= new HashMap<>();
    }
    public void setDefaultRetention(int months) {
        this.defaultRetention = months;
    }

    public void addMail(Mail mail) {
        mailStore
                .computeIfAbsent(mail.creteTime, k -> new ArrayList<>())
                .add(mail);

        mailById
                .computeIfAbsent(mail.id, k-> new ArrayList<>())
                .add(mail);
    }

    public void viewMails(){
        if(mailStore.isEmpty()){
            System.out.println("No Mail Records"); return;
        }

        for(LocalDate date: mailStore.keySet()){
            System.out.println("DATE: "+ date);
            for(Mail mail : mailStore.get(date)){
                System.out.println(mail);
            }
        }
        System.out.println("\n\n");

    }

    public void setCustomRetention( int mailId, int months){
        List<Mail> mails = mailById.get(mailId);
        for(Mail mail: mails){
            mail.customRetention.add(months);
        }
    }

    public void testAndDelete(){
        LocalDate globalCutOff = LocalDate.now().minusMonths(defaultRetention);

        for(LocalDate d: new ArrayList<>(mailStore.keySet())){
            if (!d.isBefore(globalCutOff)) {
                return;
            }

            List<Mail> list = mailStore.get(d);
            Iterator<Mail> it = list.iterator();

            while(it.hasNext()){
                Mail mail = it.next();
                if(mail.isHold){
                    continue;
                }
                int retention = defaultRetention;

                if (!mail.customRetention.isEmpty()) {
                    retention = Collections.max(mail.customRetention);
                }
                if (mail.creteTime.plusMonths(retention).isBefore(LocalDate.now())) {
                    it.remove();
                    List<Mail> idList = mailById.get(mail.id);
                    if (idList != null) {
                        idList.remove(mail);

                        if (idList.isEmpty()) {
                            mailById.remove(mail.id);
                        }
                    }
                }
            }

            if (list.isEmpty()) {
                mailStore.remove(d);
            }
        }
    }



}