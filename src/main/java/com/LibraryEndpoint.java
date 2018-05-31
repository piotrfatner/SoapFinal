package com;

import generated.LibraryRequest;
import generated.LibraryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LibraryEndpoint {
    private static final String NAMESPACE_URI = "http://www.examples.com/wsdl/HelloService.wsdl";

    private LibraryRepository LibraryRepository;

    @Autowired
    public LibraryEndpoint(LibraryRepository LibraryRepository) {
        this.LibraryRepository = LibraryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LibraryRequest")
    @ResponsePayload
    public LibraryResponse getBook(@RequestPayload LibraryRequest request) {
        LibraryResponse response = new LibraryResponse();
        response.setBook(LibraryRepository.findBook(request.getName()));

        return response;
    }
}
