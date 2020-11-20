package Design_mode;

import java.time.LocalDate;

public class Creation_mode {
    public static LocalDate fromInt(int yyyyMMdd){
        return LocalDate.of(yyyyMMdd/10000,yyyyMMdd/100%100,yyyyMMdd%100);
    }
}

