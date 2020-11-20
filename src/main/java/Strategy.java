import mx4j.tools.remote.soap.axis.ser.AttributeSer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

public class Strategy {
}

//class Main {
//    public static void main(String[] args) throws InterruptedException {
//        String[] array = {"apple", "Pear", "Banana", "orange"};
//        Arrays.sort(array, String::compareToIgnoreCase);
//        System.out.println(Arrays.toString(array));
//    }
//
//    static <T> void sort(T[] a, Comparator<? super T> c) {
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = 0; j < a.length - 1 - i; j++) {
//                if (c.compare(a[j], a[j + 1]) > 0) {
//                    T temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                }
//            }
//        }
//    }
//}

interface DiscountStrategy {
    BigDecimal getDiscount(BigDecimal total);
}

class UserDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.multiply(new BigDecimal("0.1").setScale(2, RoundingMode.DOWN));
    }
}

class OverDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.compareTo(BigDecimal.valueOf(100)) >= 0
                ? BigDecimal.valueOf(20) : BigDecimal.ZERO;
    }
}

class PrimeDiscountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        // Prime会员打七折:
        return total.multiply(new BigDecimal("0.3")).setScale(2, RoundingMode.DOWN);
    }
}

class DiscountContext {
    // 持有某个策略:
    private DiscountStrategy strategy = new UserDiscountStrategy();

    // 允许客户端设置新策略:
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal calculatePrice(BigDecimal total) {
        return total.subtract(this.strategy.getDiscount(total)).setScale(2);
    }
}

class Main{
    public static void main(String[] args){
        DiscountContext ctx=new DiscountContext();

        // 默认使用普通会员折扣:
        BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay1);
        // 使用满减折扣:
        ctx.setStrategy(new OverDiscountStrategy());
        BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay2);
        // 使用Prime会员折扣:
        ctx.setStrategy(new PrimeDiscountStrategy());
        BigDecimal pay3 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay3);
    }
}

