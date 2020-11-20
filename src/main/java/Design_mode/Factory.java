package Design_mode;

import java.time.LocalDate;

interface Factory {
    LocalDate fromInt(int yyyyMMdd);
}

interface LocalDateFactory extends Factory {
    static LocalDateFactory getFactory() {
        return new LocalDateFactoryImp();
    }
}

class LocalDateFactoryImp implements LocalDateFactory {
    public LocalDate fromInt(int yyyyMMdd) {
        return LocalDate.of(yyyyMMdd / 10000, yyyyMMdd / 100 % 100, yyyyMMdd % 100);
    }
}

