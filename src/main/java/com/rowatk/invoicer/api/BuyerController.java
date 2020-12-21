package com.rowatk.invoicer.api;

import com.rowatk.invoicer.models.entity.Buyer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/buyers")
public class BuyerController extends EntityController<Buyer> {

}
