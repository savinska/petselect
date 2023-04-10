package com.softuni.petselect.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "blocked_ips")
public class BlockedIP extends BaseEntity{

    private String ip;

    public BlockedIP() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
