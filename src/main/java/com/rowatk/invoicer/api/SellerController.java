package com.rowatk.invoicer.api;

import com.rowatk.invoicer.models.entity.Seller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sellers")
public class SellerController extends EntityController<Seller>{

}
