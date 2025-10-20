package com.dev_renan01.sistema_funcionarios_setores.repository;

import com.dev_renan01.sistema_funcionarios_setores.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
}
