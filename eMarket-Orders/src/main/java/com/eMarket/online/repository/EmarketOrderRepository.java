package com.eMarket.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eMarket.online.model.EmarketOrder;

@RepositoryRestResource
public interface EmarketOrderRepository extends JpaRepository<EmarketOrder, Integer>{

}
