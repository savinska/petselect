package com.softuni.petselect.model.entity;

import com.softuni.petselect.model.entity.enums.OrganizationTypeEnum;
import com.softuni.petselect.model.entity.enums.ProvinceNameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizations")
public class OrganizationEntity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private OrganizationTypeEnum organizationType;
    private String fullName;
    private ProvinceNameEnum province;
    private String address;

    private String phoneNumber;
    private String email;

    public OrganizationEntity() {
    }

    public OrganizationTypeEnum getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationTypeEnum organizationType) {
        this.organizationType = organizationType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ProvinceNameEnum getProvince() {
        return province;
    }

    public void setProvince(ProvinceNameEnum province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
