package com.example.hibernate.xml.mapping.OneToMany.map.enums;

public enum ModelAttributeType {
    DESCRIPTION("description", "Description"), THREE_G("threeG", "3G"), BATTERY_LIFE(
            "batteryLife", "Battery Life"), BLUETOOTH("bluetooth", "Bluetooth"), CAMERA(
            "camera", "Camera"), CARRIER("carrier", "Carrier"), DIMENSION(
            "dimension", "Dimensions"), DISPLAY("display", "Display"), EMAIL(
            "email", "E-mail"), MEMORY_SLOT("memorySlot", "Memory slot"), MUSIC_PLAYER(
            "musicPlayer", "Music player"), NETWORK("network", "Network"), PHONEBOOK(
            "phoneBook", "Phonebook"), PICTUREID("pictureId", "Picture ID"), PUSHTOTALK(
            "pushToTalk", "Push to talk"), SECONDARY_DISPLAY(
            "secondaryDisplay", "Secondary display"), SMARTPHONE("smartPhone",
            "Smartphone"), SPEAKERPHONE("speakerPhone", "Speakerphone"), WEIGHT(
            "weight", "Weight"), WIFI("wifi", "Wi-Fi");

    private final String attributeName;
    private final String attributeKey;

    ModelAttributeType(String attributeKey, String attributeName) {
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

    public static ModelAttributeType findType(String key) {
        for (ModelAttributeType type : ModelAttributeType.values()) {
            if (type.getKey().equals(key)) {
                return type;
            }
        }
        return null;
    }
}
