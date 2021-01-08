package com.kritter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EstateService {
    // to automatically allow spring to inject the object of EstateRepository we specify autowired
    // With the help of EstateRepository Interface we can easily do CRUD operations
    @Autowired
    private EstateRepository repo;

    //To list all estates
    public List<Estate> listAll(){
        return repo.findAll();
    }

    public void save(Estate estate){
        repo.save(estate);
    }

    public Estate get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
