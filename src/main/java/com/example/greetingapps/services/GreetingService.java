package com.example.greetingapps.services;

import com.example.greetingapps.DTO.GreetingDTO;
import com.example.greetingapps.model.GreetingData;
import com.example.greetingapps.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public GreetingData getGreeting(GreetingDTO greetingDTO) {
        GreetingData greeting = new GreetingData("Hello "+greetingDTO.getFirstName()+" "+greetingDTO.getLastName());
        return greeting;
    }


    public GreetingData addGreeting(GreetingDTO greetingDTO){
        String message = "Hello " + greetingDTO.getLastName() +" "+greetingDTO.getFirstName();
        GreetingData greeting=new GreetingData(greetingDTO,message);
        return greetingRepository.save(greeting);
    }

    public GreetingData getGreetingById(long id)
    {
        GreetingData greeting=greetingRepository.findById(id).get();
        return greeting;
    }

    public List<GreetingData> getAllGreetings()
    {
        List<GreetingData> greetings= greetingRepository.findAll();
        return  greetings;
    }

    public GreetingData updateGreeting(GreetingDTO greetingDTO,long id) {
        GreetingData greeting = greetingRepository.findById(id).get();

        String message = "Hello " + greetingDTO.getLastName() +" "+greetingDTO.getFirstName();

        greeting.setMessage(message);
        GreetingData greetingUpdated = greetingRepository.save(greeting);
        return greetingUpdated;
    }

    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }
}