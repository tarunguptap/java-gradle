package com.example.java8feature.innercollection;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

public class SetOfSetToFlatSetUsingFlatMap {

    public static void main(String[] args) {
        SetOfSetToFlatSetUsingFlatMap s = new SetOfSetToFlatSetUsingFlatMap();
        Set<CustomerDTO> customerDTOSet = s.getCustomerDTO();

        Predicate<CustomerDTO> customerFilter = customerDTO -> CollectionUtils.isNotEmpty(customerDTO.getAddressDto());
        Set<String> addressType = customerDTOSet.stream().filter(customerFilter)
                .flatMap(customerDTO -> customerDTO.getAddressDto().stream()).map(AddressDTO::getAddressName)
                .collect(Collectors.toSet());
        System.out.println(addressType);

    }

    public Set<AddressResponse> getAddressResponse() {
        Set<AddressResponse> addressResponseSet = new HashSet<>();
        addressResponseSet.add(new AddressResponse(1, new AddressDTO(3, "WORK")));
        addressResponseSet.add(new AddressResponse(2, new AddressDTO(12, "OFFICE2")));
        return addressResponseSet;
    }

    public Set<CustomerDTO> getCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO(1);
        customerDTO.addAddress(new AddressDTO(1, "HOME"));
        customerDTO.addAddress(new AddressDTO(2, "OFFICE"));
        customerDTO.addAddress(new AddressDTO(3, "WORK"));
        CustomerDTO customerDTO2 = new CustomerDTO(2);
        customerDTO2.addAddress(new AddressDTO(11, "HOME2"));
        customerDTO2.addAddress(new AddressDTO(12, "OFFICE2"));
        customerDTO2.addAddress(new AddressDTO(13, "WORK2"));
        CustomerDTO customerDTO3 = new CustomerDTO(3);
        Set<CustomerDTO> customerDTOSet = new HashSet<>();
        customerDTOSet.add(customerDTO);
        customerDTOSet.add(customerDTO2);
        customerDTOSet.add(customerDTO3);
        customerDTOSet.add(new CustomerDTO(4));
        return customerDTOSet;
    }

    public class AddressResponse {
        private int addresponseId;
        private AddressDTO addressDTO;

        public AddressResponse(int addresponseId, AddressDTO addressDTO) {
            this.addresponseId = addresponseId;
            this.addressDTO = addressDTO;
        }

        public int getAddresponseId() {
            return addresponseId;
        }

        public void setAddresponseId(int addresponseId) {
            this.addresponseId = addresponseId;
        }

        public AddressDTO getAddressDTO() {
            return addressDTO;
        }

        public void setAddressDTO(AddressDTO addressDTO) {
            this.addressDTO = addressDTO;
        }

    }

    public class CustomerDTO {

        private int customerId;
        private Set<AddressDTO> addressDto = new HashSet<>();

        public CustomerDTO(int customerId) {
            this.customerId = customerId;
        }

        public CustomerDTO() {

        }

        public CustomerDTO getCustomerDTO(int customerId, AddressDTO addressDto) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.customerId = customerId;
            customerDTO.addressDto.add(addressDto);
            return customerDTO;
        }

        public void addAddress(AddressDTO addressDto) {
            this.addressDto.add(addressDto);
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public Set<AddressDTO> getAddressDto() {
            return addressDto;
        }

        public void setAddressDto(Set<AddressDTO> addressDto) {
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
