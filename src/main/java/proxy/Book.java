package proxy;

import java.math.BigDecimal;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
public class Book {
    private String name;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
