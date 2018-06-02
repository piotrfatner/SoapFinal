package com;

import generated.LibraryResponse;
import org.springframework.stereotype.Service;

@Service
public class LibraryEmployeeService {
    public LibraryResponse changeBookAuthor(LibraryRepository libraryRepository, String name, String newAuthor){
        LibraryResponse response = new LibraryResponse();
        response.setBook(libraryRepository.changeBookAuthor(name,newAuthor));
        return response;
    }

    public LibraryResponse changeBookTitle(LibraryRepository libraryRepository, String name, String newTitle){
        LibraryResponse response = new LibraryResponse();
        response.setBook(libraryRepository.changeBookTitle(name,newTitle));
        return response;
    }
}
