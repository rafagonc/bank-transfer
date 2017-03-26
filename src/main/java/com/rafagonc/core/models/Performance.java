package com.rafagonc.core.models;

import com.rafagonc.core.repository.PerformanceRepository;
import com.rafagonc.core.result.BankTransfer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by rafagonc on 26/03/17.
 */
@Entity
public class Performance implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    public Integer cpf;

    @Column(nullable = false)
    public Integer name;

    @Column(nullable = false)
    public Integer account;

    @Column(nullable = false)
    public Integer agency;

    @Column(nullable = false)
    public Integer bank;

    @Column(nullable = false)
    public Integer value;

    @Column(nullable = false)
    public Integer count;

    public Performance() {

    }

    public static void analyze(BankTransfer bankTransfer, PerformanceRepository repository) {
        List<Performance> list = repository.listAll();
        if (list.size() > 0) {
            Performance performance = repository.listAll().get(0);
            if (bankTransfer.getCpf() != null) performance.cpf += 1;
            if (bankTransfer.getName() != null) performance.name += 1;
            if (bankTransfer.getAccount() != null) performance.account += 1;
            if (bankTransfer.getAgency() != null) performance.agency += 1;
            if (bankTransfer.getValue() != null) performance.value += 1;
            if (bankTransfer.getBank() != null) performance.bank += 1;
            performance.count += 1;
            repository.save(performance);
        } else {
            Performance performance = new Performance();
            performance.cpf = bankTransfer.getCpf() != null ? 1 : 0;
            performance.name = bankTransfer.getName() != null ? 1 : 0;;
            performance.account = bankTransfer.getAccount() != null ? 1 : 0;;
            performance.agency = bankTransfer.getAgency() != null ? 1 : 0;;
            performance.bank = bankTransfer.getBank() != null ? 1 : 0;;
            performance.value = bankTransfer.getValue() != null ? 1 : 0;;
            performance.count = 1;
            repository.save(performance);
        }
    }

}
