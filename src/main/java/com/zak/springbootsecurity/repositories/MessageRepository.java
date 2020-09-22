package com.zak.springbootsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zak.springbootsecurity.entities.Message;

/**
 * @author Zakaria El Badri
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
