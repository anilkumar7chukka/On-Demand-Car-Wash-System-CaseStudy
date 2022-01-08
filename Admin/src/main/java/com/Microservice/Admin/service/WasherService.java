package com.Microservice.Admin.service;

import com.Microservice.Admin.model.PromoModel;
import com.Microservice.Admin.model.WasherModel;
import com.Microservice.Admin.repository.WasherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasherService {
    @Autowired
    private WasherRepository washerRepository;
    public List<WasherModel> findAll(){
        List<WasherModel> washerList = washerRepository.findAll();
        if(washerList.size()>0){
            return washerList;
        }
        return null;
    }

    public String deleteById(String id){
        if(washerRepository.findById(id).isPresent()){
            washerRepository.deleteById(id);
            return "Successfully Deleted";
        }
        return "Could not Find any Item";
    }
}
