package in.rahul.springboot.restapitest.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        String message = "Hello Rest Testing!";
        try{
            InetAddress ip = InetAddress.getLocalHost();
            message += " From host: " + ip;
        } catch (UnknownHostException e){
            e.printStackTrace();
        }
        return message;
    }
}
