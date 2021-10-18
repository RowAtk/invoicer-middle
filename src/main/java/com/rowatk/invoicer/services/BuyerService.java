package com.rowatk.invoicer.services;

import com.rowatk.invoicer.dto.model.BuyerDTO;
import com.rowatk.invoicer.models.company.Buyer;
import com.rowatk.invoicer.respositories.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService extends CompanyService<Buyer, BuyerDTO> {

    public BuyerService() {
        super("buyer");
    }

    public List<BuyerDTO> findByUserId(Long id) {
        System.out.println(((BuyerRepository) repository).findByUserId(id));
        return mapper.entitiesToDTOs( ((BuyerRepository) repository).findByUserId(id) );
    }
}
