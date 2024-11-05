package CustomerDatabaseManagement.service;

import CustomerDatabaseManagement.dto.CustomerDTO;

import java.util.List;

public class PaginatedResponse {
    private List<CustomerDTO> customers;
    private int totalPages;

    public PaginatedResponse(List<CustomerDTO> customers, int totalPages) {
        this.customers = customers;
        this.totalPages = totalPages;
    }

    public List<CustomerDTO> getCustomers() {
        return customers;
    }

    public int getTotalPages() {
        return totalPages;
    }
}