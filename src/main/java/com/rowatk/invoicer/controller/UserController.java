package com.rowatk.invoicer.controller;

import com.rowatk.invoicer.dto.model.UserDTO;
import com.rowatk.invoicer.dto.responses.ApiResponse;
import com.rowatk.invoicer.dto.responses.ApiResponseFactory;
import com.rowatk.invoicer.dto.responses.GeneralResponse;
import com.rowatk.invoicer.models.company.User;
import com.rowatk.invoicer.services.BuyerService;
import com.rowatk.invoicer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends CompanyController<User, UserDTO> {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/name/{username}")
    public ResponseEntity<ApiResponse> findByUsername(@PathVariable("username") String username) {
        return ApiResponseFactory.ok( ((UserService) this.companyService).findByUsername(username) );
    }

    @GetMapping("/{id}/buyers")
    public ResponseEntity<ApiResponse> findBuyersByUserId(@PathVariable("id") Long id) {
        System.out.println(buyerService.findByUserId(id));
        return ApiResponseFactory.ok( new GeneralResponse("buyers", buyerService.findByUserId(id)));
    }
}
