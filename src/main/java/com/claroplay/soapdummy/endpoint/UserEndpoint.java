package com.claroplay.soapdummy.endpoint;

import java.util.Properties;

import com.claroplay.soapdummy.samples.GetUserRequest;
import com.claroplay.soapdummy.samples.GetUserResponse;
import com.claroplay.soapdummy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;
	Properties prop = new Properties();


    @PayloadRoot(namespace = "http://prd.imiclaro.com/mocks",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}
