package Behavioral_model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Chain_of_responsibility {
    private String name;
    private BigDecimal amount;

    public Chain_of_responsibility(String name, BigDecimal amount) {
        this.amount = amount;
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public BigDecimal getAmount() {
        return amount;
    }
}


interface Handler {
    Boolean process(Chain_of_responsibility request);
}

class ManagerHandler implements Handler {
    public Boolean process(Chain_of_responsibility request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        return !request.getName().equalsIgnoreCase("Bob");
    }
}

class HandlerChain {
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        this.handlers.add(handler);
    }

    public boolean process(Chain_of_responsibility request) {
        for (Handler handler : handlers) {
            Boolean r = handler.process(request);
            if (r != null) {
                System.out.println(request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return r;
            }
        }
        throw new RuntimeException("could not handle request:" + request);
    }
}
//class Main {
//    public static void main(String[] args) {
//        HandlerChain chain = new HandlerChain();
//        chain.addHandler(new ManagerHandler());
//
//        chain.process(new Chain_of_responsibility("Bob", new BigDecimal("123.45")));
//        chain.process(new Chain_of_responsibility("Alice", new BigDecimal("1234.56")));
//        chain.process(new Chain_of_responsibility("Bill", new BigDecimal("12345.67")));
//        chain.process(new Chain_of_responsibility("John", new BigDecimal("123456.78")));
//
//    }
//}
