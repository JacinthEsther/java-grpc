package com.example;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookAuthorServerService extends BookAuthorServiceGrpc.BookAuthorServiceImplBase {

    @Override
    public void getBooksByAuthor(Author request, StreamObserver<Book> responseObserver) {
        super.getBooksByAuthor(request, responseObserver);
    }

    @Override
    public StreamObserver<Book> getExpensiveBook(StreamObserver<Book> responseObserver) {
        return super.getExpensiveBook(responseObserver);
    }

    @Override
    public StreamObserver<Book> getBooksByGender(StreamObserver<Book> responseObserver) {
        return super.getBooksByGender(responseObserver);
    }

    @Override
    public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
        TempDB.getAuthorsFromTempDb()
                .stream()
                .filter(author -> author.getAuthorId() == request.getAuthorId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }


}
