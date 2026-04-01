import java.time.LocalDate;
import java.util.List;

public class Mail {

    int id;
    String content = "dummy";
    LocalDate creteTime;
    boolean isHold;
    List<Integer> customRetention;

    public Mail (int id, LocalDate createTime, boolean isHold, List<Integer> customRetention){
        this.id= id;
        this.creteTime = createTime;
        this.isHold = isHold;
        this.customRetention = customRetention;
    }

    @Override
    public String toString(){
        return "MAil_id = " + id + "; Content "+content+ "; CreatedAt "+creteTime+"; Hold "+isHold+"; Custom Retentions "+customRetention ;
    }
}
