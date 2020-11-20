package Behavioral_model;

import java.util.Scanner;

public interface State {
    String init();

    String reply(String input);

}

class Connected implements State {
    public String init() {
        return "Hello,Im Bob";
    }

    public String reply(String input) {
        if (input.endsWith("?")) {
            return "yes." + input.substring(0, input.length() - 1) + "!";
        }
        if (input.endsWith(".")) {
            return input.substring(0, input.length() - 1) + "!";
        }
        return input.substring(0, input.length() - 1) + "?";
    }
}

class Disconnected implements State {
    public String init() {
        return "bye";
    }
    public String reply(String input) {
        return "";
    }
}

class BotContext{
    private State state=new Disconnected();

    public String chat(String input){
        if ("hello".equalsIgnoreCase(input)){
            state=new Connected();
            return state.init();
        } else if ("bye".equalsIgnoreCase(input)){
            state=new Disconnected();
            return state.init();
        }
        return state.reply(input);
    }
}

//class Main{
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        BotContext bot=new BotContext();
//
//        for (;;){
//            System.out.println(">");
//            String input=sc.nextLine();
//            String output=bot.chat(input);
//            System.out.println(output.isEmpty()?"(no replay)":"< "+output);
//        }
//    }
//}