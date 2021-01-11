package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyers")
public class BuyerController extends EntityController<Buyer> {

}
