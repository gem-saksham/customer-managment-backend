package CustomerDatabaseManagement.controller;

import CustomerDatabaseManagement.Constants;
import CustomerDatabaseManagement.dto.*;
import CustomerDatabaseManagement.entity.*;
import CustomerDatabaseManagement.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // POST methods using DTOs

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to save the customer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer details saved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "409", description = "Customer already exists in the records")
    })
    public ResponseEntity<BaseResponse> addCustomer(@RequestBody final CustomerDTO customerDTO) {
        BaseResponse response = customerService.addCustomer(customerDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(path = "/contact", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to save the customer contact details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer contact details saved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerContact.class))}),
            @ApiResponse(responseCode = "409", description = "Customer contact already exists in the records")
    })
    public ResponseEntity<BaseResponse> addCustomerContact(@RequestBody final CustomerContactDTO customerContactDTO) {
        BaseResponse response = customerService.addCustomerContact(customerContactDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(path = "/market", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to save the customer market details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer market details saved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerMarket.class))}),
            @ApiResponse(responseCode = "409", description = "Customer market already exists in the records")
    })
    public ResponseEntity<BaseResponse> addCustomerMarket(@RequestBody final CustomerMarketDTO customerMarketDTO) {
        BaseResponse response = customerService.addCustomerMarket(customerMarketDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(path = "/subject", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to save the customer subject details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer subject details saved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerSubject.class))}),
            @ApiResponse(responseCode = "409", description = "Customer subject already exists in the records")
    })
    public ResponseEntity<BaseResponse> addCustomerSubject(@RequestBody final CustomerSubjectDTO customerSubjectDTO) {
        BaseResponse response = customerService.addCustomerSubject(customerSubjectDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(path = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to save the customer order details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer order details saved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrder.class))}),
            @ApiResponse(responseCode = "409", description = "Customer order already exists in the records")
    })
    public ResponseEntity<BaseResponse> addCustomerOrder(@RequestBody final CustomerOrderDTO customerOrderDTO) {
        BaseResponse response = customerService.addCustomerOrder(customerOrderDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // GET methods remain the same for retrieving data by customer ID

    @GetMapping(path = "/contacts/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get customer contacts by customer ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer contacts retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerContact.class))}),
            @ApiResponse(responseCode = "404", description = "No customer contacts found for the given customer ID")
    })
    public ResponseEntity<BaseResponse> getCustomerContactsByCustomerId(@PathVariable Long customerId) {
        BaseResponse response = customerService.getCustomerContactsByCustomerId(customerId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(path = "/markets/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get customer markets by customer ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer markets retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerMarket.class))}),
            @ApiResponse(responseCode = "404", description = "No customer markets found for the given customer ID")
    })
    public ResponseEntity<BaseResponse> getCustomerMarketsByCustomerId(@PathVariable Long customerId) {
        BaseResponse response = customerService.getCustomerMarketsByCustomerId(customerId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(path = "/subjects/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get customer subjects by customer ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer subjects retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerSubject.class))}),
            @ApiResponse(responseCode = "404", description = "No customer subjects found for the given customer ID")
    })
    public ResponseEntity<BaseResponse> getCustomerSubjectsByCustomerId(@PathVariable Long customerId) {
        BaseResponse response = customerService.getCustomerSubjectsByCustomerId(customerId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(path = "/orders/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get customer orders by customer ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer orders retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrder.class))}),
            @ApiResponse(responseCode = "404", description = "No customer orders found for the given customer ID")
    })
    public ResponseEntity<BaseResponse> getCustomerOrdersByCustomerId(@PathVariable Long customerId) {
        BaseResponse response = customerService.getCustomerOrdersByCustomerId(customerId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Existing GET methods for constants like roles, subjects, markets, and academic data remain unchanged

    @GetMapping(path = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get the types of roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Roles retrieved",
                    content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<BaseResponse> getRoles() {
        BaseResponse response = new BaseResponse("Roles retrieved", HttpStatus.OK, Constants.roles);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(path = "/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get the subjects map")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subjects map retrieved",
                    content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<BaseResponse> getSubjectMap() {
        BaseResponse response = new BaseResponse("Subjects retrieved", HttpStatus.OK, Constants.subjectMap);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(path = "/markets", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get the markets map")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Markets map retrieved",
                    content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<BaseResponse> getMarketMap() {
        BaseResponse response = new BaseResponse("Markets retrieved", HttpStatus.OK, Constants.marketMap);
        return ResponseEntity.status(response.getStatus()).body(response);
    }


    @GetMapping(path = "/academic", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to get the academic map")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Academic map retrieved",
                    content = {@Content(mediaType = "application/json")})
    })
    public ResponseEntity<BaseResponse> getAcademicMap() {
        BaseResponse response = new BaseResponse("Academic map retrieved", HttpStatus.OK, Constants.academicMap);
        return ResponseEntity.status(response.getStatus()).body(response);
    }




    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to search customers by name or email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customers retrieved",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "No customers found for the given search criteria")
    })
    public ResponseEntity<BaseResponse> searchCustomers(
            @RequestParam String searchTerm,
            @RequestParam int page,
            @RequestParam int size) {
        BaseResponse response = customerService.searchCustomers(searchTerm, page, size);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping(path = "/update/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to update the customer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer details updated",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "409", description = "Customer already exists in the records")
    })
    public ResponseEntity<BaseResponse> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) {
        BaseResponse response = customerService.updateCustomer(customerId, customerDTO);
        return ResponseEntity.status(response.getStatus()).body(response);
    }


    @PutMapping("/contact/update/{customerContactID}")
    @Operation(summary = "API to update the customer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer contact details updated",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
    })
    public ResponseEntity<BaseResponse> updateCustomerContact(
            @PathVariable Long customerContactID,
            @RequestBody CustomerContactDTO customerContactDTO) {
        BaseResponse response = customerService.updateCustomerContact(customerContactID, customerContactDTO);
        return new ResponseEntity<>(response, response.getStatus());
    }


    // DELETE methods for removing customer market and subject

    @DeleteMapping(path = "/market/{customerId}/{market}/{marketSubCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to delete a customer market")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer market deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer market not found")
    })
    public ResponseEntity<BaseResponse> deleteCustomerMarket(
            @PathVariable Long customerId,
            @PathVariable String market,
            @PathVariable String marketSubCategory) {
        BaseResponse response = customerService.deleteCustomerMarket(customerId, market, marketSubCategory);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping(path = "/subject/{customerId}/{subjectName}/{subjectCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to delete a customer subject")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer subject deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer subject not found")
    })
    public ResponseEntity<BaseResponse> deleteCustomerSubject(
            @PathVariable Long customerId,
            @PathVariable String subjectName,
            @PathVariable String subjectCategory) {
        BaseResponse response = customerService.deleteCustomerSubject(customerId, subjectName, subjectCategory);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping(path = "/contact/{customerContactID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "API to delete a customer contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer contact deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer contact not found")
    })
    public ResponseEntity<BaseResponse> deleteCustomerContact(@PathVariable Long customerContactID) {
        BaseResponse response = customerService.deleteCustomerContact(customerContactID);
        return ResponseEntity.status(response.getStatus()).body(response);
    }







}
