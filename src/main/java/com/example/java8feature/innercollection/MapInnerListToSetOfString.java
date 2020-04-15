package com.example.java8feature.innercollection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MapInnerListToSetOfString {

    public static void main(String[] args) {
        MapInnerListToSetOfString m = new MapInnerListToSetOfString();
        Set<CustomerDTO> customerDTOSet = m.getCustomerDTO();
        Set<String> addressNames = customerDTOSet.stream().flatMap(cust -> cust.getAddressDto().stream()).map(AddressDTO::getAddressName).collect(Collectors.toSet());
        System.out.println(addressNames);
    }


    public Set<MapInnerListToSetOfString.AddressResponse> getAddressResponse() {
        Set<MapInnerListToSetOfString.AddressResponse> addressResponseSet = new HashSet<>();
        addressResponseSet.add(new MapInnerListToSetOfString.AddressResponse(1, new MapInnerListToSetOfString.AddressDTO(3, "WORK")));
        addressResponseSet.add(new MapInnerListToSetOfString.AddressResponse(2, new MapInnerListToSetOfString.AddressDTO(12, "OFFICE2")));
        return addressResponseSet;
    }

    public Set<MapInnerListToSetOfString.CustomerDTO> getCustomerDTO() {
        MapInnerListToSetOfString.CustomerDTO customerDTO = new MapInnerListToSetOfString.CustomerDTO(1);
        customerDTO.addAddress(new MapInnerListToSetOfString.AddressDTO(1, "HOME"));
        customerDTO.addAddress(new MapInnerListToSetOfString.AddressDTO(2, "OFFICE"));
        customerDTO.addAddress(new MapInnerListToSetOfString.AddressDTO(3, "WORK"));
        MapInnerListToSetOfString.CustomerDTO customerDTO2 = new MapInnerListToSetOfString.CustomerDTO(2);
        customerDTO2.addAddress(new MapInnerListToSetOfString.AddressDTO(11, "HOME2"));
        customerDTO2.addAddress(new MapInnerListToSetOfString.AddressDTO(12, "OFFICE2"));
        customerDTO2.addAddress(new MapInnerListToSetOfString.AddressDTO(13, "WORK2"));
        MapInnerListToSetOfString.CustomerDTO customerDTO3 = new MapInnerListToSetOfString.CustomerDTO(3);
        Set<MapInnerListToSetOfString.CustomerDTO> customerDTOSet = new HashSet<>();
        customerDTOSet.add(customerDTO);
        customerDTOSet.add(customerDTO2);
        customerDTOSet.add(customerDTO3);
        customerDTOSet.add(new MapInnerListToSetOfString.CustomerDTO(4));
        return customerDTOSet;
    }

    public class AddressResponse {
        private int addresponseId;
        private MapInnerListToSetOfString.AddressDTO addressDTO;

        public AddressResponse(int addresponseId, MapInnerListToSetOfString.AddressDTO addressDTO) {
            this.addresponseId = addresponseId;
            this.addressDTO = addressDTO;
        }

        public int getAddresponseId() {
            return addresponseId;
        }

        public void setAddresponseId(int addresponseId) {
            this.addresponseId = addresponseId;
        }

        public MapInnerListToSetOfString.AddressDTO getAddressDTO() {
            return addressDTO;
        }

        public void setAddressDTO(MapInnerListToSetOfString.AddressDTO addressDTO) {
            this.addressDTO = addressDTO;
        }

    }

    public class CustomerDTO {

        private int customerId;
        private Set<MapInnerListToSetOfString.AddressDTO> addressDto = new HashSet<>();

        public CustomerDTO(int customerId) {
            this.customerId = customerId;
        }

        public CustomerDTO() {

        }

        public MapInnerListToSetOfString.CustomerDTO getCustomerDTO(int customerId, MapInnerListToSetOfString.AddressDTO addressDto) {
            MapInnerListToSetOfString.CustomerDTO customerDTO = new MapInnerListToSetOfString.CustomerDTO();
            customerDTO.customerId = customerId;
            customerDTO.addressDto.add(addressDto);
            return customerDTO;
        }

        public void addAddress(MapInnerListToSetOfString.AddressDTO addressDto) {
            this.addressDto.add(addressDto);
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public Set<MapInnerListToSetOfString.AddressDTO> getAddressDto() {
            return addressDto;
        }

        public void setAddressDto(Set<MapInnerListToSetOfString.AddressDTO> addressDto) {
            this.addressDto = addressDto;
        }
    }

    public class AddressDTO {
        private int addressId;
        private String addressName;

        public AddressDTO(int addressId, String addressName) {
            this.addressId = addressId;
            this.addressName = addressName;
        }

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public String getAddressName() {
            return addressName;
        }

        public void setAddressName(String addressName) {
            this.addressName = addressName;
        }
    }
}

