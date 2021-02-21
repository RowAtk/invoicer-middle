package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.dto.model.BuyerDTO;
import com.rowatk.invoicer.models.company.Buyer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyers")
public class BuyerController extends CompanyController<Buyer, BuyerDTO> {
}
