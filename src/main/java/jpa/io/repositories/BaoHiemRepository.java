package jpa.io.repositories;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import jpa.io.entities.BaoHiem;

public interface BaoHiemRepository extends JpaRepository<BaoHiem, Integer>{

}
