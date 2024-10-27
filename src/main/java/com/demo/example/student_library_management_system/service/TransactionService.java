package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converters.TransactionConverter;
import com.demo.example.student_library_management_system.dto.TransactionRequestDto;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.repository.BookRepository;
import com.demo.example.student_library_management_system.repository.CardRepository;
import com.demo.example.student_library_management_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    public String addTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = TransactionConverter.convertTransactionRequestDtoToTransaction(transactionRequestDto);

        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setBook(book);

        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        transaction.setCard(card);

        transactionRepository.save(transaction);
        return "Transaction saved successfully";
    }
}
