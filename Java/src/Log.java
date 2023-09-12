import java.util.ArrayList;
import java.util.List;

public class Log {
    private static Log instance = null;
    private List<String> logMessages;

    private Log(){
        logMessages = new ArrayList<>();
    }
    public void log(String message) {
        logMessages.add(message);
    }
    public static Log getInstance(){
        if(instance == null){
            instance = new Log();
        }
        return instance;
    }

    public List<String> getLogMessages() {
        return logMessages;
    }
}
