package edu.njit.mynovelnet.user.entity;

public class ReadReaderEntity {
    private Integer ifAutoOrder;
    private Integer bookCoins;


    public Integer getIfAutoOrder() {
        return ifAutoOrder;
    }

    public void setIfAutoOrder(Integer ifAutoOrder) {
        this.ifAutoOrder = ifAutoOrder;
    }

    public Integer getBookCoins() {
        return bookCoins;
    }

    public void setBookCoins(Integer bookCoins) {
        this.bookCoins = bookCoins;
    }

    @Override
    public String toString() {
        return "ReadReaderEntity{" +
                "ifAutoOrder=" + ifAutoOrder +
                ", bookCoins=" + bookCoins +
                '}';
    }
}
