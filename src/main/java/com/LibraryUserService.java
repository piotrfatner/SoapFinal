package com;

import generated.Book;
import generated.LibraryResponse;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserService {

    public LibraryResponse getBookByTitle(LibraryRepository libraryRepository, String title){
        LibraryResponse response = new LibraryResponse();
        response.setBook(libraryRepository.findBook(title));
        return response;
    }

    public LibraryResponse rentBookByTitle(LibraryRepository libraryRepository, String title){
        LibraryResponse response = new LibraryResponse();
        response.setBook(libraryRepository.rentBook(title));
        return response;
    }

    public LibraryResponse rentBackBookByTitle(LibraryRepository libraryRepository, String title){
        LibraryResponse response = new LibraryResponse();
        response.setBook(libraryRepository.rentBackBook(title));
        return response;
    }
}
