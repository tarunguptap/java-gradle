package com.example.hibernate.xml.mapping.OneToMany.map.enums;

public enum DeviceAttributeType {
    DESCRIPTION("description", "Description"), THREE_G("threeG", "3G"), BATTERY_LIFE(
            "batteryLife", "Battery Life"), BLUETOOTH("bluetooth", "Bluetooth"), PICTUREID("pictureId", "Picture ID"), PUSHTOTALK(
            "pushToTalk", "Push to talk"), SECONDARY_DISPLAY(
            "secondaryDisplay", "Secondary display"), SMARTPHONE("smartPhone",
            "Smartphone"), CAMERA("camera", "camera"), SPEAKERPHONE("speakerPhone", "Speakerphone"), WEIGHT(
            "weight", "Weight"), WIFI("wifi", "Wi-Fi"), CARRIER("carrier", "carrier");

    private final String attributeName;
    private final String attributeKey;

    DeviceAttributeType(String attributeKey, String attributeName) {
        this.attributeKey = attributeKey;
        this.attributeName = attributeName;
    }

    public String getKey() {
        return attributeKey;
    }

    public String getValue() {
        return attributeName;
    }

    @Override
    public String toString() {
        return attributeName;
    }

    public static DeviceAttributeType findType(String key) {
        for (DeviceAttributeType type : DeviceAttributeType.values()) {
            if (type.getKey().equals(key)) {
                return type;
            }
        }
        return null;
    }
}
