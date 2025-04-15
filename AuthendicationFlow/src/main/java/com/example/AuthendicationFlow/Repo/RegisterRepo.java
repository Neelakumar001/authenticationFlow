package com.example.AuthendicationFlow.Repo;

import com.example.AuthendicationFlow.Model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register,Long> {
    Register findByEmailIdAndPassword(String emailId, String password);
}
