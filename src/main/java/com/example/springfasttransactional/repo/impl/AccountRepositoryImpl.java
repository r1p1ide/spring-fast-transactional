package com.example.springfasttransactional.repo.impl;

import com.example.springfasttransactional.dto.TransferMoneyDto;
import com.example.springfasttransactional.dto.UpdateMoneyByIdDto;
import com.example.springfasttransactional.model.Account;
import com.example.springfasttransactional.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import java.math.BigDecimal;
import java.util.List;

import static com.example.springfasttransactional.util.strings.SqlStrings.*;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> getAllAccounts() {
        return jdbcTemplate.query(GET_ALL_ACCOUNTS_SQL, (rs, rowNum) ->
            new Account(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBigDecimal("balance")));
    }

    @Override
    public void createAccount(Account account) {
        jdbcTemplate.update(CREATE_ACCOUNT_SQL, account.getName(), account.getBalance());
    }

    @Override
    public BigDecimal getMoneyById(int id) {
        return jdbcTemplate.queryForObject(
                GET_MONEY_BY_ID_SQL,
                (rs, rowMap) -> rs.getBigDecimal("balance"),
                id);
    }

    @Override
    public void updateMoneyById(UpdateMoneyByIdDto dto) {
        jdbcTemplate.update(UPDATE_MONEY_SQL, dto.getMoney(), dto.getId());
    }

    // option with a transaction on the DB side
//    @Override
//    public void updateMoneyById(UpdateMoneyByIdDto dto) {
//        jdbcTemplate.update(UPDATE_MONEY_SQL, dto.getId(), dto.getMoney());
//    }
//
//    @Override
//    public void transferMoney(TransferMoneyDto dto) {
//        jdbcTemplate.update(TRANSFER_MONEY_SQL, dto.getIdFrom(), dto.getIdTo(), dto.getMoney());
//    }
}
