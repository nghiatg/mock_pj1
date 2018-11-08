/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hr;

/**
 * @author User
 *
 */
@Repository
public interface HrRepository extends JpaRepository<Hr, Integer>{

}
