package com.easyArch.entity;


import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 735655488285535299L;

    private String Sno;
    private String Spwd;
    private String Sname;
    private int Sage;
    private String Scall;
    private String Collage;
    private String Major;
    private String Sclass;
    private String Birth;
    private int Gender;

}
