package com.Microservice.Admin.service;

import com.Microservice.Admin.model.AddOnsModel;
import com.Microservice.Admin.repository.AddOnsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddOnService {
    @Autowired
    private AddOnsRepository addOnsRepository;

    public void save (AddOnsModel addOnsModel){
        addOnsRepository.save(addOnsModel);
    }

    public List<AddOnsModel> findAll(){
        List<AddOnsModel> addOnsList = addOnsRepository.findAll();
        if(addOnsList.size()>0){
            return addOnsList;
        }
        return null;
    }

    public void edit(AddOnsModel addOnsModel,String id){
        AddOnsModel addon = addOnsRepository.findById(id).get();
        if(addon==null){
            return;
        }
        if(addOnsModel.getCost()!=0){
            addon.setCost(addOnsModel.getCost());
        }
        if(addOnsModel.getAddon()!=null){
            addon.setAddon(addOnsModel.getAddon());
        }
        addOnsModel.setActive(addOnsModel.isActive());
    }
    public String deleteById(String id){
        if(addOnsRepository.findById(id).isPresent()){
            addOnsRepository.deleteById(id);
            return "Successfully Deleted";
        }
        return "Could not any Item";
    }

}
