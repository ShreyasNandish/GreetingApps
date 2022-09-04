package com.example.greetingapps.controller;

import com.example.greetingapps.DTO.GreetingDTO;
import com.example.greetingapps.model.GreetingData;
import com.example.greetingapps.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    private static final String template ="Hello , %s!";

    @Autowired
    private GreetingService greetingService;

    /**
     * UC1_curl -X GET "http://localhost:8080/greeting"
     * */
    @GetMapping("/greeting")
    public GreetingData getGreeting(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        return new GreetingData(String.format(template,name));
    }
    /**
     * Post: curl http://localhost:8080/greeting
     * */
    @PostMapping("/greeting")
    public GreetingData getGreeting(@RequestBody GreetingDTO data){
        GreetingData g=new GreetingData("Hi "+data.getFirstName()+".This is POST");
        return  g;
    }
    /**
     * Post : curl http://localhost:8080/greeting/hi (In request body passing JSON object)
     * */
    @PostMapping("/greeting/hi")
    public GreetingData getGreetingHi(@RequestBody GreetingDTO data){
        return new GreetingData(String.format(template,data.getLastName()));
    }

    /** Put: curl http://localhost:8080/greeting/put?name=Abhishek*/
    @PutMapping("/greeting/put")
    public GreetingData putGreeting(@RequestParam(value ="name")String name){
        return new GreetingData(String.format(template,name));
    }
    @GetMapping("/greet")
    public  GreetingData greeting(@RequestParam(value = "FirstName", defaultValue = "")String fname,
                                  @RequestParam(value = "LastName",defaultValue = "")String lname    )
    {
        GreetingDTO greetingData = new GreetingDTO();
        greetingData.setFirstName(fname);
        greetingData.setLastName(lname);

        return greetingService.getGreeting(greetingData);
    }


    /**
     * UC4
     * saves new greeting to database
     * this is POST call with UserData as RequestBody
     * */
    @PostMapping("/greetService")
    public GreetingData greeting(@RequestBody GreetingDTO greetingDTO)
    {
        return  greetingService.addGreeting(greetingDTO);
    }


    /**
     * UC5
     * gets the greeting with given id from database
     * this is GET call with id as PathVariable
     * */
    @GetMapping("/greetService/{id}")
    public GreetingData greeting(@PathVariable long id)
    {
        return  greetingService.getGreetingById(id);
    }


    /**
     * UC6
     * gets all greetings from database
     * this is GET call
     * */
    @GetMapping("/greetServices")
    public List<GreetingData> greetingFindAll()
    {
        return  greetingService.getAllGreetings();
    }

    /**
     * UC7
     * updates the greeting with given id in database
     * this is PUT call with new UserData and greeting_id
     * */
    @PutMapping("/greetService/{id}")
    public GreetingData greeting(@RequestBody GreetingDTO greetingDTO, @PathVariable long id)
    {
        return  greetingService.updateGreeting(greetingDTO,id);
    }

    /**
     * UC8
     * deletes the greeting with given id from database
     * this is DELETE call
     * */
    @DeleteMapping("/greetService/{id}")
    public String greetingDelete(@PathVariable long id)
    {
        greetingService.deleteGreeting(id);
        return "Delete Successful";
    }
}
