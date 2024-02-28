package org.example.entity;

public class VillagePart {
    public Integer code;
    public String name;
    public Integer villageCode;

    public VillagePart(Integer code, String name, Integer villageCode) {
        this.code = code;
        this.name = name;
        this.villageCode = villageCode;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getVillageCode() {
        return villageCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setVillageCode(Integer villageCode) {
        this.villageCode = villageCode;
    }
}
