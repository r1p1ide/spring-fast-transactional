package com.example.springfasttransactional.service.impl;

import com.example.springfasttransactional.dto.CreateAccountDto;
import com.example.springfasttransactional.dto.TransferMoneyDto;
import com.example.springfasttransactional.dto.UpdateMoneyByIdDto;
import com.example.springfasttransactional.model.Account;
import com.example.springfasttransactional.repo.AccountRepository;
import com.example.springfasttransactional.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
    public void createAccount(CreateAccountDto dto) {

        log.info("Attempt to create account with parameters name={}, balance={}", dto.getName(), dto.getBalance());

        accountRepository.createAccount(new Account(dto.getName(), dto.getBalance()));

        log.info("Account with parameters name={}, balance={} successfully created", dto.getName(), dto.getBalance());
    }

    @Override
    @Transactional
    public void transferMoney(TransferMoneyDto dto) {

        BigDecimal sendersBalanceBeforeTransfer =
                accountRepository.getMoneyById(dto.getIdFrom());
        log.info("Sender's balance before transfer money {}", sendersBalanceBeforeTransfer);
        BigDecimal sendersBalanceAfterTransfer =
                sendersBalanceBeforeTransfer.subtract(dto.getMoney());
        log.info("Sender's balance after transfer money {}", sendersBalanceAfterTransfer);

        BigDecimal recipientsBalanceBeforeTransfer = accountRepository.getMoneyById(dto.getIdTo());
        log.info("Recipient's balance before transfer money {}", recipientsBalanceBeforeTransfer);
        BigDecimal recipientsBalanceAfterTransfer =
                accountRepository.getMoneyById(dto.getIdTo()).add(dto.getMoney());
        log.info("Recipient's balance after transfer money {}", recipientsBalanceAfterTransfer);

        accountRepository.updateMoneyById(new UpdateMoneyByIdDto(dto.getIdFrom(), sendersBalanceAfterTransfer));
        log.info("Sender's balance successfully updated in database");

        if (new Random().nextInt(4) == 3) {
            log.info("Test @Transactional");
            throw new RuntimeException("Random exception");
        }

        accountRepository.updateMoneyById(new UpdateMoneyByIdDto(dto.getIdTo(), recipientsBalanceAfterTransfer));
        log.info("Recipient's balance successfully updated in database");
    }

    // option with a transaction on the DB side
//    @Override
//    public void transferMoney(TransferMoneyDto dto) {
//
//        BigDecimal sendersBalanceBeforeTransfer = accountRepository.getMoneyById(dto.getIdFrom());
//        log.info("Sender's balance before transfer money {}", sendersBalanceBeforeTransfer);
//
//        BigDecimal recipientBalanceBeforeTransfer = accountRepository.getMoneyById(dto.getIdTo());
//        log.info("Recipient's balance before transfer money {}", recipientBalanceBeforeTransfer);
//
//        accountRepository.transferMoney(dto);
//
//        BigDecimal sendersBalanceAfterTransfer = accountRepository.getMoneyById(dto.getIdFrom());
//        log.info("Sender's balance after transfer money {}", sendersBalanceAfterTransfer);
//
//        BigDecimal recipientBalanceAfterTransfer = accountRepository.getMoneyById(dto.getIdTo());
//        log.info("Recipient's balance after transfer money {}", recipientBalanceAfterTransfer);
//    }


}
