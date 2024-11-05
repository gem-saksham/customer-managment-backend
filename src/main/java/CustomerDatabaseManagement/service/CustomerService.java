package CustomerDatabaseManagement.service;

import CustomerDatabaseManagement.controller.BaseResponse;
import CustomerDatabaseManagement.dto.*;
import CustomerDatabaseManagement.entity.*;
import CustomerDatabaseManagement.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Autowired
    private CustomerSubjectRepository customerSubjectRepository;

    @Autowired
    private CustomerMarketRepository customerMarketRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Helper method for DTO to Entity mapping using ModelMapper
    private <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    // Helper method for Entity to DTO mapping using ModelMapper
    private <E, D> D convertToDTO(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    // Existing POST Methods
    public BaseResponse addCustomer(CustomerDTO customerDTO) {
        Optional<Customer> existingCustomer = customerRepository.findByCustomerNameOrOfficialEmailOrGstNo(
                customerDTO.getCustomerName(), customerDTO.getOfficialEmail(), customerDTO.getGstNo());

        if (existingCustomer.isPresent()) {
            return new BaseResponse("Customer already exists", HttpStatus.CONFLICT, null);
        }

        Customer customer = new Customer();
        customerDTO.setCustomerId(customer.getCustomerId());
        modelMapper.map(customerDTO, customer);
        Customer result = customerRepository.save(customer);
        return new BaseResponse("Customer created", HttpStatus.CREATED, result);
    }

    public BaseResponse addCustomerContact(CustomerContactDTO customerContactDTO) {
        Optional<CustomerContact> existingContact = customerContactRepository
                .findByOfficialEmail(customerContactDTO.getOfficialEmail());

        if (existingContact.isPresent()) {
            return new BaseResponse("Customer contact already exists", HttpStatus.CONFLICT, null);
        }

        CustomerContact contact =  new CustomerContact();
        customerContactDTO.setCustomerContactID(contact.getCustomerContactID());
        modelMapper.map(customerContactDTO, contact);

        if (customerContactDTO.getRoleInput() != null && customerContactDTO.getRole().equals("Others")
                                               && !customerContactDTO.getRoleInput().isEmpty()) {
           contact.setRole(customerContactDTO.getRoleInput());
        }
        CustomerContact result = customerContactRepository.save(contact);
        return new BaseResponse("Customer contact created", HttpStatus.CREATED, result);
    }

    public BaseResponse updateCustomerContact(Long customerContactID, CustomerContactDTO customerContactDTO) {
        Optional<CustomerContact> existingContact = customerContactRepository.findByCustomerContactID(customerContactID);

        if (existingContact.isEmpty()) {
            return new BaseResponse("Customer contact not found", HttpStatus.NOT_FOUND, null);
        }

        CustomerContact contactToUpdate = existingContact.get();
        modelMapper.map(customerContactDTO, contactToUpdate); // Map the DTO fields to the existing contact entity

        // Handle role input if the role is 'Others'
        if (customerContactDTO.getRoleInput() != null && customerContactDTO.getRole().equals("Others")
                && !customerContactDTO.getRoleInput().isEmpty()) {
            contactToUpdate.setRole(customerContactDTO.getRoleInput());
        }

        CustomerContact updatedContact = customerContactRepository.save(contactToUpdate);
        return new BaseResponse("Customer contact updated successfully", HttpStatus.OK, updatedContact);
    }





    public BaseResponse addCustomerSubject(CustomerSubjectDTO customerSubjectDTO) {
        Optional<CustomerSubject> existingSubject = customerSubjectRepository.findByCustomerIdAndSubjectNameAndSubjectNameSubCategory(
                customerSubjectDTO.getCustomerId(),customerSubjectDTO.getSubjectName(), customerSubjectDTO.getSubjectNameSubCategory());

        if (existingSubject.isPresent()) {
            return new BaseResponse("Customer subject and subcategory already exists for the customer", HttpStatus.CONFLICT, null);
        }

        CustomerSubject subject = new CustomerSubject();
        customerSubjectDTO.setCustomerSubjectID(subject.getCustomerSubjectID());
        modelMapper.map(customerSubjectDTO, subject);
        CustomerSubject result = customerSubjectRepository.save(subject);
        return new BaseResponse("Customer subject created", HttpStatus.CREATED, result);
    }

    public BaseResponse addCustomerMarket(CustomerMarketDTO customerMarketDTO) {
        Optional<CustomerMarket> existingMarket = customerMarketRepository.findByCustomerIdAndCustomerMarketAndCustomerMarketSubCategory(
                customerMarketDTO.getCustomerId(), customerMarketDTO.getCustomerMarket(), customerMarketDTO.getCustomerMarketSubCategory());

        if (existingMarket.isPresent()) {
            return new BaseResponse("Customer market and subcategory  already exists for the customer", HttpStatus.CONFLICT, null);
        }

        CustomerMarket market = new CustomerMarket();
        customerMarketDTO.setCustomerMarketID(market.getCustomerMarketID());
        modelMapper.map(customerMarketDTO, market);
        CustomerMarket result = customerMarketRepository.save(market);
        return new BaseResponse("Customer market created", HttpStatus.CREATED, result);
    }

    public BaseResponse addCustomerOrder(CustomerOrderDTO customerOrderDTO) {


        CustomerOrder order = new CustomerOrder();
        customerOrderDTO.setCustomerOrderID(order.getCustomerOrderID());
        modelMapper.map(customerOrderDTO, order);
        CustomerOrder result = customerOrderRepository.save(order);
        return new BaseResponse("Customer order created", HttpStatus.CREATED, result);
    }

    // New GET Methods by Customer ID

    public BaseResponse getCustomerContactsByCustomerId(Long customerId) {
        List<CustomerContact> contacts = customerContactRepository.findByCustomerId(customerId);
        if (contacts.isEmpty()) {
            return new BaseResponse("No customer contacts found", HttpStatus.OK, null);
        }
        List<CustomerContactDTO> contactDTOs = contacts.stream()
                .map(contact -> convertToDTO(contact, CustomerContactDTO.class))
                .collect(Collectors.toList());
        return new BaseResponse("Customer contacts retrieved", HttpStatus.OK, contactDTOs);
    }

    public BaseResponse getCustomerMarketsByCustomerId(Long customerId) {
        List<CustomerMarket> markets = customerMarketRepository.findByCustomerId(customerId);
        if (markets.isEmpty()) {
            return new BaseResponse("No customer markets found", HttpStatus.OK, null);
        }
        List<CustomerMarketDTO> marketDTOs = markets.stream()
                .map(market -> convertToDTO(market, CustomerMarketDTO.class))
                .collect(Collectors.toList());
        return new BaseResponse("Customer markets retrieved", HttpStatus.OK, marketDTOs);
    }

    public BaseResponse getCustomerSubjectsByCustomerId(Long customerId) {
        List<CustomerSubject> subjects = customerSubjectRepository.findByCustomerId(customerId);
        if (subjects.isEmpty()) {
            return new BaseResponse("No customer subjects found", HttpStatus.OK, null);
        }
        List<CustomerSubjectDTO> subjectDTOs = subjects.stream()
                .map(subject -> convertToDTO(subject, CustomerSubjectDTO.class))
                .collect(Collectors.toList());
        return new BaseResponse("Customer subjects retrieved", HttpStatus.OK, subjectDTOs);
    }

    public BaseResponse getCustomerOrdersByCustomerId(Long customerId) {
        List<CustomerOrder> orders = customerOrderRepository.findByCustomerId(customerId);
        if (orders.isEmpty()) {
            return new BaseResponse("No customer orders found", HttpStatus.NOT_FOUND, null);
        }
        List<CustomerOrderDTO> orderDTOs = orders.stream()
                .map(order -> convertToDTO(order, CustomerOrderDTO.class))
                .collect(Collectors.toList());
        return new BaseResponse("Customer orders retrieved", HttpStatus.OK, orderDTOs);
    }



    public BaseResponse searchCustomers(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "lastModifiedDate")); // Sort by createdDate in descending order
        Page<Customer> customerPage = customerRepository
                .findByCustomerNameContainingOrOfficialEmailContainingOrCustomerAbbreviationContainingOrStateContainingOrCountryContainingOrCityContaining(
                searchTerm, searchTerm, searchTerm,  searchTerm,  searchTerm, searchTerm, pageable);



        List<CustomerDTO> customerDTOs = customerPage.stream()
                .map(customer -> convertToDTO(customer, CustomerDTO.class))
                .collect(Collectors.toList());

        return new BaseResponse("Customers retrieved", HttpStatus.OK, new PaginatedResponse(customerDTOs, customerPage.getTotalPages()));
    }

    public BaseResponse updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);

        if (existingCustomer.isEmpty()) {
            return new BaseResponse("Customer not found", HttpStatus.NOT_FOUND, null);
        }



        Customer customerToUpdate = existingCustomer.get();
        modelMapper.map(customerDTO, customerToUpdate); // Update fields from DTO
        Customer updatedCustomer = customerRepository.save(customerToUpdate); // Save updated customer

        return new BaseResponse("Customer updated successfully", HttpStatus.OK, updatedCustomer);
    }




        public BaseResponse deleteCustomerContact(Long customerContactID) {
            Optional<CustomerContact> existingContact = customerContactRepository.findByCustomerContactID(customerContactID);
            if (existingContact.isEmpty()) {
                return new BaseResponse("Customer contact not found", HttpStatus.NOT_FOUND, null);
            }
            customerContactRepository.delete(existingContact.get());
            return new BaseResponse("Customer contact deleted successfully", HttpStatus.OK, null);
        }

        public BaseResponse deleteCustomerMarket(Long customerId, String market, String marketSubCategory) {
            Optional<CustomerMarket> existingMarket = customerMarketRepository
                    .findByCustomerIdAndCustomerMarketAndCustomerMarketSubCategory(customerId, market, marketSubCategory);
            if (existingMarket.isEmpty()) {
                return new BaseResponse("Customer market not found", HttpStatus.NOT_FOUND, null);
            }
            customerMarketRepository.delete(existingMarket.get());
            return new BaseResponse("Customer market deleted successfully", HttpStatus.OK, null);
        }

        public BaseResponse deleteCustomerSubject(Long customerId, String subjectName, String subjectCategory) {
            Optional<CustomerSubject> existingSubject = customerSubjectRepository
                    .findByCustomerIdAndSubjectNameAndSubjectNameSubCategory(customerId, subjectName, subjectCategory );
            if (existingSubject.isEmpty()) {
                return new BaseResponse("Customer subject not found", HttpStatus.NOT_FOUND, null);
            }
            customerSubjectRepository.delete(existingSubject.get());
            return new BaseResponse("Customer subject deleted successfully", HttpStatus.OK, null);
        }








}
