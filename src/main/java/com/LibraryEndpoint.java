package com;

import generated.LibraryRequest;
import generated.LibraryRequest2;
import generated.LibraryRequest3;
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

    @Autowired
    LibraryUserService libraryUserService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LibraryRequest")
    @ResponsePayload
    public LibraryResponse getBook(@RequestPayload LibraryRequest request) {

        return libraryUserService.getBookByTitle(LibraryRepository, request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LibraryRequest2")
    @ResponsePayload
    public LibraryResponse rentBook(@RequestPayload LibraryRequest2 request) {
        return libraryUserService.rentBookByTitle(LibraryRepository, request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LibraryRequest3")
    @ResponsePayload
    public LibraryResponse rentBackBook(@RequestPayload LibraryRequest3 request) {
        return libraryUserService.rentBackBookByTitle(LibraryRepository, request.getName());
    }

}
