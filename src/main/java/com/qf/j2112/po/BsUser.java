package com.qf.j2112.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BsUser implements Serializable {
    private int userid;
    private String loginname;
    private String password;
    private String usertel;
    private String addres;
    private String realname;
    private String gender;
    private String userpic;
}
