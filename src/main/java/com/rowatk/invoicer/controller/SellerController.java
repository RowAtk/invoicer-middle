package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.dto.model.SellerDTO;
import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
public class SellerController extends EntityController<Seller, SellerDTO>{

}
