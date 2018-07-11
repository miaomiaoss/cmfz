package com.baizhi.zy.Dto;

import java.io.Serializable;

public class UserDto implements Serializable {
    private int[] countUser;

    public UserDto() {
    }

    public UserDto(int[] countUser) {
        this.countUser = countUser;
    }

    public int[] getCountUser() {
        return countUser;
    }

    public void setCountUser(int[] countUser) {
        this.countUser = countUser;
    }
}
