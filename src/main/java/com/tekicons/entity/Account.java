package com.tekicons.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "axis_account_new")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_holder_num")
    private int accNum;

    @Column(name = "acc_holder_name")
    private String accName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_num")
    private String mobile;

    public Account() {
    }

    public Account(int accNum, String accName, String address, String mobile) {
        this.accNum = accNum;
        this.accName = accName;
        this.address = address;
        this.mobile = mobile;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
